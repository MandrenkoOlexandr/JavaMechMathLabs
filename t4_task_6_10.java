/**
 * Виконання задачі 6.10 (4 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Car {
    private String model;
    private double price;
    private double fuelConsumption;
    private int maxSpeed;

    public Car(String model, double price, double fuelConsumption, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return model + " (Витрати палива: " + fuelConsumption + ", Максимальна швидкість: " + maxSpeed + ")";
    }
}

class Sedan extends Car {
    private int numberOfSeats;

    public Sedan(String model, double price, double fuelConsumption, int maxSpeed, int numberOfSeats) {
        super(model, price, fuelConsumption, maxSpeed);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Седан " + super.toString() + ", Кількість сидінь: " + numberOfSeats;
    }
}

class SUV extends Car {
    private boolean offRoadCapable;

    public SUV(String model, double price, double fuelConsumption, int maxSpeed, boolean offRoadCapable) {
        super(model, price, fuelConsumption, maxSpeed);
        this.offRoadCapable = offRoadCapable;
    }

    @Override
    public String toString() {
        return "Позашляховик " + super.toString() + ", Проходимість: " + offRoadCapable;
    }
}

class TaxiPark {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public double calculateFleetCost() {
        double totalCost = 0;
        for (Car car : cars) {
            totalCost += car.getPrice();
        }
        return totalCost;
    }

    public void sortByFuelConsumption() {
        Collections.sort(cars, (c1, c2) -> Double.compare(c1.getFuelConsumption(), c2.getFuelConsumption()));
    }

    public Car findCarBySpeedRange(int minSpeed, int maxSpeed) {
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                return car;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Таксопарк: ");
        for (Car car : cars) {
            result.append(car).append(", ");
        }

        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}

public class t4_task_6_10 {
    public static void main(String[] args) {
        Sedan sedan1 = new Sedan("Toyota Camry", 25000, 8.5, 180, 5);
        SUV suv1 = new SUV("Jeep Grand Cherokee", 40000, 12.5, 200, true);
        Sedan sedan2 = new Sedan("Honda Accord", 22000, 7.8, 170, 4);

        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(sedan1);
        taxiPark.addCar(suv1);
        taxiPark.addCar(sedan2);

        System.out.println("Вартість таксі: $" + taxiPark.calculateFleetCost());

        taxiPark.sortByFuelConsumption();
        System.out.println("Відсортований за витратами палива: " + taxiPark);

        Car foundCar = taxiPark.findCarBySpeedRange(160, 190);
        if (foundCar != null) {
            System.out.println("Машина в діапазоні швидкостей: " + foundCar);
        } else {
            System.out.println("Машини в такому діапазоні не знайдено.");
        }
    }
}

