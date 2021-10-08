import java.util.Collection;

public class Book implements Comparable<Book> {

    private String isbn;
    private String author;
    private String title;

    public Book(String isbn) {
        this.setIsbn(isbn);
        this.setTitle("");
        this.setAuthor("");
    }

    public Book(String isbn, String author, String title){
        this.setIsbn(isbn);
        this.setAuthor(author);
        this.setTitle(title);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() { return this.isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAuthor() { return this.author; }
    public void setAuthor(String author) { this.author = author;}

    public int compareTo(Book book){
        return this.getIsbn().compareTo(book.getIsbn());
    }

    @Override
    public String toString(){
        return "Book: " + getTitle() + " Author: " + getAuthor() + " ISBN: " + getIsbn() ;
    }


}
