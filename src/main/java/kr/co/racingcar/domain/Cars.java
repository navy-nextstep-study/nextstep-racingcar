package kr.co.racingcar.domain;

import kr.co.racingcar.view.InputView;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars(String carsNames) {
        this.cars = extractCarName(carsNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
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

    public List<Car> findWinners() {
        final List<Car> winners = new ArrayList<>(this.cars).stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .toList();
        int winnerPosition = winners.get(0).getPosition();
        return winners.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .toList();
    }

    private List<Car> extractCarName(String carsNames) {
        return Arrays.stream(carsNames.split(InputView.DELIMINATOR))
                .map(Car::new)
                .toList();
    }
}
