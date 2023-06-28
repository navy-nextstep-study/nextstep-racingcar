package com.nextstep.nextstepracingcar.io;

import java.util.Scanner;

public final class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputCars() {
        String carNameList = scanner.nextLine();
        return parsing(carNameList);
    }

    public static String inputNumber() {
        return scanner.nextLine();
    }

    private static String[] parsing(String carNameList) {
        return carNameList.split(",");
    }
}
