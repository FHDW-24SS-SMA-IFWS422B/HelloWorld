package obj;

import obj.wetterstation.WeatherStation;
import obj.wetterstation.interfaces.*;
import src.Pattern.TempSensorFactory;
import src.Pattern.USBTempSensorFactory;
import fhdw.drivers.sensors.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ITemp tempSensor = new SerialTemperatureDriver("/dev/tty0");
        IWind windSensor = new SerialWindspeedDriver("/dev/tty1");
        IUSB usbSensor = new USBTemperatureDriver();
        IPressure pressureSensor = new SerialPressureSensor();
        IRain rainSensor = new SerialRainSensor();
        WeatherStation weatherstation = new WeatherStation(tempSensor, windSensor, rainSensor, pressureSensor, usbSensor);

        TempSensorFactory serialFactory = new TempSensorFactory();
        serialFactory.readUserConfig();
        ITemp serialSensor = serialFactory.createTemp();
        serialSensor.readTemperature();

        USBTempSensorFactory usbFactory = new USBTempSensorFactory();
        usbFactory.readUserConfig();
        IUSB uSBSensor = usbFactory.createUSB();
        uSBSensor.readTemperature();

        //System.out.println(String.format("%.2f mm/h", weatherstation.getRain()));
        //System.out.println(String.format("%.2f hPa", weatherstation.getPressure()));
        //System.out.println(String.format("%.2f C", weatherstation.getTemperatur()));

        //System.out.println(String.format("%.2f C", weatherstation.getTemperatur()));
        //System.out.println(String.format("%.2f km/h", weatherstation.getWindspeed()));
        System.out.println(weatherstation.readWeatherData());

        weatherstation.run();
    }
}