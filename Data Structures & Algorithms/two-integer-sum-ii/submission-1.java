/**
TC: O(n)
SC:O(1)
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int currSum = numbers[left] + numbers[right];
            if (currSum == target) {
                return new int[] {left + 1, right + 1};
            }

            if (currSum > target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }

        return new int[] {-1, -1};
    }
}
