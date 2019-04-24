import java.util.Objects;

class List {

    private static int size;
    private ListElement head;

    // appends the specified element to the end of this list.
    public void append(String data) {

        // Initialize ListElement only incase of 1st element
        if (this.head == null) {
            this.head = new ListElement(data);
            return;
        }

        ListElement tempElement = new ListElement(data);
        ListElement currElement = this.head;

        if (currElement != null) {

            while (currElement.getNext() != null) { currElement = currElement.getNext(); }
            currElement.setNext(tempElement);
        }
        incrementSize();

    }

    private static int getSize() { return size; }
    private static void incrementSize() { size++; }
    private void decrementSize() { size--; }

    public String remove(String content) {
        // Store head ListElement 
        ListElement currListElement = this.head, prev = null;
        String data;
        // 
        // CASE 1: 
        // If head ListElement itself holds the key to be deleted

        if (currListElement != null && currListElement.getContent().equals(content) ) {
            System.out.println("curElem = " + currListElement.getContent());
            System.out.println("content = " + content);
            System.out.println("Head = " + this.head.getContent());
            data = currListElement.getContent();
            this.head = currListElement.getNext(); // Changed head


            // Display the message 
            System.out.println(data + " found and deleted head");

            // Return the updated List
            decrementSize();
            return data;
        }


        // 
        // CASE 2: 
        // If the key is somewhere other than at head 
        // 

        // Search for the key to be deleted, 
        // keep track of the previous ListElement 
        // as it is needed to change currListElement.next 
        while (currListElement != null && !currListElement.getContent().equals(content)) {
            // If currListElement does not hold key 
            // continue to next ListElement 
            prev = currListElement;
            currListElement = currListElement.getNext();
        }

        // If the key was present, it should be at currListElement 
        // Therefore the currListElement shall not be null 
        if (currListElement != null) {
            // Since the key is at currListElement 
            // Unlink currListElement from linked list
            data = currListElement.getContent();
            Objects.requireNonNull(prev).setNext(currListElement.getNext());

            // Display the message 
            System.out.println(data + " found and deleted");
            decrementSize();
            return data;
        }

        // 
        // CASE 3: The key is not present 
        // 

        // If key was not present in linked list 
        // currListElement should be null 
        if (currListElement == null) {
            // Display the message 
            System.out.println(content + " not found");
        }

        // return the List
        return null;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        if (this.head != null) {
            ListElement currElement = this.head.getNext();
            while (currElement != null) {
                output.append("[").append(currElement.getContent()).append("]");
                currElement = currElement.getNext();
            }

        }
        return output.toString();
    }
}