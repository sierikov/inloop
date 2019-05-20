public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Library lib;

        Book b0;
        Book b1;
        Book b2;
        Book b3;
        Book b4;

        b0 = new Book("0", "a0", "t0");
        b1 = new Book("1", "a1", "t1");
        b2 = new Book("2", "a2", "t2");
        b3 = new Book("3", "a3", "t3");
        b4 = new Book("4", "a2", "t4");

        lib = new Library();

        Book b = lib.searchForIsbn("0");
        System.out.println("FOUND -> " + b);
    }
}