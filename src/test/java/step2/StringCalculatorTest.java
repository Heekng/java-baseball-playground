package step2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.CalculatorTest;

class StringCalculatorTest {

    @Test
    @DisplayName("정상적으로 입력값이 들어오면 계산된 값이 나온다.")
    void stringCalculateTest() throws Exception {
        StringCalculator stringCalculator = new StringCalculator(new Formula("1 + 5 - 2 * 10 / 2"));
        int result = stringCalculator.calculate();
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("연산 중 0으로 나누는 경우 IllegalArgumentException이 발생한다.")
    void divideZeroTest() throws Exception {
        StringCalculator stringCalculator = new StringCalculator(new Formula("1 + 5 - 2 * 10 / 0"));
        assertThatThrownBy(stringCalculator::calculate).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백일 경우 IllegalArgumentException 이 발생한다.")
    void nullOrEmptyTest() throws Exception {
        StringCalculator stringCalculator = new StringCalculator(new Formula("1 +   - 2 * 10 / 2"));
        assertThatThrownBy(stringCalculator::calculate).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 이외의 문자가 입력될 경우 IllegalArgumentException 이 발생한다.")
    void notOperationTest() throws Exception {
        StringCalculator stringCalculator = new StringCalculator(new Formula("1 ^ 5  - 2 * 10 / 2"));
        assertThatThrownBy(stringCalculator::calculate).isInstanceOf(IllegalArgumentException.class);
    }

}
