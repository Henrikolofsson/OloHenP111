import javax.swing.*;
import java.awt.*;

public class P1Viewer extends JPanel {
    private MessageManager messageManager;
    private int height;
    private int width;

    public P1Viewer(MessageManager messageManager, int width, int height) {
        this.messageManager = messageManager;
        this.width = width;
        this.height = height;

        this.setSize(new Dimension(width,height));
        this.setMinimumSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());
    }
}
