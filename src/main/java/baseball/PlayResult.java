package baseball;

public class PlayResult {
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
}
