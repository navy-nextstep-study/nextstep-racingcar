package kr.co.racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car;

    @BeforeEach
    void beforeEach(){
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"Seven77", "nine99999"})
    void validateCarNameLength_자동차_이름이_5글자_이상_IllegalArgumentException(String input){
        //given & when & then
        assertThatThrownBy(() -> car.validateCarNameLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 넘을 수 없습니다.");
    }

    @Test
    void validateCarNameBlank_자동차_이름이_빈문자열_IllegalArgumentException() {
        //given & when & then
        assertThatThrownBy(() -> car.validateCarNameBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 빈문자열이거나 공백입니다.");
    }

    @Test
    void validateCarNameBlank_자동차_이름이_공백으로_이루어짐_IllegalArgumentException() {
        //given & when & then
        assertThatThrownBy(() -> car.validateCarNameBlank("       "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 빈문자열이거나 공백입니다.");
    }

    @Test
    void validateCarNameNull_자동차_이름이_null_IllegalArgumentException() {
        //given & when & then
        assertThatThrownBy(() -> car.validateCarNameNull(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 Null 입니다.");
    }
}
