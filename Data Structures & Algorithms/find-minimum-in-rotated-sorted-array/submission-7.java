class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int result = Integer.MAX_VALUE;

        if (nums[start] <= nums[end]) {
            // Entire array is sorted. The number at index start is the minimum element.
            return nums[start];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]) { // Left half is sorted
                result = Math.min(result, nums[start]);
                start = mid + 1; // Discard left half since we have recorded potential answer.  Move
                                 // towards unsorted right region.
            } else {
                // Right half is sorted: nums[mid] < nums[end]
                result = Math.min(result, nums[mid]);
                end = mid - 1; // Discard right half since we have recorded potential answer.  Move
                               // towards unsorted left region.
            }
        }

        return result;
    }
}
