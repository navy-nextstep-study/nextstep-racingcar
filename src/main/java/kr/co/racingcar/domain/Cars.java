package kr.co.racingcar.domain;

import kr.co.racingcar.view.InputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carsNames) {
        this.cars = extractCarName(carsNames);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public void move(CarMovingStrategy movingStrategy,
                     CarSpeedStrategy speedStrategy) {
        this.cars.stream()
                .filter(car -> movingStrategy.movable())
                .forEach(car -> car.move(speedStrategy));
    }

    private List<Car> extractCarName(String carsNames) {
        return Arrays.stream(carsNames.split(InputView.DELIMINATOR))
                .map(Car::new)
                .toList();
    }
}
