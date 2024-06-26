package obj;

import java.util.ArrayList;
import java.util.List;

import obj.wetterstation.interfaces.ISubscriber;

public class Publisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String context) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(context);
        }
    }
}

