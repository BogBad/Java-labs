// Main.java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Створення електроприладів
            ElectricDevice lamp = new Lamp("Лампа", 60, 2.4e9, 2.5e9);
            ElectricDevice fridge = new Fridge("Холодильник", 150, 50e6, 60e6);
            ElectricDevice heater = new Heater("Обігрівач", 1000, 100e6, 150e6);

            // Створення квартири та додавання приладів
            Apartment apartment = new Apartment();
            apartment.addDevice(lamp);
            apartment.addDevice(fridge);
            apartment.addDevice(heater);

            // Розрахунок загальної потужності
            double totalPower = apartment.calculateTotalPower();
            System.out.println("Загальне споживання потужності: " + totalPower + "W");

            // Сортування приладів за потужністю
            apartment.sortDevicesByPower();
            System.out.println("\nПрилади, відсортовані за потужністю:");
            apartment.displayDevices();

            // Пошук приладів за діапазоном електромагнітного випромінювання
            double searchStart = 1e8; // 100 МГц
            double searchEnd = 1e9;   // 1 ГГц
            System.out.println("\nПрилади в діапазоні випромінювання " + searchStart + " Гц до " + searchEnd + " Гц:");
            List<ElectricDevice> foundDevices = apartment.findDevicesByRadiationRange(searchStart, searchEnd);
            for (ElectricDevice device : foundDevices) {
                System.out.println(device.getName());
            }

            // Приклад увімкнення та вимкнення приладів
            System.out.println("\nУвімкнення та вимкнення приладів:");
            lamp.turnOn();
            fridge.turnOn();
            heater.turnOn();

            lamp.turnOff();
            fridge.turnOff();
            heater.turnOff();

        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}
