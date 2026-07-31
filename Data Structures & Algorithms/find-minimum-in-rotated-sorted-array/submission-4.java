/*
Premise: Sorted half may or may not have the answer
*/

class Solution {
    public int findMin(int[] nums) {
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[end]) {
                answer = Math.min(answer, nums[start]);
                break;
            }

            if (nums[start] <= nums[mid]) { // left is sorted
                answer = Math.min(answer, nums[start]);
                start = mid + 1; // head towards unsorted region
            } else {
                // right is sorted
                answer = Math.min(answer, nums[mid]);
                end = mid - 1; // head towards unsorted region
            }
        }

        return answer;
    }
}
