class Solution {
    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char ch : tArr) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int need = tMap.size(); // unique chars in t
        int have = 0;
        int left = 0;

        int[] windowPointers = {-1, -1};
        int globalMin = Integer.MAX_VALUE;

        for (int right = 0; right < sArr.length; right++) {
            // Expand the window
            char currChar = sArr[right];
            sMap.put(currChar, sMap.getOrDefault(currChar, 0) + 1);

            if (tMap.containsKey(currChar) && sMap.get(currChar).equals(tMap.get(currChar))) {
                have++;
            }
            // Shrink the window while it is valid
            while (need == have) {
                // Process outgoing char. Check if outgoing char contributed to have count

                char leftChar = sArr[left];
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (sMap.get(leftChar) == 0) {
                    sMap.remove(leftChar);
                }

                if (tMap.containsKey(leftChar)
                    && sMap.getOrDefault(leftChar, 0) < tMap.get(leftChar)) {
                    have--;
                }

                // Compute
                int currWindowLen = right - left + 1;
                /*globalMin = Math.min(globalMin, currWindowLen);
                windowPointers[0] = left;
                windowPointers[1] = right;*/
                if (currWindowLen < globalMin) {
                    globalMin = currWindowLen;
                    windowPointers[0] = left;
                    windowPointers[1] = right;
                }

                // Increment left
                left++;
            } // window is valid
        }

        return globalMin == Integer.MAX_VALUE
            ? ""
            : s.substring(windowPointers[0], windowPointers[1] + 1);
    }
}
