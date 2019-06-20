public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Library lib;

        Book b1;
        Book b6;
        Book b9;
        Book b5;
        Book b4;

        b6 = new Book("6", "a6", "t6");
        b1 = new Book("1", "a1", "t1");
        b9 = new Book("9", "a9", "t9");
        b5 = new Book("5", "a5", "t5");


        lib = new Library();
        lib.sortedInsertion(b6);
        lib.sortedInsertion(b1);
        lib.sortedInsertion(b9);
        lib.sortedInsertion(b5);

        Book b = lib.searchForIsbn("5");
        System.out.println("FOUND -> " + b);

        lib.getStock().stream().forEach(book -> System.out.println(book.getIsbn()));

    }
}