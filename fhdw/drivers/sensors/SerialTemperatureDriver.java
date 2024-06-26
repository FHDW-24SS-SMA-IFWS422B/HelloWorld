package fhdw.drivers.sensors;

import obj.wetterstation.interfaces.ITemp;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Fictional driver to represent a serial temperatur sensor
 * @author Matthias Füller
 *
 */
public class SerialTemperatureDriver implements ITemp {

    /**
     * Init SerialDriver with given serial device
     * @param devicename
     * @throws FileNotFoundException
     */
    public SerialTemperatureDriver(String devicename) throws FileNotFoundException {
        if (devicename.equals("/dev/tty0") == false) {
            throw new FileNotFoundException("Could not find serial device");
        }
    }

    /**
     * Return the current temperature in Kelvin
     * @return current temperature in Kelvin
     */
    private double read() {
        Random rnd = new Random();

        return 273.15 - 20 + 50 * rnd.nextDouble();
    }

    @Override
    public double getTemperatureInKelvin() {
        return read();
    }

    public double readTemperature() {
        return read();
    }
}