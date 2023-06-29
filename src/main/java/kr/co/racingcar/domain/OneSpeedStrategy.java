package kr.co.racingcar.domain;

public class OneSpeedStrategy implements CarSpeedStrategy {
    private static final int ONE_SPEED = 1;

    @Override
    public int speed() {
        return ONE_SPEED;
    }
}
