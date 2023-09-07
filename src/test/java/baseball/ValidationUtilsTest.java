package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {
    @Test
    @DisplayName("숫자_1_9_검증")
    void 숫자_1_9_검증() {
        // 빠르고 좋은 테스트를 위해 경계값 위주로 테스트
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(0)).isFalse();
        assertThat(ValidationUtils.validNo(10)).isFalse();
    }

    @Test
    @DisplayName("중복이있는지")
    void 중복이있는지() {
        assertThat(ValidationUtils.isDuplicated(1, 5, 6)).isFalse();
        assertThat(ValidationUtils.isDuplicated(1, 2, 2)).isTrue();
        assertThat(ValidationUtils.isDuplicated(1, 2, 1)).isTrue();
        assertThat(ValidationUtils.isDuplicated(2, 2, 3)).isTrue();
    }

    @Test
    @DisplayName("세자리인지")
    void 세자리인지() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.isThree("1234");
        });
        assertThat(ValidationUtils.isThree("123")).isTrue();
    }
}
