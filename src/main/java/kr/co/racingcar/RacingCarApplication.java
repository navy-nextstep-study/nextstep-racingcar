package kr.co.racingcar;

import kr.co.racingcar.controller.RacingCarController;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
    }
}
