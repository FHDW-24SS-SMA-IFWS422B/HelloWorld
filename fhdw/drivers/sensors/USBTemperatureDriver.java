package fhdw.drivers.sensors;

import obj.wetterstation.interfaces.IUSB;

import java.sql.Driver;
import java.util.Random;

public class USBTemperatureDriver implements IUSB {
    private int read() {
        Random rnd = new Random();
        return rnd.nextInt(32)*10;
    }
    @Override
    public int getTemperatureInCelsius() {
        return read();
    }
}