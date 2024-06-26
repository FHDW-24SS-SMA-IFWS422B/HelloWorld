package fhdw.drivers.sensors;

import obj.wetterstation.interfaces.IWind;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Fictional windspeed driver
 * @author Matthias Füller
 *
 */
public class SerialWindspeedDriver implements IWind {

    /**
     * Init SerialDriver with given serial device
     * @param devicename
     * @throws FileNotFoundException
     */
    public SerialWindspeedDriver(String devicename) throws FileNotFoundException {
        if (devicename.equals("/dev/tty1") == false) {
            throw new FileNotFoundException("Could not find serial device");
        }
    }

    /**
     * Return the current windspeed in m/s
     * @return current windspeed in m/s
     */
    private int read() {
        Random rnd = new Random();
        return 50 * rnd.nextInt();
    }

    @Override
    public double getWindspeedInKmH() {
        return read();
    }
}