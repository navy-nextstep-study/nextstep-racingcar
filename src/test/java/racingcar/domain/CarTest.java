package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차의_이름이_5를_초과하면_예외가_발생한다() {
        // given & when & then
        assertThatThrownBy(() -> new Car("geunwoo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름은 %s자를 초과할 수 없습니다.", Car.NAME_STANDARD));
    }

    @Test
    void 한칸_전진한다() {
        // given
        Car car = new Car("geunw");

        // when
        car.move(5);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 전진기준에_맞지_않으면_전진하지_못한다() {
        // given
        Car car = new Car("geunw");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
