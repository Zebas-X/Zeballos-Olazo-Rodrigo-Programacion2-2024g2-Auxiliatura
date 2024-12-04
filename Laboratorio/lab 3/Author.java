import java.util.List;
import java.util.ArrayList;

public class Author {
    private String name;
    private List<Book> books;

    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(String title, double price) {
        books.add(new Book(title, this, price));
    }

    public List<Book> getBooks() {
        return books;
    }
}
