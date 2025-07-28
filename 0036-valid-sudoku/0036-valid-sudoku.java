class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> grids = new HashMap<>();

        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                Character ch = board[i][j];
                if (ch=='.') continue;
                String gridKey = (i/3)+","+(j/3);
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(ch) || 
                    cols.computeIfAbsent(j, k -> new HashSet<>()).contains(ch) || 
                    grids.computeIfAbsent(gridKey, k -> new HashSet<>()). contains(ch)
                ) return false;

                rows.get(i).add(ch);
                cols.get(j).add(ch);
                grids.get(gridKey).add(ch);
            }
        }

        return true;

    }
}