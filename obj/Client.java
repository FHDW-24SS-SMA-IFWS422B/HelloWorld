package obj;

import obj.wetterstation.WeatherStation;

public class Client {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        ConcreteSubscriber concreteSubscriber = new ConcreteSubscriber();

        weatherStation.subscribe(concreteSubscriber);
        weatherStation.businessLogic(); // this should trigger the update method of concreteSubscriber
    }
}