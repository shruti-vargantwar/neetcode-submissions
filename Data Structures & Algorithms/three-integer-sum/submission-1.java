/**
a + b + c = 0;
b + c = -a;

TC: O(n log n)
SC: O(n)
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums); // n log n

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int currSum = nums[left] + nums[right];
                if (target == currSum) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (currSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList(set);
    }
}
