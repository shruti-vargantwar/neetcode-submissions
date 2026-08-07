/**
TC: O(n)
SC: O(n)
*/
class Solution {
    // Store index of height in stack. Why index? Because we need the width of histogram
    public Deque<Integer> stack;

    public int largestRectangleArea(int[] heights) {
        int globalMax = 0;
        int[] nextSmallerElements = this.getNextSmallElements(heights); // array of indices
        int[] prevSmallerElements = this.getPrevSmallElements(heights); // array of indices

        for (int i = 0; i < heights.length; i++) {
            int width =
                nextSmallerElements[i] - prevSmallerElements[i] - 1; // remember this formula
            globalMax = Math.max(globalMax, width * heights[i]);
        }

        return globalMax;
    }

    private int[] getNextSmallElements(int[] heights) {
        int[] result = new int[heights.length];
        stack = new ArrayDeque<>(); // store index in stack instead of height

        for (int i = heights.length - 1; i >= 0;
            i--) { // start from right since we need next smaller element
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty()
                ? heights
                      .length // right side's smaller element is bounded by length of heights array
                : stack.peek();
            stack.push(i);
        }

        return result;
    }

    private int[] getPrevSmallElements(int[] heights) {
        int[] result = new int[heights.length];
        stack = new ArrayDeque<>(); // store index in stack instead of height

        for (int i = 0; i < heights.length;
            i++) { // start from left since we need prev smaller element
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            // left side's smaller element is bounded by -1
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return result;
    }
}
