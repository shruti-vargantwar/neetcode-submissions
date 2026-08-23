class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap();
        Map<Character, Integer> s2Map = new HashMap();
        int k = s1.length();

        // Premise: When a permutation of s1 is found in s2, the hashmaps s1Map and s2Map would be
        // equal

        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        char[] s2Arr = s2.toCharArray();
        for (int i = 0; i < k; i++) { // check first k chars in s2 to detect palindrome
            s2Map.put(s2Arr[i], s2Map.getOrDefault(s2Arr[i], 0) + 1);
        }

        if (s1Map.equals(s2Map)) {
            return true;
        }

        for (int i = k; i < s2Arr.length; i++) {
            // Remove i-kth char's freq from map. If freq = 0, remove i-kth char
            s2Map.put(s2Arr[i - k], s2Map.get(s2Arr[i - k]) - 1);
            if (s2Map.get(s2Arr[i - k]) == 0) {
                s2Map.remove(s2Arr[i - k]);
            }

            // Add ith char to s2Map
            s2Map.put(s2Arr[i], s2Map.getOrDefault(s2Arr[i], 0) + 1);

            if (s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }
}
