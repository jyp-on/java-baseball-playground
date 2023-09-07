package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator calculator;
    private InputStream originalInput;

    @BeforeEach
    @DisplayName("계산기 객체 생성 및 표준 입력 설정")
    void setUp() {
        calculator = new StringCalculator();
        originalInput = System.in;
    }

    @AfterEach
    @DisplayName("표준 입력을 원래대로 복원")
    void tearDown() {
        System.setIn(originalInput);
    }

    @Test
    void 계산기_성공테스트() {
        // 가짜 입력을 제공하기 위해 ByteArrayInputStream 사용
        String input = "2 + 3 * 4 / 2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 사용자 입력을 받는 부분을 호출
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        int result = calculator.init(userInput);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 숫자_유효성검사_성공() {
        String input = "2 + 3 * 4 / 2";
        String[] tokens = input.split(" ");

        for (int i = 0; i < tokens.length; i += 2) {
            calculator.validateNumberAndParseInt(tokens[i]);
        }
    }

    @Test
    void 숫자_유효성검사_실패() {
        String input = "2 + o * 4 / 2";
        String[] tokens = input.split(" ");

        assertThrows(NumberFormatException.class, () -> {
            for (int i = 0; i < tokens.length; i += 2) {
                calculator.validateNumberAndParseInt(tokens[i]);
            }
        });
    }

    @Test
    void 연산자_유효성검사_성공() {
        String input = "2 + 3 * 4 / 2";
        String[] tokens = input.split(" ");

        for (int i = 1; i < tokens.length - 1; i += 2) {
            calculator.validateOperator(tokens[i]);
        }
    }

    @Test
    void 연산자_유효성검사_실패() {
        String input = "2 . 3 * 4 / 2";
        String[] tokens = input.split(" ");

        assertThrows(IllegalArgumentException.class, () -> {
            for (int i = 1; i < tokens.length - 1; i += 2) {
                calculator.validateOperator(tokens[i]);
            }
        });
    }




}
