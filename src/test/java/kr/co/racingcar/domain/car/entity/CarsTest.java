package kr.co.racingcar.domain.car.entity;

import kr.co.racingcar.domain.Cars;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 정상적인_이름을_가진_자동차들을_추출한다() {
        //given & when
        Cars cars = new Cars("one1,two2,three");

        //then
        assertThat(cars.get(0).getCarName()).isEqualTo("one1");
        assertThat(cars.get(1).getCarName()).isEqualTo("two2");
        assertThat(cars.get(2).getCarName()).isEqualTo("three");
        assertThat(cars.size()).isEqualTo(3);
    }
}
