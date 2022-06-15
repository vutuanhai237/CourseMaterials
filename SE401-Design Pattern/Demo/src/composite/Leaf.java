package composite;

import java.util.ArrayList;

public class Leaf implements Component {
    private String id;

    public Leaf(String identification) {
        id = identification;
    }

    public String toString() {
        return id;
    }
    public ArrayList < Component > getChildren() {
        return null;
    }
    public boolean addComponent(Component c) {
        return false;
    }
    public boolean removeComponent(Component c) {
        return false;
    }
}