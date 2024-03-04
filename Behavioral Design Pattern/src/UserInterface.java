import java.io.IOException;

public interface UserInterface {

    public void notifyUser(String message) throws IOException;
    public void addNotification(String message);
}
