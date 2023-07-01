package com.nextstep.nextstepracingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"kia", "benz", "volvo"})
    @DisplayName("자동차 이름이 예외 없이 정상적으로 생성된다.")
    void 정상적인_경우(String name) {
        Name carName = new Name(name);
        assertThat(carName);
    }
}

