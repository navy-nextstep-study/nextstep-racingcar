package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomNumberCreation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    public void play() {
        OutputView.outputCarNamesComment();
        String[] names = InputView.inputCarNames();

        OutputView.outputAttemptCountComment();
        int attemptCount = InputView.inputInt();

        OutputView.outputResultComment();
        RacingCarGame game = new RacingCarGame(new Cars(names));

        while (attemptCount-- > 0) {
            game.play(new RandomNumberCreation());

            OutputView.outputCars(game.getCars());
        }
        OutputView.outputWinners(game.calculateWinner());
    }
}
