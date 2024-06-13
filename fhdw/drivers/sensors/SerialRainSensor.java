package fhdw.drivers.sensors;

import obj.wetterstation.interfaces.IRain;
import obj.wetterstation.interfaces.ITemp;

import java.io.FileNotFoundException;
import java.util.Random;

public class SerialRainSensor implements IRain {
    private double read(){
        Random rand = new Random();
        return rand.nextDouble();
    }

    public double getSensorValue(){
        return read();
    }
}