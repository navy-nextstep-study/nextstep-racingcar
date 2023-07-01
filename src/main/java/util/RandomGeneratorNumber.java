package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGeneratorNumber {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static int generateRandomNumberFrom() {
        return RANDOM.nextInt(9);
    }
}
