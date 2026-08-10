/*
Premise: find the sorted half. if left half is sorted, nums[start] could be the potential minimum
element. Store it and eliminate the left half by doing start = mid + 1

if right half is sorted, nums[mid] could be the potential minimum element. Store it and eliminate
right half by doing end = mid - 1.

Take advantage of sorted half. Find potential minimum and eliminate that sorted half.

TC: O(log n)
SC: O(1)

*/

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
