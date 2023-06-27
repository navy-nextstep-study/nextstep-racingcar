package kr.co.racingcar.domain;

public class RacingCar {

    private Cars cars;

    public RacingCar(Cars cars) {
        this.cars = cars;
    }

    public void play(CarMovingStrategy movingStrategy,
                     CarSpeedStrategy speedStrategy) {
        this.cars.move(movingStrategy, speedStrategy);
    }
}
