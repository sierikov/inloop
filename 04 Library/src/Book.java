public class Book {

    private String title;

    public Book(String title) {
        setTitle(title);
        System.out.println("Book " + getTitle() + " created.");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return getTitle();
    }


}
