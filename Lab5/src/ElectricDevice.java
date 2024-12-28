// ElectricDevice.java
public abstract class ElectricDevice {
    protected String name;
    protected double power; // Споживана потужність в ватах
    protected double radiationRangeStart; // Початок діапазону електромагнітного випромінювання (в Гц)
    protected double radiationRangeEnd; // Кінець діапазону електромагнітного випромінювання (в Гц)

    public ElectricDevice(String name, double power, double radiationRangeStart, double radiationRangeEnd) {
        this.name = name;
        this.power = power;
        this.radiationRangeStart = radiationRangeStart;
        this.radiationRangeEnd = radiationRangeEnd;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public double getRadiationRangeStart() {
        return radiationRangeStart;
    }

    public double getRadiationRangeEnd() {
        return radiationRangeEnd;
    }

    /**
     * Абстрактний метод для увімкнення приладу.
     */
    public abstract void turnOn();

    /**
     * Абстрактний метод для вимкнення приладу.
     */
    public abstract void turnOff();
}
