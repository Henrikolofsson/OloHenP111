public class Producer extends Thread {
    private Buffer<MessageProducer> producerBuffer;
    private Buffer<Message> messageBuffer;
    private MessageProducer messageProducer;
    private int delay;
    private int size;
    private int times;

    public Producer(Buffer<MessageProducer> prodBuffer, Buffer<Message> messageBuffer) {
        this.producerBuffer = prodBuffer;
        this.messageBuffer = messageBuffer;
    }

    public void run() {
        int prodbuffsize = producerBuffer.size();
        while(true) {
        //for (int i = 0; i < prodbuffsize; i++) {
            try {
                messageProducer = producerBuffer.get();
                delay = messageProducer.delay();
                size = messageProducer.size();
                times = messageProducer.times();
                Message message;

                for (int j = 0; j < times; j++) {
                    for (int k = 0; k < size; k++) {
                        message = messageProducer.nextMessage();
                        messageBuffer.put(message);
                        Thread.sleep(delay);
                        System.out.println(message.getText());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
