package src.Pattern;

import fhdw.drivers.sensors.USBTemperatureDriver;

//Hier müssen aktuell noch die Interfaces eingefügt werden so richtig?
import obj.wetterstation.interfaces.ITemp;
import obj.wetterstation.interfaces.IUSB; 

public class USBTempSensorFactory extends TemperatureSensorFactory{
    
    @Override
    public IUSB createUSB() {
        return new USBTemperatureDriver();
    }

    @Override
    public ITemp createTemp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTemp'");
    }
}
