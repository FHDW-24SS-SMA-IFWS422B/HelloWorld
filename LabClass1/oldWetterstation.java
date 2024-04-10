package LabClass1;
public class oldWetterstation {
    public double temperatur;
    public double windgeschwindigkeit;

    public void setTemperatur(double temperatur) {
        this.temperatur = temperatur;
    }

    public double getTemperatur() {
        return this.temperatur;
    }

    public void setWindgeschwindigkeit(double windgeschwindigkeit) {
        this.windgeschwindigkeit = windgeschwindigkeit;
    }

    public double getWindgeschwindigkeit() {
        return this.windgeschwindigkeit;
    }

    public void Wetterkonditionen() {
        System.out.println("aktuelle Temperatur: " + getTemperatur() + " °C");
        System.out.println("aktuelle Windgeschwindigkeit: " + getWindgeschwindigkeit() + " km/h");
    }
}