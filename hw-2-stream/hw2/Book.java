package hw2;

import java.util.Objects;

public class Book {
    private String title;
    private int pageCount;
    private int year;

    public Book() {
    }

    public Book(String title, int pageCount, int year) {
        this.title = title;
        this.pageCount = pageCount;
        this.year = year;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return pageCount == b.pageCount && year == b.year && Objects.equals(title, b.title);
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