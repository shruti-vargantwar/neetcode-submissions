class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 hash sets for each region: rows, columns and boxes (3 by 3)
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize these hash sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char digit = board[row][col];
                if (digit == '.') {
                    continue;
                }

                // Need flattened co-ordinates for 9 boxes [0..8]
                int box = (row / 3) * 3 + (col / 3);
                // Duplicate in ANY of its three regions means the board is invalid.
                if (rows[row].contains(digit) || columns[col].contains(digit)
                    || boxes[box].contains(digit)) {
                    return false;
                }

                // First time seeing this digit here: record it in all three regions.
                rows[row].add(digit);
                columns[col].add(digit);
                boxes[box].add(digit);
            }
        }

        return true;
    }
}
