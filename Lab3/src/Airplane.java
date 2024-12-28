import java.util.Objects;

public class Airplane implements Comparable<Airplane> {
    private String model; // Модель літака
    private int capacity; // Місткість пасажирів
    private double maxSpeed; // Максимальна швидкість
    private double range; // Дальність польоту
    private int yearOfProduction; // Рік виробництва

    public Airplane(String model, int capacity, double maxSpeed, double range, int yearOfProduction) {
        this.model = model;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.range = range;
        this.yearOfProduction = yearOfProduction;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getRange() {
        return range;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return capacity == airplane.capacity &&
                Double.compare(airplane.maxSpeed, maxSpeed) == 0 &&
                Double.compare(airplane.range, range) == 0 &&
                yearOfProduction == airplane.yearOfProduction &&
                Objects.equals(model, airplane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, capacity, maxSpeed, range, yearOfProduction);
    }

    @Override
    public String toString() {
        return String.format("Airplane{model='%s', capacity=%d, maxSpeed=%.2f, range=%.2f, yearOfProduction=%d}",
                model, capacity, maxSpeed, range, yearOfProduction);
    }

    @Override
    public int compareTo(Airplane other) {
        return this.model.compareTo(other.model);
    }
}
