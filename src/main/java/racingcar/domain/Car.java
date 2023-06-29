package racingcar.domain;

public class Car {

    public static final int MOVE_STANDARD = 4;
    public static final int NAME_STANDARD = 5;

    private int position;
    private final String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        validateNameLength(name);
        this.position = position;
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_STANDARD) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %s자를 초과할 수 없습니다.", NAME_STANDARD));
        }
    }

    public void move(int number) {
        if (number >= MOVE_STANDARD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
