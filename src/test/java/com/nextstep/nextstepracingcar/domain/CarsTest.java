package com.nextstep.nextstepracingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차들의 정보를 가지고 있는 객체가 정상적으로 생성된다.")
    void 정상적인_케이스1() {
        List<Car> carlist = List.of(
                new Car(new Name("benz"), new Position()),
                new Car(new Name("kia"), new Position()),
                new Car(new Name("volvo"), new Position()),
                new Car(new Name("ssang"), new Position()),
                new Car(new Name("toyot"), new Position())
        );

        assertThat(new Cars(carlist));
    }

    @Test
    @DisplayName("게임을 진행할 때 차에 랜덤한 값이 5이상 부여되면 move한다.")
    void 정상적인_케이스2() {
        // given
        List<Car> carlist = List.of(
                new Car(new Name("benz"), new Position()),
                new Car(new Name("kia"), new Position()),
                new Car(new Name("volvo"), new Position()),
                new Car(new Name("ssang"), new Position()),
                new Car(new Name("toyot"), new Position())
        );

        // when
        Cars cars = new Cars(carlist);

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getPostion().getMove()).isIn(0, 1);
        }
    }
}

