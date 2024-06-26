package obj.wetterstation.interfaces;

public interface IPublisher {
    void subscribe(ISubscriber subscriber);

    void unsubscribe(ISubscriber subscriber);

    void notifySubscribers(String context);
}
