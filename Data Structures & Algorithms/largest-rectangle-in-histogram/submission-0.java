/*
area = heights[i] * (rSmall - lSmall) - 1;
Goal: find max area
Calculate left and right nearest smallest elements array
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int globalMaxArea = 0;

        int[] right = this.getRightSmallestElements(heights);
        int[] left = this.getLeftSmallestElements(heights);

        for(int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] - 1;
            int currArea = heights[i] * width;
            globalMaxArea = Math.max(globalMaxArea, currArea);
        }

        return globalMaxArea;
    }

    private int[] getRightSmallestElements(int[] heights) {
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>(); // store index in stack instead of actual height

        // Traverse from right since we need to find nearest smallest on right
        for(int i = heights.length-1; i >=0; i--) {
            // We are interested in smaller numbers, hence pop large numbers from stack
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length: stack.peek();
            stack.push(i);
        }

        return right;
    }

    private int[] getLeftSmallestElements(int[] heights) {
        int[] left = new int[heights.length];
        Stack<Integer> stack = new Stack<>(); // store index in stack instead of actual height

        // Traverse from left since we need to find nearest smallest on left
        for(int i = 0; i < heights.length; i++) {
            // We are interested in smaller numbers, hence pop large numbers from stack
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }

        return left;
    }
}
