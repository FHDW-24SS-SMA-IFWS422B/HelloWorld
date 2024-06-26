package obj;

import java.io.FileNotFoundException;

import fhdw.drivers.sensors.SerialPressureSensor;
import fhdw.drivers.sensors.SerialRainSensor;
import fhdw.drivers.sensors.SerialTemperatureDriver;
import fhdw.drivers.sensors.SerialWindspeedDriver;
import obj.wetterstation.ConcreteWeatherStationBuilder;

public class WeatherStationDirector {
    public void constructSimple( ConcreteWeatherStationBuilder builder) throws FileNotFoundException {
        builder.attachWindspeedSensor(new SerialWindspeedDriver(null))
                .attachPressureSensor(new SerialPressureSensor())
                .attachRainSensor(new SerialRainSensor())
                .attachTemperatureSensor(new SerialTemperatureDriver(null));
    }
    
    public void constructAdvanced( ConcreteWeatherStationBuilder builder) throws FileNotFoundException {
        builder.attachWindspeedSensor(new SerialWindspeedDriver(null))
                .attachPressureSensor(new SerialPressureSensor())
                .attachRainSensor(new SerialRainSensor())
                .attachTemperatureSensor(new SerialTemperatureDriver(null));
    }
}
