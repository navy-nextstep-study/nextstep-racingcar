package racingcar.domain;

import java.util.Random;

public class RandomNumberCreation implements NumberCreationStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public int create() {
        return RANDOM.nextInt(10);
    }
}
