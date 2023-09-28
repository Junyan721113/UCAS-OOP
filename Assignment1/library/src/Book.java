public class Book {
    public int hash;
    public String name, ISBN;
    public int storage;

    public Book(String name, String ISBN, int storage) {
        this.name = name;
        this.ISBN = ISBN;
        this.hash = (name + ISBN).hashCode();
        this.storage = storage;
    }
}
