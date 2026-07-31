/*
Approack: Try to find the sorted section so we can apply binary search.
TC: O(log n)
SC: O(1)
*/
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) { // lucky case
                return mid;
            }

            // Try to find which half is sorted
            if (nums[start] <= nums[mid]) { // left is sorted. We can apply binary search
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else { // right half is sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
