package baseball;

import java.util.Scanner;

public class ResultView {

    public static String show(int strike, int ball) {
        if (strike == 3) return "3개의 숫자를 모두 맞히셨습니다! 게임종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        else if (strike != 0 && ball != 0) return ball + "볼 " + strike + "스트라이크";
        else if (strike == 0 && ball != 0) return ball + "볼";
        else if (strike != 0) return strike + "스트라이크";
        return "낫싱";
    }

    public static void processShow(String input) {
        if (input.startsWith("3개의")) {
            System.out.println(input);
            Scanner sc = new Scanner(System.in);
            checkRestart(sc.nextLine());
        }
        System.out.println(input);
    }

    public static void checkRestart(String input) {
        if (input.equals("1")) Baseball.play();
        if (input.equals("2")) System.exit(0);
    }
}
