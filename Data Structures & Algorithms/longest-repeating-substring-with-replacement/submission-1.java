class Solution {
    public int characterReplacement(String s, int k) {
        char[] sArr = s.toCharArray();
        int left = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; // highest freq seen in ANY window

        for (int right = 0; right < sArr.length; right++) {
            map.put(sArr[right], map.getOrDefault(sArr[right], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(sArr[right]));

            while ((right - left + 1) - maxFreq > k) { // critical step
                map.put(sArr[left], map.get(sArr[left]) - 1);
                if (map.get(sArr[left]) == 0) {
                    map.remove(sArr[left]);
                }

                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
