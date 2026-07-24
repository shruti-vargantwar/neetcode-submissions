class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) { // opening bracket
                stack.push(ch);
            } else { // closing bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.peek();
                if (map.get(open) != ch) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
