import java.util.ArrayList;

public class Library {
    private static final int MAX_AMOUNT = 10;
    private ArrayList<Book> books = new ArrayList<>();

    public Library() {
        System.out.println("Hello, I am a library, which can store up to " + MAX_AMOUNT +" books!");
    }

    public void add(Book book){
        if (books.size() < MAX_AMOUNT) {
            books.add(book);
            System.out.println("I added the book " + book.getTitle() +"!");
        } else {
            System.out.println("The library is full!");
        }
    }

    public Book search(String title){
        return this.books.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findAny()
                .map(this::bookExist)
                .orElseGet(() -> this.bookNotExist(title));
    }

    private Book bookNotExist(String title) {
        System.out.println("The book with the title " + title + " does not exist in the library!");
        return null;
    }

    private Book bookExist(Book book) {
        System.out.println("The book with the title " + book.getTitle() +" exists in the library!");
        return book;
    }


}
