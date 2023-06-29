package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorNumberTest {

    @RepeatedTest(30)
    void test() {
        int number = RandomGeneratorNumber.generateRandomNumberFrom();
        Assertions.assertThat(number).isBetween(0, 9);
    }
}