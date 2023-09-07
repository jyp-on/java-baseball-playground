package baseball;

public class ValidationUtils {
    public static boolean validNo(int num) {
        return num >= 1 && num <= 9;
    }

    public static boolean isDuplicated(int no1, int no2, int no3) {
        if (no1 == no2) return true;
        if (no2 == no3) return true;
        if (no1 == no3) return true;
        return false;
    }

    public static boolean isThree(String numbers) {
        if (numbers.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException("3자리의 숫자를 입력해 주세요.");
    }
}
