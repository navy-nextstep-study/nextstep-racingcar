package com.nextstep.nextstepracingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveTest {

    @Test
    @DisplayName("움직임 수치에 대한 move 객체가 정상적으로 생성된다.")
    void 정상적인_경우1() {
        assertThat(new Move());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 7, 8, 9})
    @DisplayName("랜덤으로 들어온 값이 4이상일 경우 move값이 증가한다.")
    void 정상적인_경우2(int randomNum) {
        // given
        Move move = new Move();

        // when
        move.plusMove(randomNum);

        // then
        assertThat(move.getPosition()).isEqualTo((byte) 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 1, 3})
    @DisplayName("랜덤으로 들어온 값이 4미만일 경우 move값이 증가하지 않는다.")
    void 정상적인_경우3(int randomNum) {
        // given
        Move move = new Move();

        // when
        move.plusMove(randomNum);

        // then
        assertThat(move.getPosition()).isEqualTo(0);
    }
}

