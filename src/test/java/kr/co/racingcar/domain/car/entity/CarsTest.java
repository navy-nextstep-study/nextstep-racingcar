package kr.co.racingcar.domain.car.entity;

import kr.co.racingcar.domain.Car;
import kr.co.racingcar.domain.Cars;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 정상적인_이름을_가진_자동차들을_추출한다_PASS() {
        //given & when
        Cars cars = new Cars("one1,two2,three");

        //then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getCarName()).isEqualTo("one1");
        assertThat(cars.getCars().get(1).getCarName()).isEqualTo("two2");
        assertThat(cars.getCars().get(2).getCarName()).isEqualTo("three");
    }

    @Test
    void movable_자동차들_이동_PASS() {
        //given
        Cars cars = new Cars("one,two,three");

        //when
        cars.move(() -> true, () -> 1);

        //then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void movable_자동차들_정지_PASS() {
        //given
        Cars cars = new Cars("one,two,three");

        //when
        cars.move(() -> false, () -> 1);

        //then
        assertThat(cars.getCars().get(0).getPosition()).isZero();
        assertThat(cars.getCars().get(1).getPosition()).isZero();
        assertThat(cars.getCars().get(2).getPosition()).isZero();
    }

    @Test
    void findWinners_우승자를_조회_PASS() {
        //given
        Cars cars = new Cars(List.of(
                new Car("one", 7),
                new Car("two", 7),
                new Car("three", 2),
                new Car("three", 5),
                new Car("three", 1)
        ));

        //when
        Cars actual = cars.findWinners();

        //then
        assertThat(actual.getCars().get(0).getCarName()).isEqualTo("one");
        assertThat(actual.getCars().get(1).getCarName()).isEqualTo("two");
        assertThat(actual.getCars()).hasSize(2);
    }
}
