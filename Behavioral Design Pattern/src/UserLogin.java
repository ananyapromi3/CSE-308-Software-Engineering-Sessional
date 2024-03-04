import utility.SocketWrapper;

import java.io.IOException;
import java.util.Scanner;

public class UserLogin {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        SocketWrapper socketWrapper = new SocketWrapper("127.0.0.1", 3000);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stock System");
        StockSystem stockSystem = (StockSystem) socketWrapper.read();
        System.out.println("NAME\tPRICE\tCOUNT");
        for (Stock stock : stockSystem.getStocks()) {
            System.out.println(stock.getName() + "\t\t" + stock.getPrice() + "\t" + stock.getCount());
        }
        User user = new User();
        socketWrapper.write(user);
        new Thread(() -> {
            try {
                while (true) {
                    String str = (String) socketWrapper.read();
                    System.out.println(str);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            } finally {
                try {
                    socketWrapper.closeConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            try {
                while (true) {
                    String str = scanner.nextLine();
                    socketWrapper.write(str);
                }
            } catch (IOException e) {
                System.out.println("Administrator disconnected");
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
