package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void ball() {
        assertThat(com.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertThat(com.play(new Ball(2, 3))).isEqualTo(BallStatus.NOTHING);
        assertThat(com.play(new Ball(1, 5))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void strike() {
        assertThat(com.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }
}
