package step2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+:10:20:30", "-:20:10:10", "*:5:20:100", "/:20:10:2"}, delimiter = ':')
    @DisplayName("operator 테스트")
    void operatorTest(String operatorSymbol, int number1, int number2, int result) throws Exception {
        assertThat(Operator.findOperator(operatorSymbol).operate(number1, number2)).isEqualTo(result);
    }

    @Test
    @DisplayName("plus 테스트")
    void plus() throws Exception {
        int result = Operator.PLUS.operate(10, 20);
        assertThat(result).isEqualTo(30);
    }

    @Test
    @DisplayName("minus 테스트")
    void minus() throws Exception {
        int result = Operator.MINUS.operate(20, 10);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("multiply 테스트")
    void multiply() throws Exception {
        int result = Operator.MULTIPLY.operate(5, 20);
        assertThat(result).isEqualTo(100);
    }

    @Test
    @DisplayName("divide 테스트")
    void divide() throws Exception {
        int result = Operator.DIVIDE.operate(20, 10);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("divide zero 테스트")
    void divideZeroExceptionTest() throws Exception {
        assertThatThrownBy(() -> {
            Operator.DIVIDE.operate(10, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
