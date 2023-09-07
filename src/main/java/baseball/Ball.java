package baseball;

public class Ball {
    private int location;
    private int num;

    public Ball(int location, int num) {
        this.location = location;
        this.num = num;
    }

    public BallStatus play(Ball ball) {
        if ((ball.matchBallLocation(location)) && (ball.matchBallNo(num)))
            return BallStatus.STRIKE;

        if (ball.matchBallNo(num))
            return BallStatus.BALL;

        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int num) {
        return this.num == num;
    }

    private boolean matchBallLocation(int location) {
        return this.location == location;
    }

    public String toString() {
        return "Location : " + this.location + " num : " + this.num;
    }
}
