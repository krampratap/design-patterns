package behavioural.observer;
//Here the Subscriber is the Observer
public class Subscriber {
    private String name;
    //Assuming one subscriber one channel
    private Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(){
        System.out.println("Hey " + name + ", Video uploaded : "+ channel.getTitle());
    }

    public void subscribeChannel(Channel channel){
        this.channel = channel;
    }
}
