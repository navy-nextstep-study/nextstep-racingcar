package kr.co.racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements CarMovingStrategy {
    private static final Random random = new Random();
    private static final int POWER_MIN = 4;
    private static final int POWER_RANGE = 10;

    @Override
    public boolean movable() {
        return POWER_MIN < random.nextInt(POWER_RANGE);
    }
}
