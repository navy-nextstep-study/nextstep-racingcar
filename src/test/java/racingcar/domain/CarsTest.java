package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 우승자를_구한다() {
        // given
        Car car1 = new Car(3, "pobi");
        Car car2 = new Car(3, "geunw");
        Car car3 = new Car(2, "crong");
        Cars cars = new Cars(List.of(car1, car2, car3));

        // when
        Cars result = cars.calculateWinner();

        // then
        assertThat(result.getCars()).containsExactly(car1, car2);
    }
}
