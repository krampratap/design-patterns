package d_Behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    //Observe that the subs is a private variable and not a static..
    //AS each channel will have its own subs so not static and we should not allow subs to be accessed by outside so private.
    private List<Subscriber> subs = new ArrayList<>();
    private String title;

    public void subscribe(Subscriber sub){
        subs.add(sub);
    }

    public String getTitle() {
        return title;
    }

    public void unSubscribe(Subscriber sub){
        subs.remove(sub);
    }

    public void notifySubscribers(){
        for(Subscriber sub: subs){
            sub.update();
        }
    }

    public void upload(String title){
        this.title = title;
        notifySubscribers();
    }
}
