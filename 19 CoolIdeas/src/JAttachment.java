import java.io.File;
import java.util.Objects;

public class JAttachment extends JContent {
    private File file;

    public JAttachment(String title, String description, File file) {
        super(title, description);
        this.file = Objects.requireNonNull(file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = Objects.requireNonNull(file);
    }

    @Override
    public String toString() {
        return "Attachment: " + super.getTitle() + '\n' +
                super.getDescription();
    }
}
