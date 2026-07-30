/**
Encoding approach: (len1)#String1(len2)#String2
Decoding approach:
1. Try to get the delimiter's index: delimiterIndex
2. The number before delimiter is the length = strLength
3. Word = substring(delimiterIndex+1, strLength)
4. Add the word  in result array list.

TC:O(n)
SC: O(n)
*/

class Solution {
    private final String DELIMITER = "#";

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append(DELIMITER).append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            /* public int indexOf(String str, int fromIndex)
            str: A String value, representing the string to search for
            fromIndex: An int value, representing the index position to start the search from
            */
            int delimIndex = str.indexOf(DELIMITER, i);
            int length = Integer.parseInt(str.substring(i, delimIndex));
            String decodedStr = str.substring(delimIndex + 1, delimIndex + 1 + length);
            result.add(decodedStr);
            i = delimIndex + 1 + length;
        }

        return result;
    }
}
