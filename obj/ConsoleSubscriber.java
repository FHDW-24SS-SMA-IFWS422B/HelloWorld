package obj;

import obj.wetterstation.interfaces.ISubscriber;

public class ConsoleSubscriber implements ISubscriber {

    @Override
    public void update(String data) {
        System.out.println("Weather update: " + data);
    }
}