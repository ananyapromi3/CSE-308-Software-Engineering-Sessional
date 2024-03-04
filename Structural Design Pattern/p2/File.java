import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class File implements Component {
    private String name;
    double componentSize;
    ComponentType componentType;
    String directory;
    Time creationTime;

    public File(String name, double fileSize, String parentDirectory) {
        this.name = name;
        componentSize = fileSize;
        componentType = ComponentType.File;
        creationTime = new Time(System.currentTimeMillis());
        directory = parentDirectory + "/" + name;
    }

    @Override
    public Component findComponent(String name) {
        return null;
    }

    @Override
    public Component changingDirectory(String name) {
        return null;
    }

    @Override
    public void details(String name) {
    }

    @Override
    public void listing() {
    }

    @Override
    public void delete(String name) {
    }

    @Override
    public void recursiveDelete(String name) {
    }

    @Override
    public Component makeDir(String name) {
        return null;
    }

    @Override
    public void touch(String name, double size) {
    }

    @Override
    public Component makeDrive(String name) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getComponentSize() {
        return componentSize;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public int getComponent_count() {
        return 0;
    }

    @Override
    public Time getCreationTime() {
        return creationTime;
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }
}
