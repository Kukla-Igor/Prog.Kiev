package ua.kiev.prog;

public class Book {
    private String name;
    private int pages;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                '}';
    }
}
