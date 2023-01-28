public class Searchtheword {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board1 = {{'a'}};
        System.out.println(exist(board, "ABCCED"));
    }

    static boolean exist(char[][] board, String word) {
        boolean ans = false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    ans = SearchWord(board, i, j, "", word);
                    if (ans){
                        return true;
                    }
                }
            }
        }
        return ans;
    }

    static boolean SearchWord(char[][] board, int r, int c, String ans, String word){


        char itm = board[r][c];
        if ((ans+itm).equals(word)){
            return true;
        }
        board[r][c] = '#';


        boolean b = itm == word.charAt(ans.length());
        boolean up = false, right = false, left =false , down = false;
        if (b) {
            if (c < board[0].length-1) { // go right
                right = SearchWord(board, r, c + 1, ans + itm, word);
                if (right)
                    return true;
            }
            if (r < board.length-1) { // go down

                down = SearchWord(board, r + 1, c, ans + itm, word);
                if (down)
                    return true;
            }
            if (r > 0) { // go up
                up = SearchWord(board, r - 1, c, ans + itm, word);
                if (up)
                    return true;
            }

            if (c > 0) { // go left
                left = SearchWord(board, r, c - 1, ans + itm, word);
                if (left)
                    return true;
            }

        }
        board[r][c] = itm;
        return false;
    }
}
