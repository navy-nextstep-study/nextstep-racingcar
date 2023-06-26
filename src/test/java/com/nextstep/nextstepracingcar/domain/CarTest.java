package com.nextstep.nextstepracingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"volvo", "kia", "benz"})
    @DisplayName("자동차 객체가 정상적으로 생성된다.")
    void 정상적인_경우1(String name) {
        assertThat(new Car(new Name(name), new Move()));
    }

    @ParameterizedTest
    @CsvSource(value = {"volvo:8", "kia:5", "benz:7"}, delimiter = ':')
    @DisplayName("자동차 객체를 생성해서 랜덤 값을 주었을 때 5이상인 숫자인 경우 값이 증가한다.")
    void 정상적인_경우2(String carName, byte randomNum) {
        // given
        Name name = new Name(carName);
        Move move = new Move();
        Car car = new Car(name, move);

        // when
        car.move.plusMove(randomNum);

        // then
        assertThat(car.move.getMove()).isEqualTo((byte) 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"vㅁㄴ1ㄴ", "!@ADf", "1345"})
    @DisplayName("자동차의 이름이 영어가 아니면 예외가 발생한다.")
    void 실패_케이스1(String name) {
        assertThatThrownBy(() -> new Car(new Name(name), new Move()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 영어로 이루어져있지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"mercedes", "kiacar", "benzcar"})
    @DisplayName("자동차의 이름의 길이가 5글자를 초과하면 예외가 발생한다.")
    void 실패_케이스2(String name) {
        assertThatThrownBy(() -> new Car(new Name(name), new Move()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이가 5글자를 초과했습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("자동차의 이름의 길이가 0글자면 예외가 발생한다.")
    void 실패_케이스3(String name) {
        assertThatThrownBy(() -> new Car(new Name(name), new Move()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이가 0글자일 수 없습니다.");
    }
}

class Car {

    Name name;
    Move move;

    public Car(Name name, Move move) {
        this.name = name;
        this.move = move;
    }

    public Name getName() {
        return name;
    }

    public Move getMove() {
        return move;
    }
}



