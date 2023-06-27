package kr.co.racingcar.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomMove {
    private static final int POWER_MIN = 4;
    private static final int POWER_RANGE = 10;
    public static Random random = new Random();

    public static boolean accel() {
        return POWER_MIN < random.nextInt(POWER_RANGE);
    }
}
