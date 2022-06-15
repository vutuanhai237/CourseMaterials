package composite;

import java.util.ArrayList;

public interface Component {
    public String toString();
    public ArrayList < Component > getChildren();
    public boolean addComponent(Component c);
    public boolean removeComponent(Component c);
}
