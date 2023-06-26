package kr.co.racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
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
}
