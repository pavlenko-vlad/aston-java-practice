import java.util.List;
import java.util.Objects;

public class Student {
    private final String name;
    private final List<Book> books;   // обязательное поле, ≥ 5 книг

    public Student(String name, List<Book> books) {
        this.name  = Objects.requireNonNull(name, "name");
        this.books = List.copyOf(Objects.requireNonNull(books, "books"));
        
    }

    public String     getName()  { return name; }
    public List<Book> getBooks() { return books; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', books=" + books + '}';
    }
}
