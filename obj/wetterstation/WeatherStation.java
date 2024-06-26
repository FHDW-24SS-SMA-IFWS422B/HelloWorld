package obj.wetterstation;

import obj.wetterstation.interfaces.*;

import java.util.Random;

public class WeatherStation {

    ITemp TemperatureSensor;
    IWind WindSensor;
    IRain RainSensor;
    IPressure PressureSensor;
    IUSB USBTemperatureSensor;
    IClient Client;
    String data;
    static String State;

    public WeatherStation(ITemp pt100, IWind pt200, IRain pt300, IPressure pt400, IUSB pt500) {
        this.TemperatureSensor = pt100;
        this.WindSensor = pt200;
        this.RainSensor = pt300;
        this.PressureSensor = pt400;
        this.USBTemperatureSensor = pt500;
    }

    public double getTemperatur() {
        Random muenzwurf = new Random();
        if (muenzwurf.nextInt(4) > 2){
            System.out.println("Temperature Sensor failed! Using USB:");
            return USBTemperatureSensor.getTemperatureInCelsius();
        }
        else {return TemperatureSensor.getTemperatureInKelvin();}
    }

    public double getWindspeed() {
        return WindSensor.getWindspeedInKmH();
    }

    public double getRain() {return RainSensor.getSensorValue();}

    public double getPressure() {return PressureSensor.getPressureInHPa();}
    
    public String getState() {

        if(RainSensor.getSensorValue() > 8) {
            return "Starkregen";
        }
        else if(TemperatureSensor.getTemperatureInKelvin() > 300) {
            return "Hitzewelle";
        }
        else if(WindSensor.getWindspeedInKmH() > 50) {
            return "Gutes Wetter";
        }
        else {
            return "Gutes Wetter";
        }
    }

    public void processData() {
        data = readWeatherData();
        Client.newWeatherData(data);
    }

    public String readWeatherData() {
        return "Status: " + getState() + "Pressure: " + PressureSensor.getPressureInHPa() + " Rain: " + RainSensor.getSensorValue() + " Temperature: " + TemperatureSensor.getTemperatureInKelvin() + " Windspeed: " + WindSensor.getWindspeedInKmH();
    }

    public void run() throws Exception {
        while (true) {
            processData();
            Thread.sleep(1000);
            System.out.println(readWeatherData());
            System.out.println("Data processed");

            Thread.sleep(10000);
        }
    }
}