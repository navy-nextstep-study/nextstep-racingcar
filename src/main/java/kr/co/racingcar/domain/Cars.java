package kr.co.racingcar.domain;

import kr.co.racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String carsNames) {
        this.cars = extractCarName(carsNames);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private List<Car> extractCarName(String carsNames) {
        return Arrays.stream(carsNames.split(InputView.DELIMINATOR))
                .map(Car::new)
                .toList();
    }
}
