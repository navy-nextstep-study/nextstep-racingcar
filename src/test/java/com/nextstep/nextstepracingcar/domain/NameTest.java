package com.nextstep.nextstepracingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @ParameterizedTest
    @ValueSource(strings = {"s#as.", "12345", "1asxc", "한글이름입니다"})
    @DisplayName("자동차 이름이 영어가 아니면 예외가 발생한다.")
    void 실패_케이스1(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 영어로 이루어져있지 않습니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"kiacar", "benzcar", "volvocar"})
    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다.")
    void 실패_케이스2(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이가 5글자를 초과했습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("자동차 이름이 0글자면 예외가 발생한다.")
    void 실패_케이스3(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이가 0글자일 수 없습니다.");
    }
}

class Name {

    private final static int NAME_LENGTH_LIMIT = 5;
    private final static int NAME_LENGTH_MIN = 0;
    private final static Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

    private String name;

    public Name(String name) {
        validateNameIsCharacters(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameIsCharacters(String name) {
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find()) {
            throw new IllegalArgumentException("자동차 이름이 영어로 이루어져있지 않습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5글자를 초과했습니다.");
        }

        if (name.length() == NAME_LENGTH_MIN) {
            throw new IllegalArgumentException("자동차 이름의 길이가 0글자일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
