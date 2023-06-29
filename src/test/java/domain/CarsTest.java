package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("리스트를 입력받아서 자동차를 일급 컬렉션에 생성한다.")
    void createCars() {
        List<Car> cars = List.of(new Car("BMW"), new Car("Audi"), new Car("Ford"));
        Cars createdCars = new Cars(cars);
        Assertions.assertThat(createdCars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("만약 다른 차보다 이동거리가 가장 많다면 우승자는 1명이다.")
    void calculateWinnerCar() {
        Car bmw = new Car("BMW");
        Car audi = new Car("Audi");
        Car ford = new Car("Ford");

        List<Car> cars = List.of(bmw, audi, ford);
        Cars createdCars = new Cars(cars);
        bmw.move(4);
        audi.move(2);
        ford.move(0);
        Assertions.assertThat(createdCars.calculateWinnerCar()).contains(bmw);
    }

    @Test
    @DisplayName("이동거리가 가장 많은 차가 2대 이상이라면 우승자는 2대 이상이다.")
    void calculateWinnerCarPlural() {
        Car bmw = new Car("BMW");
        Car audi = new Car("Audi");
        Car ford = new Car("Ford");

        List<Car> cars = List.of(bmw, audi, ford);
        Cars createdCars = new Cars(cars);
        bmw.move(4);
        audi.move(4);
        ford.move(0);
        Assertions.assertThat(createdCars.calculateWinnerCar()).contains(bmw, audi);
    }
}