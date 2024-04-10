package LabClass2;

public class Wetterstation {

    static SerialTemperatureDriver TemperaturDriver = new SerialTemperatureDriver();
    static SerialWindspeedDriver WindspeedDriver = new SerialWindspeedDriver();

    public static void main(String[] args) {
        System.out.println("aktuelle Temperatur: " + TemperaturDriver.read() + " °C");
        System.out.println("aktuelle Windgeschwindigkeit: " + WindspeedDriver.currentWindspeed() + " m/s");
    }
}
