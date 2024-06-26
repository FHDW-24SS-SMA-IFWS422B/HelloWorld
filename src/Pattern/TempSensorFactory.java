package src.Pattern;

import java.io.FileNotFoundException;

import fhdw.drivers.sensors.SerialTemperatureDriver;

//Hier müssen aktuell noch die Interfaces eingefügt werden so richtig?
import obj.wetterstation.interfaces.IUSB;
import obj.wetterstation.interfaces.ITemp;

public class TempSensorFactory extends TemperatureSensorFactory{
    
    @Override
    public ITemp createTemp() throws FileNotFoundException {
        return new SerialTemperatureDriver("/dev/tty0");
    }

    @Override
    public IUSB createUSB() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUSB'");
    }   
}

