package obj;

import obj.wetterstation.interfaces.ISubscriber;

public class ConcreteSubscriber implements ISubscriber {
    @Override
    public void update(String context) {
        System.out.println("Updated with context: " + context);
        // react on notification
    }
}