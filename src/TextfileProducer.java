import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TextfileProducer implements MessageProducer {
    private int delay;
    private int times;
    private int size;
    private Message[] messages;
    private int index = -1;

    public TextfileProducer(String path) {
        try {
            File txtFile = new File(path);
            BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(new FileInputStream(txtFile), StandardCharsets.UTF_8));
            try {
                times = Integer.parseInt(reader.readLine());
                delay = Integer.parseInt(reader.readLine());
                size = Integer.parseInt(reader.readLine());
                messages = new Message[size];
                String messageText;
                ImageIcon messageIcon;

                for(int i = 0; i < size; i++) {
                    messageText = reader.readLine();
                    messageIcon = new ImageIcon(reader.readLine());
                    messages[i] = new Message(messageText, messageIcon);
                }

                for(int i = 0; i < size; i++) {
                    System.out.println(messages[i]);
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
        index = (index+1) % messages.length;
        return messages[index];
    }
}
