import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Stock implements Serializable {
    private String name;
    private int count;
    private double price;
    private ArrayList<User> subscribers;

    public Stock(String name, int count, double price) {
        this.name = name;
        this.count = count;
        this.price = price;
        subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        System.out.println("Set count of " + name + " to " + count);
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.println("Set price of " + name + " to " + price);
        this.price = price;
    }

    public ArrayList<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<User> subscribers) {
        this.subscribers = subscribers;
    }

    public void addSubscriber(User user) {
        subscribers.add(user);
        System.out.println(user + " subscribed to " + name);
    }

    public void removeSubscriber(User user) {
        subscribers.remove(user);
        System.out.println(user + " unsubscribed from " + name);
    }

    public boolean findSubscriber(User user) {
        if (subscribers.contains(user)) {
            return true;
        }
        return false;
    }

    public void notifyAllPrice(ArrayList<User> userLoggedIn) throws IOException {
        for (User user : subscribers) {
            if (userLoggedIn.contains(user) && user.getStatus() == 1) {
                user.notifyUser("Stock " + name + " price updated to " + price);
            } else {
                user.addNotification("Stock " + name + " price updated to " + price);
            }
        }
    }

    public void notifyAllCount(ArrayList<User> userLoggedIn) throws IOException {
        for (User user : subscribers) {
            if (userLoggedIn.contains(user) && user.getStatus() == 1) {
                user.notifyUser("Stock " + name + " count updated to " + count);
            } else {
                user.addNotification("Stock " + name + " count updated to " + count);
            }
        }
    }
}
