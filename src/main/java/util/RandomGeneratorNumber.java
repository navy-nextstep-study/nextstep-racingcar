package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGeneratorNumber {

    public static int generateRandomNumberFrom() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(9);
    }
}
