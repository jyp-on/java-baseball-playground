package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {
    Balls computer;

    @BeforeEach
    void setUp() {
        computer = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void strike() {
        int[] playResult = computer.play(new Ball(1, 1));
        Assertions.assertThat(playResult[0]).isEqualTo(1);
        Assertions.assertThat(playResult[1]).isEqualTo(0);
    }

    @Test
    void ball() {
        int[] playResult = computer.play(new Ball(1, 2));
        Assertions.assertThat(playResult[0]).isEqualTo(0);
        Assertions.assertThat(playResult[1]).isEqualTo(1);
    }

    @Test
    void nothing() {
        int[] playResult = computer.play(new Ball(1, 4));
        Assertions.assertThat(playResult[0]).isEqualTo(0);
        Assertions.assertThat(playResult[1]).isEqualTo(0);
    }
}
