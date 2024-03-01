package step2;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern regExp = Pattern.compile("^[0-9]*$");
    private Formula formula;

    public StringCalculator(Formula formula) {
        this.formula = formula;
    }

    public int calculate() {
        int result = 0;
        Operator currentOperator = Operator.PLUS;

        for (String input : formula.getFormula()) {
            if (regExp.matcher(input).find()) {
                result = currentOperator.operate(result, Integer.parseInt(input));
                continue;
            }
            currentOperator = Operator.findOperator(input);
        }

        return result;
    }

}
