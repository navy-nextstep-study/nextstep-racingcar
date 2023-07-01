package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String inputCarNames() {
        return SCANNER.nextLine();
    }

    public int inputPlayCount() {
        return SCANNER.nextInt();
    }
}
