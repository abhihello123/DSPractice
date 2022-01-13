package array.leetcode;

import java.util.*;

public class ValidateSudoku {

    public static void main(String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        ValidateSudoku obj = new ValidateSudoku();
        System.out.println(obj.isValidSudoku(board));
    }

    private boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet;
        List<Set<Character>> colSetList = new ArrayList<>();
        Map<Integer, Set<Character>> subArrayMap = new HashMap<>();
        for (int i=0;i<board.length;i++) colSetList.add(new HashSet<>());

        int key;
        for (int i = 0; i < board.length; i++) {
            rowSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char element = board[i][j];
                if (element == '.') continue;
                Set<Character> colSet = colSetList.get(j);
                if (rowSet.contains(element)) return false;
                rowSet.add(element);
                if (colSet.contains(element)) return false;
                colSet.add(element);
                key = ((i / 3) * 10 + (j / 3));
                Set<Character> subArraySet = subArrayMap.get(key);
                if (subArraySet == null) subArraySet = new HashSet<>();
                if (subArraySet.contains(element)) return false;
                subArraySet.add(element);
                subArrayMap.put(key, subArraySet);
            }
        }
        return true;
    }

}
