/**
TC: O(n)
SC: O(n)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] leftPrefixProduct = new int[n];
        int[] rightSuffixProduct = new int[n];

        leftPrefixProduct[0] = 1;
        rightSuffixProduct[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            leftPrefixProduct[i] = leftPrefixProduct[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            rightSuffixProduct[i] = rightSuffixProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = leftPrefixProduct[i] * rightSuffixProduct[i];
        }

        return result;
    }
}
