import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Root implements Component {
    private static Root root = null;
    private String name;
    long componentSize;
    ComponentType componentType;
    String directory;
    int component_count;
    Time creationTime;
    private List<Component> components;

    private Root(String name) {
        this.name = name;
        this.components = new ArrayList<Component>();
        componentSize = 0;
        componentType = ComponentType.Root;
        component_count = 0;
        creationTime = new Time(System.currentTimeMillis());
        directory = name + ":~";
    }

    public static Root getInstance(String name) {
        if (root == null) {
            root = new Root(name);
        }
        return root;
    }

    @Override
    public Component findComponent(String name) {
        for (Component component : components) {
            if (component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }

    @Override
    public Component changingDirectory(String name) {
        Component component = findComponent(name);
        if (component instanceof File) {
            System.out.println("Error: " + name + " is a file.");
            return this;
        } else if (component == null) {
            System.out.println("Error: " + name + " does not exist.");
            return this;
        }
        return component;
    }

    @Override
    public void details(String name) {
        Component component = findComponent(name);
        if (component == null) {
            System.out.println("Error: " + name + " not found.");
        } else {
            System.out.println("Name: " + component.getName());
            System.out.println("Type: " + component.getComponentType());
            System.out.println("Size: " + component.getComponentSize());
            System.out.println("Directory: \"" + component.getDirectory() + "\"");
            System.out.println("Component Count: " + component.getComponent_count());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy hh:mm a");
            String formattedTime = dateFormat.format(new Date(component.getCreationTime().getTime()));
            System.out.println("Creation Time: " + formattedTime);
        }
    }

    @Override
    public void listing() {
        for (Component component : components) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedTime = dateFormat.format(new Date(component.getCreationTime().getTime()));
            System.out.println(component.getName() + "\t" + component.getComponentSize() + " kB\t" + formattedTime);
        }
    }

    @Override
    public void delete(String name) {
        Component component = findComponent(name);
        if (component == null) {
            System.out.println("Error: " + name + " not found.");
        } else if (component instanceof File) {
            components.remove(component);
            component_count--;
        } else {
            if (component.getComponent_count() == 0) {
                components.remove(component);
                component_count--;
            } else {
                System.out.println("Error: Cannot delete " + component.getComponentType());
            }
        }
    }

    @Override
    public void recursiveDelete(String name) {
        Component component = findComponent(name);
        if (component == null) {
            System.out.println("Error: " + name + " not found");
        } else if (component instanceof File) {
            System.out.println("Warning: " + component.getName() + " will be permanently deleted");
            components.remove(component);
            component_count--;
        } else {
            List<String> componentsToRemove = new ArrayList<>();
            for (Component temp : component.getComponents()) {
                componentsToRemove.add(temp.getName());
            }
            for (String temp : componentsToRemove) {
                component.recursiveDelete(temp);
            }
            components.remove(component);
            component_count--;
        }
    }

    @Override
    public Component makeDir(String name) {
        Component component = findComponent(name);
        if (component == null) {
            component = new Folder(name, this.getDirectory());
            components.add(component);
            component_count++;
            return component;
        }
        System.out.println("Error: Directory already exists.");
        return this;
    }

    @Override
    public void touch(String name, double size) {
        Component component = findComponent(name);
        if (component == null) {
            component = new File(name, size, this.getDirectory());
            components.add(component);
            component_count++;
            componentSize += size;
        } else {
            System.out.println("Error: File already exists");
        }
    }

    @Override
    public Component makeDrive(String name) {
        Component component = findComponent(name);
        if (component == null) {
            component = new Drive(name, this.getDirectory());
            components.add(component);
            component_count++;
            return component;
        }
        System.out.println("Error: Drive already exists.");
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getComponentSize() {
        double temp = 0.0;
        for (Component component : components) {
            temp += component.getComponentSize();
        }
        return temp;
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
        return component_count;
    }

    @Override
    public Time getCreationTime() {
        return creationTime;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }
}
