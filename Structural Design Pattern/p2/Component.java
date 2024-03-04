import java.sql.Time;
import java.util.List;

public interface Component {

    Component findComponent(String name);

    Component changingDirectory(String name);

    void details(String name);

    void listing();

    void delete(String name);

    void recursiveDelete(String name);

    Component makeDir(String name);

    void touch(String name, double size);

    Component makeDrive(String name);

    String getName();

    double getComponentSize();

    ComponentType getComponentType();

    String getDirectory();

    int getComponent_count();

    Time getCreationTime();

    List<Component> getComponents();
}
