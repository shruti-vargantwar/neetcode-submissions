class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currLength = 1;

            int nextNum = num + 1;
            while(map.containsKey(nextNum) && !map.get(nextNum)) {
                currLength++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++;
            }

            int prevNum = num - 1;
            while(map.containsKey(prevNum) && !map.get(prevNum)) {
                currLength++;
                map.put(prevNum, Boolean.TRUE);
                prevNum--;
            }

            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
