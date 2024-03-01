package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2 라는 문자열을 split 했을 때, 1과 2로 분리된다.")
    void splitTwoArrayTest() throws Exception {
        // when
        String[] actual = "1,2".split(",");

        // then
        assertThat(actual.length).isEqualTo(2);
        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1 라는 문자열을 split 했을 때, 1만을 포함하는 배열이 리턴된다.")
    void splitOnlyOneTest() throws Exception {
        // when
        String[] actual = "1".split(",");
        // then
        assertThat(actual.length).isEqualTo(1);
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메서드는 문자열을 자른다.")
    void substringTest() throws Exception {
        // when
        String actual = "(1,2)".substring(1, 4);
        // then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 메서드는 특정 위치의 문자열을 가져온다.")
    void charAtTest() throws Exception {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');

        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(3);
        }).withMessageMatching("String index out of range: \\d+");
    }

}
