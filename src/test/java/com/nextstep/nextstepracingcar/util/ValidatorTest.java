package com.nextstep.nextstepracingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @Test
    @DisplayName("입력된 자동차들의 이름들이 영어로 되어있지 않으면 예외가 발생한다.")
    void 실패_케이스1() {
        // given
        String[] inputCars = {"12345", "!@#$%", "ㄴㅇㄹㅁ"};

        // when && then
        Assertions.assertThatThrownBy(() -> Validator.validateString(inputCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차의 이름은 영어만 가능하며 이름은 쉼표로만 구분이 가능합니다.");
    }

    @Test
    @DisplayName("입력된 자동차들의 수가 2대 이상이 아닌 경우 예외가 발생한다.")
    void 실패_케이스2() {
        // given
        String[] inputCars = {"abcde"};

        // when && then
        Assertions.assertThatThrownBy(() -> Validator.validateString(inputCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 자동차의 개수가 2개 이상이어야합니다.");
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5글자를 초과하면 예외가 발생한다.")
    void 실패_케이스3() {
        // given
        String[] inputCars = {"abcdeasd", "asdfadsf"};

        // when && then
        Assertions.assertThatThrownBy(() -> Validator.validateString(inputCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이가 5글자를 초과했습니다.");
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 0글자면 예외가 발생한다.")
    void 실패_케이스4() {
        // given
        String[] inputCars = {"", ""};

        // when && then
        Assertions.assertThatThrownBy(() -> Validator.validateString(inputCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이가 0글자일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234@", "A1SDF", "asdfasf", "!@#$", "ㅁㄴㅇㄹ"})
    @DisplayName("게임 횟수를 입력받을 때 해당 횟수가 숫자가 아니면 예외가 발생한다.")
    void 실패_케이스5(String inputNum) {
        // when && then
        Assertions.assertThatThrownBy(() -> Validator.validateNumber(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 문자는 숫자가 아닙니다.");
    }
}
