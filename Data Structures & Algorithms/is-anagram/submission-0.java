class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap();
        int strLength = s.length();

        for (int i = 0; i < strLength; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
}
