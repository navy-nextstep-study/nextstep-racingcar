package com.nextstep.nextstepracingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private static final int RANDOM_MAX_NUM = 10;
    private static final Random random = new Random();

    private final List<Car> carList;


    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void playingGame() {
        for (Car car : carList) {
            car.getPostion().plusMove(random.nextInt(RANDOM_MAX_NUM));
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public Cars getWinner() {
        Optional<Car> winnerCar = carList.stream()
                .max(Comparator.comparing((car -> car.getPostion().getMove())));

        return new Cars(carList.stream()
                .filter(car -> car.getPostion().getMove() == winnerCar.get().getPostion().getMove())
                .collect(Collectors.toList()));
    }
}
