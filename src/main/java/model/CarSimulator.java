package model;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class CarSimulator {

    private final String CAR_NAME_DELIMITER = ",";
    private InputView inputView;
    private OutputView outputView;

    public CarSimulator() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        List<Car> names = getCarNames();
        Cars cars = new Cars(names);
        outputView.printPlayCountRequestMsg();
        int playCount = inputView.inputPlayCount();
        outputView.displayStartMsg();

        while (playCount-- > 0) {
            cars.move();
            outputView.displayPerPlayResult(cars);
        }

        List<Car> winner = cars.calculateWinnerCar();
        outputView.displayResult(winner);
    }

    private List<Car> getCarNames() {
        outputView.displayPromptCarName();
        String carNames = inputView.inputCarNames();
        List<Car> names = convertIndividualCarList(carNames);
        return names;
    }

    private List<Car> convertIndividualCarList(String carNames) {
        return Arrays
                .stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList();

    }
}
