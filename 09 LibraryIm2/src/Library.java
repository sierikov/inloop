import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Library {
    private Set<Book> stock = new HashSet<>();
    private Set<Book> found = new HashSet<>();

    public Library() {
        System.out.println("Hello, I am a library, which can store stock!");
    }

    public boolean insertBook(Book newBook) {
        if (!stock.contains(newBook)){
            stock.add(newBook);
            System.out.println("Added new " + newBook);
            return true;
        } else return false;
    }


    public Book searchForIsbn(String isbn) {
        return stock.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public Collection<Book> searchForAuthor(String author) {
        return stock.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public Map<String, Set<Book>> listStockByAuthor() {
        return stock.stream().collect(Collectors.groupingBy(Book::getAuthor, toSet()));
    }
}
