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
}
