import utility.SocketWrapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdministratorLogin {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        ArrayList<User> userLoggedIn = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(3000);
        StockSystem stockSystem = new StockSystem();
        Administrator administrator = new Administrator(stockSystem);
        Reader reader = new FileReader("init_stocks.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String str = bufferedReader.readLine();
            if (str == null) {
                break;
            }
            String[] token = str.split(" ");
            Stock stock = new Stock(token[0], Integer.parseInt(token[1]), Double.parseDouble(token[2]));
            stockSystem.addStock(stock);
        }
        bufferedReader.close();
        reader.close();
        System.out.println("Welcome to System Administration");
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String str = scanner.nextLine();
                String[] token = str.split(" ");
                try {
                    if (token[0].equals("I")) {
                        administrator.increaseStockPrice(token[1], Double.parseDouble(token[2]), userLoggedIn);
                    } else if (token[0].equals("D")) {
                        administrator.decreaseStockPrice(token[1], Double.parseDouble(token[2]), userLoggedIn);
                    } else if (token[0].equals("C")) {
                        administrator.changeStockCount(token[1], Integer.parseInt(token[2]), userLoggedIn);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        while (true) {
            Socket socket = serverSocket.accept();
            SocketWrapper socketWrapper = new SocketWrapper(socket);
            socketWrapper.write(stockSystem);
            User user = (User) socketWrapper.read();
            userLoggedIn.add(user);
            user.setSocketWrapper(socketWrapper);
            System.out.println(user + " connected");
            user.setStatus(0);
            new Thread(() -> {
                try {
                    while (true) {
                        String str = (String) socketWrapper.read();
                        String[] token = str.split(" ");
                        if (token[0].equals("login")) {
                            user.setStatus(1);
                            administrator.showNotification(user);
                            System.out.println(user + " logged in");
                        } else if (token[0].equals("logout")) {
                            user.setStatus(0);
                            System.out.println(user + " logged out");
                        } else if (token[0].equals("S") && user.getStatus() == 1) {
                            administrator.subscribeUser(user, token[1]);
                        } else if (token[0].equals("U") && user.getStatus() == 1) {
                            administrator.unsubscribeUser(user, token[1]);
                        } else if (token[0].equals("V") && user.getStatus() == 1) {
                            administrator.showStocks(user);
                        }
                    }
                } catch (IOException e) {
                    System.out.println(user + " disconnected");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        socketWrapper.closeConnection();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}
