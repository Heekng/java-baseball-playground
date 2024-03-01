package step2;

public class Main {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new Formula("2 + 3 * 4 / 2"));
        int result = stringCalculator.calculate();
        System.out.println("result: " + result);
    }
}
