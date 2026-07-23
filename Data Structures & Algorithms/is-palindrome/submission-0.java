class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        char[] sArr = s.toLowerCase().toCharArray();

        while(left < right) {

            while(left < right && !Character.isLetterOrDigit(sArr[left])) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(sArr[right])) {
                right--;
            }

            if(sArr[left] != sArr[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
