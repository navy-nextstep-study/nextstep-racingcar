package com.nextstep.nextstepracingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("게임을 진행하는 앱이 정상적으로 생성된다.")
    void 정상적인_케이스1() {
        List<Car> carlist = List.of(
                new Car(new Name("benz"), new Move()),
                new Car(new Name("kia"), new Move()),
                new Car(new Name("volvo"), new Move()),
                new Car(new Name("ssang"), new Move()),
                new Car(new Name("toyot"), new Move())
        );

        assertThat(new Cars(carlist));
    }

    @Test
    @DisplayName("게임을 진행할 때 차에 랜덤한 값이 5이상 부여되면 move한다.")
    void 정상적인_케이스2() {
        // given
        List<Car> carlist = List.of(
                new Car(new Name("benz"), new Move()),
                new Car(new Name("kia"), new Move()),
                new Car(new Name("volvo"), new Move()),
                new Car(new Name("ssang"), new Move()),
                new Car(new Name("toyot"), new Move())
        );

        // when
        Cars cars = new Cars(carlist);

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.move.getPosition()).isIn(0, 1);
        }
    }
}

