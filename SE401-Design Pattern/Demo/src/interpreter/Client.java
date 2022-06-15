package interpreter;

public class Client {
	public static void main(String args[]) {
        System.out.println("20 cộng 8 = " + interpret("20 cộng 8"));
        System.out.println("10 trừ 4 = " + interpret("10 trừ 4"));
    }
 
    private static int interpret(String input) {
        Expression exp = null;
        if (input.contains("cộng")) {
            exp = new AddExpression(input);
        } else if (input.contains("trừ")) {
            exp = new SubtractExpression(input);
        } else {
            throw new UnsupportedOperationException();
        }
        return exp.interpret(new Context());
    }
}
