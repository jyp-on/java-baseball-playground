package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> answer;

    public Balls(List<Integer> answer) {
        this.answer = mapBall(answer);
    }

    public int[] play(Ball userBall) {
        PlayResult playResult = new PlayResult();

        for (int i = 0; i < answer.size(); i++) {
            playResult.record(answer.get(i).play(userBall));
        }

        return playResult.getResult();
    }

    public List<Ball> mapBall(List<Integer> balls) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            System.out.println(i+1 + " " + balls.get(i));
            ballList.add(new Ball(i+1, balls.get(i)));
        }
        return ballList;
    }
}
