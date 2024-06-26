package obj.wetterstation.interfaces;

import obj.wetterstation.WeatherStation;

public interface IWeatherStationBuilder {
    
    IWeatherStationBuilder attachTemperatureSensor(ITemp sensor);
    IWeatherStationBuilder attachWindspeedSensor(IWind sensor);
    IWeatherStationBuilder attachRainSensor(IRain sensor);
    IWeatherStationBuilder attachPressureSensor(IPressure sensor);
    WeatherStation build(); 
}
