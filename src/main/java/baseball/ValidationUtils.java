package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationUtils {
    public static boolean validNo(int num) {
        return num >= 1 && num <= 9;
    }

    public static boolean isDuplicated(List<Integer> integerList) {
        if (Objects.equals(integerList.get(0), integerList.get(1))) return true;
        if (Objects.equals(integerList.get(1), integerList.get(2))) return true;
        if (Objects.equals(integerList.get(0), integerList.get(2))) return true;
        return false;
    }

    public static boolean isThree(String numbers) {
        if (numbers.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException("3자리의 숫자를 입력해 주세요.");
    }

    public static List<Integer> parseNumber(String numbers) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            char digit = numbers.charAt(i);
            integerList.add(Integer.parseInt(String.valueOf(digit)));
        }

        return integerList;
    }

    public static List<Integer> inputValidation(String input) {
        ValidationUtils.isThree(input);
        List<Integer> integerList = ValidationUtils.parseNumber(input);

        boolean duplicated = ValidationUtils.isDuplicated(integerList);
        if (duplicated) throw new RuntimeException("중복된 숫자입니다.");

        boolean allValid = integerList.stream()
                .map(ValidationUtils::validNo)
                .allMatch(valid -> valid);

        if (allValid) return integerList;
        throw new IllegalArgumentException("1부터 9까지의 숫자만을 입력해 주세요.");
    }
}
