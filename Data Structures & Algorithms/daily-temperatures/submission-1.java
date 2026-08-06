/**
Very similar to next greater element. Only difference, instead of storing the actual element, we
should store the index in stack. Actual element can be referenced using index.
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Stack should store index of temperatures

        for (int i = n - 1; i >= 0; i--) { // Crtical step. Start from end of the array.
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                // result[i] = stack.peek();
                //  Critical step. Remember this
                result[i] = stack.peek() - i; // days to wait, not the raw index
            }

            stack.push(i);
        }

        return result;
    }
}
