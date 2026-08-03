/**
water(i) = min(maxLeftHeight, maxRightHeight) - height(i)
maxLeftHeight(i) = max(maxLeftHeight(i-1), height(i))
maxRightHeight(i) = max(maxRightHeight(i+1), height(i))
TC: O(n)
SC: O(n)
*/

class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;

        int[] maxLeftHeight = new int[n];
        int[] maxRightHeight = new int[n];

        maxLeftHeight[0] = height[0]; // critical step
        maxRightHeight[n - 1] = height[n - 1]; //critical step

        for (int i = 1; i < n; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            totalWater += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
        }

        return totalWater;
    }
}
