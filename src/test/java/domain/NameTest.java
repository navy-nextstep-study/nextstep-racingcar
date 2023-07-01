package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("이름 5자 이내면 정상 수행")
    void validNameLengthTest() {
        Assertions.assertThatCode(() -> new CarName("abcde"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름을 5자 초과하면 예외 발생")
    void invalidNameLengthTest() {
        Assertions.assertThatThrownBy(() -> new CarName("abcdefgh"))
              .isInstanceOf(IllegalArgumentException.class);
    }
}