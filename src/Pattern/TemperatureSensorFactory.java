package src.Pattern;

import java.io.FileNotFoundException;

import obj.wetterstation.interfaces.ITemp;
import obj.wetterstation.interfaces.IUSB;

public abstract class TemperatureSensorFactory {
    public void readUserConfig() {
        // read user config
    }

    public abstract ITemp createTemp() throws FileNotFoundException;
    public abstract IUSB createUSB();
}

