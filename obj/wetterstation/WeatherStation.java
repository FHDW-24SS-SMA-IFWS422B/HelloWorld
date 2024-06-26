package obj.wetterstation;

import obj.Publisher;
import obj.wetterstation.interfaces.*;
import java.util.Random;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Represents a weather station that collects data from various sensors.
 */
public class WeatherStation extends Publisher {
    private ITemp TemperatureSensor;
    private IWind WindSensor;
    private IRain RainSensor;
    private IPressure PressureSensor;
    private IUSB USBTemperatureSensor;
    private List<ISubscriber> subscribers = new CopyOnWriteArrayList<>();

    public WeatherStation(ITemp pt100, IWind pt200, IRain pt300, IPressure pt400, IUSB pt500) {
        this.TemperatureSensor = pt100;
        this.WindSensor = pt200;
        this.RainSensor = pt300;
        this.PressureSensor = pt400;
        this.USBTemperatureSensor = pt500;
    }

    public WeatherStation() {
    }

    public double getTemperatur() {
        Random muenzwurf = new Random();
        if (muenzwurf.nextInt(4) > 2) {
            System.out.println("Temperature Sensor failed! Using USB:");
            return USBTemperatureSensor.getTemperatureInCelsius();
        } else {
            return TemperatureSensor.getTemperatureInKelvin();
        }
    }

    public double getWindspeed() {
        return WindSensor.getWindspeedInKmH();
    }

    public double getRain() {
        return RainSensor.getSensorValue();
    }

    public double getPressure() {
        return PressureSensor.getPressureInHPa();
    }

    public String getState() {
        if (RainSensor.getSensorValue() > 8) {
            return "Starkregen";
        } else if (TemperatureSensor.getTemperatureInKelvin() > 300) {
            return "Hitzewelle";
        } else if (WindSensor.getWindspeedInKmH() > 10) {
            return "Starker Wind";
        } else {
            return "Gutes Wetter";
        }
    }

    public void processData() {
        String weatherData = readWeatherData();
        notifySubscribers(weatherData);
    }

    public String readWeatherData() {
        return "Status: " + getState() +"\n"+ 
               "Pressure: " + getPressure() +"\n"+ 
               "Rain: " + getRain() +"\n"+ 
               "Temperature: " + getTemperatur() +"\n"+ 
               "Windspeed: " + getWindspeed() +"\n";
    }

    public void businessLogic() {
        this.notifySubscribers("Context updated with new weather data");
    }

    public void run() throws Exception {
        while (true) {
            processData();
            System.out.println(readWeatherData());
            System.out.println("Data processed");

            Thread.sleep(5000); // alle 5 Sekunden aktualisieren
        }
    }

    // Methods to manage subscribers
    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String data) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(data);
        }
    }
}
