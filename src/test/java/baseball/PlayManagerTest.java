package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayManagerTest {

    PlayManager playManager;

    @BeforeEach
    void setUp() {
        playManager  = new PlayManager();
    }

    @Test
    void extractRandomValue() {
        int randomValue = playManager.extractRandomValue();
        Assertions.assertThat(randomValue).isBetween(1, 9);
    }
}