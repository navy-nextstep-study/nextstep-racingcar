package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("포지션이 이동하는지에 대한 테스트")
    void positionMoveTest() {
        Position position = new Position();

        position.addPosition();

        Assertions.assertThat(position.getPosition()).isEqualTo(1);
    }
}