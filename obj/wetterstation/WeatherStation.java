package obj.wetterstation;

import obj.wetterstation.interfaces.*;

import java.util.Random;

public class WeatherStation {

    ITemp pt100;
    IWind pt200;
    IRain pt300;
    IPressure pt400;
    IUSB pt500;

    public WeatherStation(ITemp pt100, IWind pt200, IRain pt300, IPressure pt400, IUSB pt500) {
        this.pt100 = pt100;
        this.pt200 = pt200;
        this.pt300 = pt300;
        this.pt400 = pt400;
        this.pt500 = pt500;
    }

    public double getTemperatur() {
        Random muenzwurf = new Random();
        if (muenzwurf.nextInt(4) > 2){
            System.out.println("Temperature Sensor failed! Using USB:");
            return pt500.getTemperatureInCelsius();
        }
        else {return pt100.getTemperatureInKelvin();}
    }

    public double getWindspeed() {
        return pt200.getWindspeedInKmH();
    }

    public double getRain() {return pt300.getSensorValue();}

    public double getPressure() {return pt400.getPressureInHPa();}
}