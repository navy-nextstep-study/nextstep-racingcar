package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("랜덤 난수가 4미만이라면 차는 전진하지 않는다.")
    void carCantMove(int random) {
        Car car = new Car("jwCar");
        car.move(random);

        Assertions.assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 난수가 4이상이라면 차는 전진한다.")
    void carCanMove(int random) {
        Car car = new Car("jwCar");
        car.move(random);

        Assertions.assertThat(car.getCarPosition()).isEqualTo(1);
    }
}