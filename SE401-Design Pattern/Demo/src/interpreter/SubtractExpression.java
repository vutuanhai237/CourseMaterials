package interpreter;

public class SubtractExpression implements Expression{
	private String expression;
	 
    public SubtractExpression(String expression) {
        this.expression = expression;
    }
 
    @Override
    public int interpret(Context context) {
        return context.subtract(expression);
    }
}
