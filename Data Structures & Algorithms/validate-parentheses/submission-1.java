class Solution {
    public boolean isValid(String s) {
        // A valid string pairs every opener with a closer, so length must be even.
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            // On an opener, push the closer we EXPECT to see next.
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            }
            // Otherwise ch is a closer: it must match the top of the stack.
            // Empty stack means a closer arrived with no opener waiting.
            else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
