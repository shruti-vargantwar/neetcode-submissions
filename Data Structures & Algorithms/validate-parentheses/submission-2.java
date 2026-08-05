/*
TC: O(n)
SC: O(n)
*/
class Solution {
    public boolean isValid(String s) {
        // A valid string pairs every opener with a closer, so length must be even.
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()) {
            // ch is an opening bracket. Push the expected closing brcket to stack
            if(ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if(ch == '[') {
                stack.push(']');
            } else {
                // ch is a closing bracket. it should match the last closing bracket on stack
                if(stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
