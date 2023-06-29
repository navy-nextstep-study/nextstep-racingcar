package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> calculateWinnerCar() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .toList();
    }
}
