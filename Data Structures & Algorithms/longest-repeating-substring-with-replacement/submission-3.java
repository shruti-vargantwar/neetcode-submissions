class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        char[] sArr = s.toCharArray();

        for (int right = 0; right < sArr.length; right++) {
            map.put(sArr[right], map.getOrDefault(sArr[right], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(sArr[right]));

            // char_to_be_replaced = window_size - maxFreq
            while ((right - left + 1) - maxFreq > k) { // window is invalid
                map.put(sArr[left], map.get(sArr[left]) - 1);
                if (map.get(sArr[left]) == 0) {
                    map.remove(sArr[left]);
                }
                left++; // critical step
            }
            // window is valid
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
