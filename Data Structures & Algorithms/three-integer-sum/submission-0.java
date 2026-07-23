class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = nums[left] + nums[right];

                if (currSum == target) {
                    List<Integer> tempList = Arrays.asList(nums[i], nums[left], nums[right]);
                    set.add(tempList);

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
