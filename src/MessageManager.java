import java.util.ArrayList;

public class MessageManager extends Thread {
    private Buffer<Message> messageBuffer;
    private Message message;
    private ArrayList<P1Viewer> viewers;

    public MessageManager(Buffer<Message> messageBuffer) {
        this.messageBuffer = messageBuffer;
        viewers = new ArrayList<>();
    }

    public void run() {
        while(!Thread.interrupted()) {
            try {
                    message = messageBuffer.get();
                    for(P1Viewer viewer : viewers)
                        viewer.setMessage(message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void setListenerViewer(P1Viewer p1Viewer) {
        viewers.add(p1Viewer);
    }
}
