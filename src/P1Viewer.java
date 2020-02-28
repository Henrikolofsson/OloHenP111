
public class P1Viewer extends Viewer implements MessageHandler {
    private MessageManager messageManager;

    public P1Viewer(MessageManager messageManager, int width, int height) {
        super(width, height);
        this.messageManager = messageManager;
        messageManager.setListenerViewer(this);
    }

    @Override
    public void handleMessage(Message message) {
        setMessage(message);
        System.out.println(message);
    }
}
