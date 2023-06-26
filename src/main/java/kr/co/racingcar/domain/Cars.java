package kr.co.racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String DELIMINATOR = ",";

    private List<Car> cars;

    public Cars(String carsNames) {
        this.cars = extractCarName(carsNames);
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int size() {
        return this.cars.size();
    }

    private List<Car> extractCarName(String carsNames) {
        return Arrays.stream(carsNames.split(DELIMINATOR))
                .map(Car::new)
                .toList();
    }
}
