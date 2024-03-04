import utility.SocketWrapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Administrator implements Serializable {
    private StockSystem stockSystem;

    public Administrator(StockSystem stockSystem) {
        this.stockSystem = stockSystem;
    }

    public StockSystem getStockSystem() {
        return stockSystem;
    }

    public void setStockSystem(StockSystem stockSystem) {
        this.stockSystem = stockSystem;
    }

    public void increaseStockPrice(String name, double amount, ArrayList<User> userLoggedIn) throws IOException {
        for (Stock stock : stockSystem.getStocks()) {
            if (stock.getName().equals(name)) {
                stock.setPrice(stock.getPrice() + amount);
                stock.notifyAllPrice(userLoggedIn);
            }
        }
    }

    public void decreaseStockPrice(String name, double amount, ArrayList<User> userLoggedIn) throws IOException {
        for (Stock stock : stockSystem.getStocks()) {
            if (stock.getName().equals(name)) {
                stock.setPrice(stock.getPrice() - amount);
                stock.notifyAllPrice(userLoggedIn);
            }
        }
    }

    public void changeStockCount(String name, int count, ArrayList<User> userLoggedIn) throws IOException {
        for (Stock stock : stockSystem.getStocks()) {
            if (stock.getName().equals(name)) {
                stock.setCount(count);
                stock.notifyAllCount(userLoggedIn);
            }
        }
    }

    public void showStocks(User user) throws IOException {
        String str = "";
        for (Stock stock : stockSystem.getStocks()) {
            if (stock.getSubscribers().contains(user)) {
                str = str + stock.getName() + " ";
            }
        }
        user.notifyUser(str);
    }

    public void showNotification(User user) throws IOException {
        String str = "";
        for (String message : user.getNotification()) {
            str = str + message + ", ";
        }
        user.getNotification().clear();
        user.notifyUser(str);
    }

    public void subscribeUser(User user, String str) {
        for (Stock stock : stockSystem.getStocks()) {
            if (stock.getName().equals(str)) {
                stock.addSubscriber(user);
            }
        }
    }

    public void unsubscribeUser(User user, String str) {
        for (Stock stock : stockSystem.getStocks()) {
            if (stock.getName().equals(str)) {
                stock.removeSubscriber(user);
            }
        }
    }
}
