public class MessageProducerInput {
    private Buffer<MessageProducer> producerBuffer;

    public MessageProducerInput(Buffer<MessageProducer> prodBuffer) {
        this.producerBuffer = prodBuffer;
    }

    public void addMessageProducer(MessageProducer m) {
        producerBuffer.put(m);
    }
}
