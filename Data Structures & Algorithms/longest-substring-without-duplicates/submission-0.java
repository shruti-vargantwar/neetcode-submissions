/*
TC: O(n) | n is length of string
SC: O(m) | m is number of unique characters in the string
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] inputStr = s.toCharArray();
        int left = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap();

        for (int right = 0; right < inputStr.length; right++) {
            map.put(inputStr[right], map.getOrDefault(inputStr[right], 0) + 1);

            while (map.get(inputStr[right]) > 1) {
                map.put(inputStr[left], map.get(inputStr[left]) - 1);
                if (map.get(inputStr[left]) == 0) {
                    map.remove(inputStr[left]);
                }
                left++; // very critical
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
