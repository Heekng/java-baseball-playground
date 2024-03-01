package study;

import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Scanner scanner;

    @BeforeEach
    void setUp() {
        Scanner scanner = new Scanner(System.in);
    }

    @Test
    @DisplayName("")
    void test() throws Exception {
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        for (String text : values) {

        }
    }

}
