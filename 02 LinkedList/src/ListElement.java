class ListElement {


    private String content;
    private ListElement next;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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