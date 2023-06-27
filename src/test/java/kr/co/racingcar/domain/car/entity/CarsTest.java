package kr.co.racingcar.domain.car.entity;

import kr.co.racingcar.domain.Cars;
import kr.co.racingcar.domain.RandomMove;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

public class CarsTest {

    @Test
    void 정상적인_이름을_가진_자동차들을_추출한다() {
        //given & when
        Cars cars = new Cars("one1,two2,three");

        //then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getCarName()).isEqualTo("one1");
        assertThat(cars.getCars().get(1).getCarName()).isEqualTo("two2");
        assertThat(cars.getCars().get(2).getCarName()).isEqualTo("three");
    }

    @Test
    void 엑셀에_따른_자동차들_이동_PASS() {
        //given
        Random randomMock = Mockito.mock(Random.class);
        given(randomMock.nextInt(anyInt())).willReturn(5, 6, 7, 8, 9);
        RandomMove.random = randomMock;
        Cars cars = new Cars("one,two,three");

        //when
        cars.move();

        //then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void move_랜덤값_1_to_4에_따른_자동차들_정지_PASS() {
        Random randomMock = Mockito.mock(Random.class);
        given(randomMock.nextInt(anyInt())).willReturn(1, 2, 3, 4);
        RandomMove.random = randomMock;
        Cars cars = new Cars("one,two,three");

        //when
        cars.move();

        //then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(0);
    }
}
