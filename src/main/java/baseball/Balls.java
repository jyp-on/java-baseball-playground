package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> answer;

    public Balls(List<Integer> answer) {
        this.answer = mapBall(answer);
    }

    public int[] play(Ball userBall) {
        PlayManager playManager = new PlayManager();

        for (int i = 0; i < answer.size(); i++) {
            playManager.record(answer.get(i).play(userBall));
        }

        return playManager.getResult();
    }

    public List<Ball> mapBall(List<Integer> balls) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            ballList.add(new Ball(i+1, balls.get(i)));
        }
        return ballList;
    }

    public Ball getBall(int i) {
        return this.answer.get(i);
    }
}
