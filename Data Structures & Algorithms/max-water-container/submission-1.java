class Solution {
    public int maxArea(int[] heights) {
        int globalMaxArea = Integer.MIN_VALUE;
        int left = 0, right = heights.length - 1;

        while (left < right) {
            // area = height * width
            int height = Math.min(heights[left], heights[right]);
            int width = right - left ;
            int currArea = height * width;
            globalMaxArea = Math.max(globalMaxArea, currArea);

            if (heights[left] < heights[right]) {
                /* decrement left because no point in staying at less height from left
             hand side. Less height will always restrict the water*/
                left++;
            } else {
                right--;
            }
        }

        return globalMaxArea;
    }
}
