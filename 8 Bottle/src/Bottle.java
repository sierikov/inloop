public class Bottle<T extends Drink> {
    private T content;

    public Bottle() {
        this.content = null;
    }

    public boolean isEmpty() {
        return this.getContent() == null;
    }

    public void fill(T content) {
        if (this.isEmpty()) this.setContent(content);
        else throw new IllegalStateException("Bottle is not empty!");
    }

    public T empty() {
        if (!this.isEmpty()) {
            T content = this.content;
            this.setContent(null);
            return content;
        } else throw new IllegalStateException("Bottle is empty!");
    }

    private T getContent() {
        return content;
    }

    private void setContent(T content) {
        this.content = content;
    }
}
