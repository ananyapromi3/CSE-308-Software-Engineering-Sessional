import utility.SocketWrapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements UserInterface, Serializable {
    private SocketWrapper socketWrapper;
    private ArrayList<String> notification;
    private int status;

    public User() {
        notification = new ArrayList<>();
        status = 0;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<String> getNotification() {
        return notification;
    }

    public void setNotification(ArrayList<String> notification) {
        this.notification = notification;
    }

    @Override
    public void addNotification(String message) {
        notification.add(message);
    }

    public SocketWrapper getSocketWrapper() {
        return socketWrapper;
    }

    public void setSocketWrapper(SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
    }

    @Override
    public void notifyUser(String message) throws IOException {
        socketWrapper.write(message);
    }
}
