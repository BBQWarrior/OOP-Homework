package fel_4;

public interface IExpression {
    String[] operators = {"+", "*"};

    static boolean isOperator(String str) {
        for (String operator : operators) {
            if (operator.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static double evaluate(String str) throws ExpressionException {
        String[] items = str.split(" ");
        Stack stack = new Stack(items.length);
        for (String item : items) {
            if (isOperator(item.trim())) {
                try {
                    double a = (double) stack.top();
                    stack.pop();
                    double b = (double) stack.top();
                    stack.pop();
                    if (item.trim().equals("+")) {
                        stack.push(a + b);
                    } else if (item.trim().equals("*")) {
                        stack.push(a * b);
                    }
                } catch (StackException e) {
                    throw new ExpressionException("\tWrong postfix expression");
                }
            } else {
                try {
                    double newDouble = Double.parseDouble(item.trim());
                    try {
                        stack.push(newDouble);
                    } catch (StackException e) {
                        throw new ExpressionException("\tWrong operand: " + item.trim());
                    }
                } catch (NumberFormatException e) {
                    throw new ExpressionException("\tWrong operand: " + item.trim());
                }
            }
        }
        try {
            return (double) stack.top();
        } catch (StackException e) {
            throw new ExpressionException("\tWrong postfix expression");
        }
    }
}
