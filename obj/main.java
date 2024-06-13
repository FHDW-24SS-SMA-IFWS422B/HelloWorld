package obj;

import obj.wetterstation.WeatherStation;
import obj.wetterstation.interfaces.*;
import fhdw.drivers.sensors.*;

import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        ITemp tempSensor = new SerialTemperatureDriver("/dev/tty0");
        IWind windSensor = new SerialWindspeedDriver("/dev/tty1");
        IUSB usbSensor = new USBTemperatureDriver();
        IPressure pressureSensor = new SerialPressureSensor();
        IRain rainSensor = new SerialRainSensor();
        WeatherStation weatherstation = new WeatherStation(tempSensor, windSensor, rainSensor, pressureSensor, usbSensor);


        System.out.println(String.format("%.2f mm/h", weatherstation.getRain()));
        System.out.println(String.format("%.2f hPa", weatherstation.getPressure()));
        System.out.println(String.format("%.2f C", weatherstation.getTemperatur()));

        System.out.println(String.format("%.2f C", weatherstation.getTemperatur()));
        System.out.println(String.format("%.2f km/h", weatherstation.getWindspeed()));
        System.out.println("########################################## \n");
    }
}