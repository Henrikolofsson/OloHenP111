import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ObjectfileProducer implements MessageProducer {
    private int delay;
    private int times;
    private int size;
    private Message message;
    private ArrayList<Message> messages;
    int index = 0;

    public ObjectfileProducer(String path) {
        try {
            File txtFile = new File(path);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(txtFile), StandardCharsets.UTF_8));
            try {
                messages = new ArrayList<>();
                times = Integer.parseInt(reader.readLine());
                delay = Integer.parseInt(reader.readLine());
                size = Integer.parseInt(reader.readLine());
                String messageText;
                ImageIcon messageIcon;

                while(reader.readLine() != null) {
                    messageText = reader.readLine();
                    messageIcon = new ImageIcon(reader.readLine());
                    messages.add(new Message(messageText, messageIcon));
                }
            } catch(UnsupportedEncodingException e) {
                System.out.println("Problem with encoding in textfile");
                e.printStackTrace();
            } catch(IOException e) {
                System.out.println("Problem with reading textfile");
                e.printStackTrace();
            }

        } catch(FileNotFoundException e) {
            System.out.println("Problem with textfile");
            e.printStackTrace();
        }
    }

    @Override
    public int delay() {
        return delay;
    }

    @Override
    public int times() {
        return times;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Message nextMessage() {
        if(size()==0)
            return null;
        index = (index+1) % messages.size();
        return messages.get(index);
    }
}
