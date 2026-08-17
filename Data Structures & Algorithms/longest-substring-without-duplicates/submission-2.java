class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        for(int right = 0; right < sArr.length; right++) {
            // Add incoming char
            map.put(sArr[right], map.getOrDefault(sArr[right], 0) + 1);

            while(map.get(sArr[right]) > 1) { // window is invalid
                map.put(sArr[left], map.get(sArr[left]) - 1);
                if(map.get(sArr[left]) == 0) {
                    map.remove(sArr[left]);
                }
                left++;
            }
            // Window is valid here: Record answer. 
            // Current window: right - left + 1
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
