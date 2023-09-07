package study;

import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Set;

public class StringCalculator {
    public static final Set<String> OPERATOR = new HashSet<>(4);

    static {
        OPERATOR.add("+");
        OPERATOR.add("-");
        OPERATOR.add("*");
        OPERATOR.add("/");
    }

    public int init(String input) {
        String[] tokens = input.split(" ");
        int result = validateNumberAndParseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String op = validateOperator(tokens[i]);
            int num = validateNumberAndParseInt(tokens[i+1]);
            result = calculate(op, result, num);
        }

        return result;
    }

    public int validateNumberAndParseInt(String number) {
        try {
            int validatedNumber = Integer.parseInt(number);
            return validatedNumber;
        } catch(IllegalFormatException exception) {
            throw exception;
        }
    }

    public String validateOperator(String op) {
        if (OPERATOR.contains(op)) {
            return op;
        }
        throw new IllegalArgumentException("올바른 연산자가 아닙니다: " + op);
    }

    private int calculate(String op, int result, int num) {
        if (op.equals("+"))
            return result += num;
        if (op.equals("-"))
            return result -= num;
        if (op.equals("*"))
            return result *= num;
        if (op.equals("/"))
            return result /= num;

        return result;
    }


}
