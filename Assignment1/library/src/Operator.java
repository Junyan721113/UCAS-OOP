import java.util.LinkedList;

public class Operator {
    public int hash;
    public String name, ID;
    public int level;
    public LinkedList<String> log = new LinkedList<>();
    public Operator(String name, String ID, int level) {
        this.name = name;
        this.ID = ID;
        this.hash = (name + ID).hashCode();
        this.level = level;
    }
    public boolean setLevel(int level) {
        this.level = level;
        return true;
    }
}
