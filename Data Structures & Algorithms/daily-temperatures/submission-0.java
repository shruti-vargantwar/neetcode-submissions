/*
496. Next Greater Element I
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // push indices instead of temperature

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
                stack.push(i);
            } else {
                result[i] = stack.peek() - i;
                stack.push(i);
            }
        }
        return result;
    }
}
