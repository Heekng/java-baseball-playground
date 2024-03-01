package step2;

public class Formula {

    private String[] formula;
    private final String FORMULA_SPLITTER = " ";

    public Formula(String formula) {
        this.formula = formula.split(FORMULA_SPLITTER);
    }

    public String[] getFormula() {
        return formula;
    }

}
