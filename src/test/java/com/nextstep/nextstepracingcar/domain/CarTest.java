package com.nextstep.nextstepracingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"volvo", "kia", "benz"})
    @DisplayName("자동차 객체가 정상적으로 생성된다.")
    void 정상적인_경우1(String name) {
        assertThat(new Car(new Name(name), new Position()));
    }

    @ParameterizedTest
    @CsvSource(value = {"volvo:8", "kia:5", "benz:7"}, delimiter = ':')
    @DisplayName("자동차 객체를 생성해서 랜덤 값을 주었을 때 5이상인 숫자인 경우 값이 증가한다.")
    void 정상적인_경우2(String carName, int randomNum) {
        // given
        Name name = new Name(carName);
        Position position = new Position();
        Car car = new Car(name, position);

        // when
        car.getPostion().plusMove(randomNum);

        // then
        assertThat(car.getPostion().getMove()).isEqualTo(1);
    }

}



