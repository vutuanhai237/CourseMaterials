package interpreter;

public class AddExpression implements Expression {
	private String expression;
	 
    public AddExpression(String expression) {
        this.expression = expression;
    }
 
    @Override
    public int interpret(Context context) {
        return context.add(expression);
    }
}
