package obj;

import obj.wetterstation.interfaces.IClient;

public class Client implements IClient{

    @Override
    public void newWeatherData(String data) {
        System.out.printf("New Sensordata received: %s", data);
    }
    
}
