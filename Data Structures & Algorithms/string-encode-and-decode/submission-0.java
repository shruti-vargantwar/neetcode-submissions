class Solution {
    public final String DELIMITER = "#";

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            encodedString.append(s.length()).append(DELIMITER).append(s);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        // length # content
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimIndex = str.indexOf(DELIMITER, i);

            int length = Integer.parseInt(str.substring(i, delimIndex));

            String decodedStr = str.substring(delimIndex + 1, delimIndex + 1 + length);

            decodedStrings.add(decodedStr);

            i = delimIndex + 1 + length;
        }

        return decodedStrings;
    }
}
