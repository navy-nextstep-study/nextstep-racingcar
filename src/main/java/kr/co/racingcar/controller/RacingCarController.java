package kr.co.racingcar.controller;

import kr.co.racingcar.domain.Cars;
import kr.co.racingcar.domain.OneSpeedStrategy;
import kr.co.racingcar.domain.RacingCar;
import kr.co.racingcar.domain.RandomMovingStrategy;
import kr.co.racingcar.view.InputView;
import kr.co.racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        Cars cars = new Cars(InputView.inputCarName());
        int count = InputView.inputCount();
        RacingCar racingCar = new RacingCar(cars);

        while (count != OutputView.GAME_END) {
            racingCar.play(new RandomMovingStrategy(), new OneSpeedStrategy());
            OutputView.outputResult(cars);
            count--;
        }

        OutputView.outputWinner(cars.findWinners());
    }
}
