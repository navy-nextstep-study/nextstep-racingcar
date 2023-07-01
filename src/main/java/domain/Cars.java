package domain;

import util.RandomGeneratorNumber;

import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        cars.forEach((car) -> car.move(RandomGeneratorNumber.generateRandomNumberFrom()));
    }

    public Cars calculateWinnerCar() {
        int maxPosition = calculateWinningPosition();
        List<Car> winningCarList = getWinningCarList(maxPosition);

        return new Cars(winningCarList);
    }

    private List<Car> getWinningCarList(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .toList();
    }

    private int calculateWinningPosition() {
        return cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElse(0);
    }
}
