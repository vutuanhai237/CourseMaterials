package composite;

import java.util.ArrayList;

public class Composite implements Component {
    private String id;
    private ArrayList < Component > components = new ArrayList < Component > ();

    public Composite(String identification) {
        id = identification;
    }

    public String toString() {
        String s = " (" + id + ":";
        for (Component child: this.getChildren())
            s += " " + child.toString();
        return s + ") ";
    }

    public ArrayList < Component > getChildren() {
        return components;
    }
    public boolean addComponent(Component c) {
        return components.add(c);
    }
    public boolean removeComponent(Component c) {
        return components.remove(c);
    }
}