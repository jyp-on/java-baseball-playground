package baseball;

import java.util.Arrays;
import java.util.Random;

public class PlayManager {
    private int ball_cnt;
    private int strike_cnt;

    public void record(BallStatus ballStatus) {
        if (ballStatus == BallStatus.STRIKE)
            strike_cnt += 1;
        if (ballStatus == BallStatus.BALL)
            ball_cnt += 1;
    }

    public int[] getResult() {
        int[] result = new int[2];
        result[0] = this.strike_cnt;
        result[1] = this.ball_cnt;
        return result;
    }

    public Balls extractRandomBalls() {
        int n1 = extractRandomValue();
        int n2 = extractRandomValue();
        int n3 = extractRandomValue();

        if (ValidationUtils.isDuplicated(Arrays.asList(n1, n2, n3))) {
            return extractRandomBalls();
        }

        return new Balls(Arrays.asList(n1, n2, n3));
    }

    public int extractRandomValue() {
        Random random = new Random();
        int min = 1;
        int max = 9;
        return random.nextInt(max - min + 1) + min;
    }
}
