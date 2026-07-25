class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();

                    switch (token) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        default:
                            stack.push(a / b);
                    }
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
