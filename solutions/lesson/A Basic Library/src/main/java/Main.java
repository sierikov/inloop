public class Main {

    public static void main(String[] args) {
        Book book = new Book("Java for Dummies");
// Print the title of the book
        System.out.println(book);
        Library lib = new Library();
        lib.add(book);
        Book b1 = lib.search("Java for Dummies");
        System.out.println(b1);
    }
}
