class Solution {
    public int longestConsecutive(int[] nums) {
        int maxGlobalSequenceLength = 0;

        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currSequenceLength = 1;

            int nextNum = num + 1;
            while (map.containsKey(nextNum) && !map.get(nextNum)) {
                currSequenceLength++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++; // critical step
            }

            int prevNum = num - 1;
            while (map.containsKey(prevNum) && !map.get(prevNum)) {
                currSequenceLength++;
                map.put(prevNum, Boolean.TRUE);
                prevNum--; // critical step
            }

            maxGlobalSequenceLength = Math.max(maxGlobalSequenceLength, currSequenceLength);
        }

        return maxGlobalSequenceLength;
    }
}
