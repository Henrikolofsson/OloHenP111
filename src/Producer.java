public class Producer {
    private Buffer<MessageProducer> producerBuffer;
    private Buffer<Message> messageBuffer;
    private ProducerThread prodThread;

    public Producer(Buffer<MessageProducer> prodBuffer, Buffer<Message> messageBuffer) {
        this.producerBuffer = prodBuffer;
        this.messageBuffer = messageBuffer;
        prodThread = new ProducerThread(prodBuffer, messageBuffer);
    }

    //TODO
    public void start() {
        prodThread.start();
    }

    private class ProducerThread extends Thread {
        private Buffer<MessageProducer> producerBuffer;
        private Buffer<Message> messageBuffer;
        private MessageProducer messageProducer;
        private int delay;
        private int size;
        private int times;

        public ProducerThread(Buffer<MessageProducer> prodBuffer, Buffer<Message> messageBuffer) {
            this.producerBuffer = prodBuffer;
            this.messageBuffer = messageBuffer;
        }

        public synchronized void start() {
            for(int i = 0; i < producerBuffer.size(); i++) {
                try {
                    for (int j = 0; j < producerBuffer.get().size(); j++) {
                        messageBuffer.put(producerBuffer.get().nextMessage());
                        wait(producerBuffer.get().delay());
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }
    }
}
