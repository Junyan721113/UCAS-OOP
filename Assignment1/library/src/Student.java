import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Student {
    public int hash;
    public String name, ID;
    int maxBorrow;
    private final HashMap<Integer, ArrayList<Date>> borrowed = new HashMap<>();

    public Student(String name, String ID, int maxBorrow) {
        this.name = name;
        this.ID = ID;
        this.hash = (name + ID).hashCode();
    }

    public boolean borrowBook(Book book, Operator op) {
        if (book.storage <= 0) return false;
        ArrayList<Date> TimeStamps = borrowed.get(book.hash);
        if (TimeStamps == null) borrowed.put(book.hash, new ArrayList<>());
        if (TimeStamps.size() >= maxBorrow) return false;
        else {
            Date now = new Date();
            TimeStamps.add(now);
            borrowed.put(book.hash, TimeStamps);
            book.storage--;
            op.log.add("Borrow: " + now + ", Book: " + book.hash + ", Student: " + this.hash);
        }
        return true;
    }

    public boolean returnBook(Book book, Operator op) {
        ArrayList<Date> TimeStamps = borrowed.get(book.hash);
        if (TimeStamps == null) borrowed.put(book.hash, new ArrayList<>());
        if (TimeStamps.isEmpty()) return false;
        else {
            Date now = new Date();
            TimeStamps.remove(0);
            borrowed.put(book.hash, TimeStamps);
            book.storage++;
            op.log.add("Return: " + now + ", Book: " + book.hash + ", Student: " + this.hash);
        }
        return true;
    }
}
