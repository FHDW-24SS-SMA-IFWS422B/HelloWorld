package fhdw.drivers.sensors;

import obj.wetterstation.interfaces.IUSB;

import java.util.Random;

public class USBTemperatureDriver implements IUSB {
    public USBTemperatureDriver() {
    
    }
    
    private int read() {
        Random rnd = new Random();
        return rnd.nextInt(32)*10;
    }
    @Override
    public int getTemperatureInCelsius() {
        return read();
    }

    public double readTemperature() {
        return read();
    }
}