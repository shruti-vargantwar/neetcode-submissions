/**
Approach: Try to find the sorted section so we can apply binary search.
TC: O(log n)
SC: O(1)
*/
class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid; // lucky case
            }

            // Rotation divides array into sorted and unsorted region. Try to find sorted region to
            // apply binary search

            if (nums[start] <= nums[mid]) { // Left half is sorted
                // Possibly the answer lies here. Apply binary search in this region
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1; // Head towards unsorted region on the right
                }
            } else { // num[mid] <= nums[end]
                // Right half is sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1; // Head towards unsorted region on the left
                }
            }
        }

        return result;
    }
}
