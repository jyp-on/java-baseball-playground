package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항1() {
        String[] split1 = "1,2".split(",");
        assertThat(split1).contains("1", "2");

        String[] split2 = split1[0].split(",");
        assertThat(split2).containsExactly("1");
    }

    @Test
    void 요구사항2() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("AssertJ IndexOutOfBoundsException Test")
    void 요구사항3() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(5);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
