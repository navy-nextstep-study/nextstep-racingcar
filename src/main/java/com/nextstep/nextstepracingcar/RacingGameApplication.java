package com.nextstep.nextstepracingcar;

import com.nextstep.nextstepracingcar.domain.Car;
import com.nextstep.nextstepracingcar.domain.Cars;
import com.nextstep.nextstepracingcar.domain.Move;
import com.nextstep.nextstepracingcar.domain.Name;
import com.nextstep.nextstepracingcar.io.InputView;
import com.nextstep.nextstepracingcar.io.OutputView;
import com.nextstep.nextstepracingcar.util.Validator;
import java.util.ArrayList;
import java.util.List;

public class RacingGameApplication {

    private boolean running = true;
    private Cars cars;

    void run() {
        try {
            OutputView.gameGuide();
            String[] carNames = InputView.inputCars();
            Validator.validateString(carNames);

            OutputView.tryNumberGuide();
            String tryGameNumber = InputView.inputNumber();
            Validator.validateNumber(tryGameNumber);

            cars = new Cars(createCars(carNames));

            play(Integer.parseInt(tryGameNumber));

            OutputView.gameWinnerGuide(cars.getWinner());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void play(int tryGameNumber) {
        for (int i = 0; i < tryGameNumber; i++) {
            cars.playingGame();
            OutputView.gameResultGuide(cars.getCars());
        }
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(new Name(carName), new Move()));
        }

        return cars;
    }
}
