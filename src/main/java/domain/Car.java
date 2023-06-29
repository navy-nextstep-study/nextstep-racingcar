package domain;

public class Car {

    private static final int MINIMUM_MOVE_THRESHOLD = 4;
    private CarName carName;
    private Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void move(int randomValue) {
        if(canMove(randomValue)) {
            this.position.addPosition();
        }
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MINIMUM_MOVE_THRESHOLD;
    }

    public int getCarPosition() {
        return this.position.getPosition();
    }
}
