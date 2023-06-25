package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        this(Arrays.stream(names).map(Car::new).collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberCreationStrategy strategy) {
        cars.forEach(car -> car.move(strategy.create()));
    }

    public Cars calculateWinner() {
        List<Car> sortedCars = new ArrayList<>(cars);
        List<Car> result = new ArrayList<>();
        sortedCars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());

        int max = sortedCars.get(0).getPosition();
        for (Car car : sortedCars) {
            if (max != car.getPosition()) {
                break;
            }
            result.add(car);
        }
        return new Cars(result);
    }

    public List<Car> getCars() {
        return cars;
    }
}
