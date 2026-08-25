/*
Premise: when s1's permutation will be found in s2, hashmap representing s1 nd s2 will be equal.

Critical step: k = s1's length. This is a fixed length sliding window problem.
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        int k = s1.length();// critical step

        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        char[] s2Arr = s2.toCharArray();

        // Process first k chars
        for (int i = 0; i < k; i++) {
            s2Map.put(s2Arr[i], s2Map.getOrDefault(s2Arr[i], 0) + 1);
        }

        // Initialize/Calculate potential answer
        if (s1Map.equals(s2Map)) {
            return true;
        }

        for (int i = k; i < s2Arr.length; i++) {
            // Process i-k char: outgoing
            s2Map.put(s2Arr[i - k], s2Map.get(s2Arr[i - k]) - 1);
            if (s2Map.get(s2Arr[i - k]) == 0) {
                s2Map.remove(s2Arr[i - k]);
            }

            // Process ith char: incoming
            s2Map.put(s2Arr[i], s2Map.getOrDefault(s2Arr[i], 0) + 1);

            // Calculate potential answer

            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }
}
