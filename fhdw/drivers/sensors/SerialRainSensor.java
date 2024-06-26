package fhdw.drivers.sensors;

import obj.wetterstation.interfaces.IRain;

import java.util.Random;

public class SerialRainSensor implements IRain {
    private int read(){
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public double getSensorValue(){
        return read();
    }
}