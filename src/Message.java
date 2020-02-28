import javax.swing.*;
import java.io.Serializable;

public class Message implements Serializable {
    private String text;
    private Icon icon;

    public Message(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", icon=" + icon +
                '}';
    }
}
