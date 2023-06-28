package com.nextstep.nextstepracingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private static final int RANDOM_MAX_NUM = 10;

    private static final Random random = new Random();

    private final List<Car> cars;


    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playingGame() {
        for (Car car : cars) {
            car.getMove().plusMove(random.nextInt(RANDOM_MAX_NUM));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinner() {
        Optional<Car> winnerCar = cars.stream()
                .max(Comparator.comparing((car -> car.getMove().getPosition())));

        List<Car> winner = cars.stream()
                .filter(car -> car.getMove().getPosition() == winnerCar.get().getMove().getPosition())
                .collect(Collectors.toList());

        return Collections.unmodifiableList(winner);
    }
}