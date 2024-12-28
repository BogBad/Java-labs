import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Airplane[] airplanes = {
                new Airplane("Boeing 747", 660, 988.0, 13800.0, 1970),
                new Airplane("Airbus A380", 850, 1020.0, 15200.0, 2005),
                new Airplane("Concorde", 100, 2179.0, 7222.0, 1969),
                new Airplane("Cessna 172", 4, 226.0, 1280.0, 1956),
                new Airplane("Lockheed SR-71", 2, 3529.0, 5400.0, 1966)
        };

        Arrays.sort(airplanes, (a1, a2) -> {
            int capacityComparison = Integer.compare(a1.getCapacity(), a2.getCapacity());
            if (capacityComparison != 0) {
                return capacityComparison;
            }
            return Double.compare(a2.getRange(), a1.getRange());
        });

        System.out.println("Відсортований список літаків:");
        for (Airplane airplane : airplanes) {
            System.out.println(airplane);
        }

        Airplane target = new Airplane("Concorde", 100, 2179.0, 7222.0, 1969);
        int index = Arrays.binarySearch(airplanes, target, (a1, a2) -> {
            int capacityComparison = Integer.compare(a1.getCapacity(), a2.getCapacity());
            if (capacityComparison != 0) {
                return capacityComparison;
            }
            return Double.compare(a2.getRange(), a1.getRange());
        });

        if (index >= 0) {
            System.out.println("Знайдено літак: " + airplanes[index]);
        } else {
            System.out.println("Літак не знайдено.");
        }
    }
}