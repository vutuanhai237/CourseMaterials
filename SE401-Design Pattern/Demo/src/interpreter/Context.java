package interpreter;

public class Context {
	 
    public int add(String input) {
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1 + num2);
    }
 
    public int subtract(String input) {
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1 - num2);
    }
 
    private String[] interpret(String input) {
        String str = input.replaceAll("[^0-9]", " ");
        str = str.replaceAll("( )+", " ").trim();
        return str.split(" ");
    }
}