package com.nextstep.nextstepracingcar.io;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputCars() {
        String carNameList = SCANNER.nextLine();
        return parsing(carNameList);
    }

    public static String inputNumber() {
        return SCANNER.nextLine();
    }

    private static String[] parsing(String carNameList) {
        return carNameList.split(",");
    }
}
