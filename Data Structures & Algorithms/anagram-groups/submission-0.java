/**
 TC: O (n * k log k)
 SC: O (n * k)

 where n is the number of elements in array and k is the max length of the word in the array
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) { // n
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr); // k log k

            String key = String.valueOf(wordArr);
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(word);
        }

        return new ArrayList(map.values());
    }
}
