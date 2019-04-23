import java.util.Objects;

class ListElement {


    private String content;
    private ListElement next;

    public String getContent() {
        return this.content.toString();
    }

    public void setContent(String content) {
        if (content.isEmpty()) {
            throw new IllegalArgumentException("Illegal argument value");
        }
        else if (content == null){
            throw new NullPointerException("The argument 'content' cannot be empty!");
        }
        else this.content = content;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    public boolean hasNext(){
        return getNext() == null;
    }

    public ListElement(String content) {
        setContent(content);
        setNext(null);
    }


}