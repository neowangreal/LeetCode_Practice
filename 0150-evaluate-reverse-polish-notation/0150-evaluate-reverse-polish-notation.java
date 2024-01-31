class Solution {

    public int evalRPN(String[] arr) {

        // Check if there is only one element in the array
        if (arr.length == 1) {
            return Integer.parseInt(arr[0]);
        }

        // Set to check if an element is an operator
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");

        // Stack to perform the evaluation
        Stack<Integer> stack = new Stack<>();

        // Iterate through the input array
        for (String token : arr) {

            // If the token is not an operator, push it onto the stack
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));

            } else {
                // If it is an operator, pop two operands from the stack and perform op.
                int a = stack.pop();
                int b = stack.pop();
                int result = performOperation(b, a, token);

                // Push the result back onto the stack
                stack.push(result);
            }
        }

        // The final result is on the top of the stack
        return stack.pop();
    }

    // method to find op between operand
    private int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;

            // of no use
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}