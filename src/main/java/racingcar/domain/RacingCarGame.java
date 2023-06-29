package racingcar.domain;

public class RacingCarGame {

    private final Cars cars;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void play(NumberCreationStrategy strategy) {
        cars.move(strategy);
    }

    public Cars calculateWinner() {
        return cars.calculateWinner();
    }

    public Cars getCars() {
        return cars;
    }
}
