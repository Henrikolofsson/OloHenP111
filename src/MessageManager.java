import java.util.ArrayList;

public class MessageManager extends Thread {
    private Buffer<Message> messageBuffer;
    private Message message;
    private ArrayList<P1Viewer> viewers;

    public MessageManager(Buffer<Message> messageBuffer) {
        this.messageBuffer = messageBuffer;
        viewers = new ArrayList<>();
    }

    public void start() {
        while(!Thread.interrupted()) {
            try {
                message = messageBuffer.get();
                System.out.println(message);
                if(message != null) {
                    for(P1Viewer viewer : viewers) {
                        viewer.handleMessage(message);
                    }
                }
                Thread.sleep(50);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setListenerViewer(P1Viewer p1Viewer) {
        viewers.add(p1Viewer);
    }
}
