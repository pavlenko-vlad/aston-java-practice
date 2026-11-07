import java.util.Objects;

public class Book {
    private final String title;
    private final int pageCount;
    private final int year;

    public Book(String title, int pageCount, int year) {
        this.title     = Objects.requireNonNull(title, "title");
        this.pageCount = pageCount;
        this.year      = year;
    }

    public String getTitle()     { return title; }
    public int    getPageCount() { return pageCount; }
    public int    getYear()      { return year; }

    // для distinct(): сравниваем все три поля
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return pageCount == b.pageCount
                && year == b.year
                && title.equals(b.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pageCount, year);
    }

    @Override
    public String toString() {
        return "Book{" + title + ", pages=" + pageCount + ", year=" + year + '}';
    }
}