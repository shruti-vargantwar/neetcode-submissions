class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        char[] sArr = s.toLowerCase().toCharArray(); // important step: lowercase
        int left = 0, right = s.length() - 1;
        while (left < right) { // <, not <=

            // <, not <=
            while (left < right && !Character.isLetterOrDigit(sArr[left])) {
                left++;
            }
            // <, not <=
            while (left < right && !Character.isLetterOrDigit(sArr[right])) {
                right--;
            }

            if (sArr[left] != sArr[right]) {
                return false;
            }

            left++; // imp step: increment left
            right--; // imp step: decrement right
        }

        return true;
    }
}
