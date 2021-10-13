package collections2;

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

    @Override
    public int hashCode() {
        return this.isbn.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Book other = (Book) o;
        return this.isbn.equals(other.getIsbn());
    }

    @Override
    public int compareTo(Book book){
        return this.getIsbn().compareTo(book.getIsbn());
    }

    @Override
    public String toString(){
        return getTitle() + " by " + getAuthor() + " (ISBN " + getIsbn() + ")" ;
    }


}
