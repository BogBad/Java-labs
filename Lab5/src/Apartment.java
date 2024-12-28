// Apartment.java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Apartment {
    private List<ElectricDevice> devices;

    public Apartment() {
        devices = new ArrayList<>();
    }

    /**
     * Додати електроприлад до списку.
     * @param device Електроприлад.
     */
    public void addDevice(ElectricDevice device) {
        devices.add(device);
    }

    /**
     * Підрахувати загальну потужність всіх приладів.
     * @return Загальна потужність.
     */
    public double calculateTotalPower() {
        double totalPower = 0;
        for (ElectricDevice device : devices) {
            totalPower += device.getPower();
        }
        return totalPower;
    }

    /**
     * Сортувати прилади за потужністю.
     */
    public void sortDevicesByPower() {
        devices.sort(Comparator.comparingDouble(ElectricDevice::getPower));
    }

    /**
     * Знайти прилади за діапазоном електромагнітного випромінювання.
     * @param start Початок діапазону.
     * @param end Кінець діапазону.
     * @return Список приладів, що відповідають діапазону.
     */
    public List<ElectricDevice> findDevicesByRadiationRange(double start, double end) {
        List<ElectricDevice> result = new ArrayList<>();
        for (ElectricDevice device : devices) {
            if (device.getRadiationRangeStart() >= start && device.getRadiationRangeEnd() <= end) {
                result.add(device);
            }
        }
        return result;
    }

    /**
     * Вивести усі прилади на екран.
     */
    public void displayDevices() {
        for (ElectricDevice device : devices) {
            System.out.println(device.getName() + " (Потужність: " + device.getPower() + "W)");
        }
    }
}
