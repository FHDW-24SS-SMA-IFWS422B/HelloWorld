package obj.wetterstation;

import obj.wetterstation.interfaces.*;

public class ConcreteWeatherStationBuilder implements IWeatherStationBuilder {
    ITemp tempSensor;
    IRain rainSensor;
    IPressure pressureSensor;
    IWind windSensor;

    @Override
    public IWeatherStationBuilder attachTemperatureSensor(ITemp sensor) {
        this.tempSensor = sensor;
        return this;
    }

    @Override
    public IWeatherStationBuilder attachWindspeedSensor(IWind sensor) {
        this.windSensor = sensor;
        return this;
    }

    @Override
    public ConcreteWeatherStationBuilder attachRainSensor(IRain sensor) {
        this.rainSensor = sensor;
        return this;
    }

    @Override
    public IWeatherStationBuilder attachPressureSensor(IPressure sensor) {
        this.pressureSensor = sensor;
        return this;
    }

    @Override
    public WeatherStation build() {
        return new WeatherStation(tempSensor, windSensor, rainSensor, pressureSensor, null);
    }
}
