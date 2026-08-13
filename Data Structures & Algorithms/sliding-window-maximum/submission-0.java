/**
TC: O(n)
SC: O(n)
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
        }
        result.add(queue.peekFirst()); // maximum element in first k size window

        for (int i = k; i < nums.length; i++) {
            // Process outgoing element
            if (nums[i - k] == queue.peekFirst()) {
                queue.pollFirst();
            }

            // Process incoming element
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);

            // Compute/Store
            result.add(queue.peekFirst());
        }

        int[] answer = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            answer[index] = result.get(index);
        }

        return answer;
    }
}
