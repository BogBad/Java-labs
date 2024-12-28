// Fridge.java
public class Fridge extends ElectricDevice {

    public Fridge(String name, double power, double radiationRangeStart, double radiationRangeEnd) {
        super(name, power, radiationRangeStart, radiationRangeEnd);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " увімкнено.");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " вимкнено.");
    }
}
