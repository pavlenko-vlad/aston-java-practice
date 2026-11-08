package hw2;

import java.util.List;

public class Student {
    private String name;
    private List<Book> books;

    public Student() {
    }

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
        if (this.books != null && this.books.size() < 5) {
            throw new IllegalArgumentException("У студента " + name + " меньше 5 книг!");
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { 
        this.books = books;

    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', books=" + books + '}';
    }
}