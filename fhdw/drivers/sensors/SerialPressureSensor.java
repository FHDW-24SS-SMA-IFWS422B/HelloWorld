package fhdw.drivers.sensors;

import obj.wetterstation.interfaces.IPressure;
import java.util.Random;

public class SerialPressureSensor implements IPressure {
    private double read() {
        Random rdn = new Random();
        return rdn.nextDouble();
    }

    @Override
    public double getPressureInHPa(){
        return read();
    }
}
