package baseball;

import java.util.List;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        PlayManager playManager = new PlayManager();
        Balls answer = playManager.extractRandomBalls();
        Scanner sc;
        while(true) {
            System.out.print("숫자를 입력해 주세요 : ");
            sc = new Scanner(System.in);
            String input = sc.nextLine();

            List<Integer> integerList = ValidationUtils.inputValidation(input);
            Balls userBalls = new Balls(integerList);
            int[] record1 = answer.play(userBalls.getBall(0));
            int[] record2 = answer.play(userBalls.getBall(1));
            int[] record3 = answer.play(userBalls.getBall(2));

            int strike_cnt = record1[0] + record2[0] + record3[0];
            int ball_cnt = record1[1] + record2[1] + record3[1];
            String show = ResultView.show(strike_cnt, ball_cnt);
            ResultView.processShow(show);
        }
    }
}
