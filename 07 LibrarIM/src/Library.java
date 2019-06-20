import java.util.*;

public class Library {
    public List<Book> getStock() {
        return stock;
    }

    private List<Book> stock = new ArrayList<>();
    private List<Book> found = new ArrayList<>();

    public Library() {
        System.out.println("Hello, I am a library, which can store stock!");
    }

    public void sortedInsertion(Book newBook) {
        Objects.requireNonNull(newBook);
        for (int i = 0; i < this.stock.size(); i++) {
            Book b = this.stock.get(i);
            if (b.compareTo(newBook) >= 0) {
                stock.add(i, newBook);
                return;
            }
        }
        stock.add(newBook);
        System.out.println("Added new " + newBook);
    }

    public List<Book> searchForAuthor(String author) {
        this.found.clear();
        for (Book book : stock) {
            if (book.getAuthor().equals(author))
                found.add(book);
        }
        return found;
    }


    public Book searchForIsbn(String s) {
        Comparator<Book> comparator = Book::compareTo;
        int index = Collections.binarySearch(stock, new Book(s), comparator);
        return index < 0 ?  null : stock.get(index) ;
    }
}
