public class WordSearch {
    public static void main(String[] args) {
//        char[][] board  = {
//                {'A', 'B', 'C', 'E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };

        System.out.println(exist(board, "AAB"));
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (helper(board, i, j, word, "")){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean helper(char[][] board, int r, int c, String word, String p){
        char itm = board[r][c];

        if ((p+itm).equals(word)){
            return true;
        }

        boolean ahead = itm == word.charAt(p.length());
        board[r][c] = '#';
        boolean up = false, down = false, right = false, left = false;
        if (ahead){
            if (r > 0 && board[r-1][c] == word.charAt(p.length()+1)){
                up = helper(board, r-1, c, word, p+itm);
            }
            if (r < board.length-1 && board[r+1][c] == word.charAt(p.length()+1)){
                down = helper(board, r+1, c, word, p+itm);
            }
            if (c > 0 && board[r][c-1] == word.charAt(p.length()+1)){
                left = helper(board, r, c-1, word, p+itm);
            }
            if (c < board[0].length-1 && board[r][c+1] == word.charAt(p.length()+1)){
                right = helper(board, r, c+1, word, p+itm);
            }
        }
        board[r][c] = itm;
        return up || down || left || right;
    }
}
