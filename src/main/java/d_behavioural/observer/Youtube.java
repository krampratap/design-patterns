package d_behavioural.observer;

public class Youtube {
    public static void main(String[] args) {
        Channel mrBeast = new Channel();

        Subscriber s1 = new Subscriber("Mark rober");
        Subscriber s2 = new Subscriber("pew die pie");
        Subscriber s3 = new Subscriber("T-series");
        Subscriber s4 = new Subscriber("Jerry");

        mrBeast.subscribe(s1);
        mrBeast.subscribe(s2);
        mrBeast.subscribe(s3);
        mrBeast.subscribe(s4);


        s1.subscribeChannel(mrBeast);
        s2.subscribeChannel(mrBeast);
        s3.subscribeChannel(mrBeast);
        s4.subscribeChannel(mrBeast);

        mrBeast.upload("100 people compete in Hackathon");

        mrBeast.unSubscribe(s2);
        System.out.println("-----------------------------");
        mrBeast.upload("100 days in a mall");
    }
}
