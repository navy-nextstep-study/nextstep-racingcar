package com.nextstep.nextstepracingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;

class Cars {

    private static final int RANDOM_MAX_NUM = 10;

    private static final Random random = new Random();

    private final List<Car> cars;


    public Cars(List<Car> cars) {
        playingGame(cars);
        this.cars = cars;
    }

    private void playingGame(List<Car> cars) {
        for (Car car : cars) {
            car.move.plusMove(random.nextInt(RANDOM_MAX_NUM));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}