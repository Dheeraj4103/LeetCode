import java.util.Arrays;

public class Max_Grid {
    public static void main(String[] args) {
//        int[][] grid = {
//                {1,2,3},
//                {2,5,7},
//                {3,5,1}
//        };

        int[][] grid = {
                {5,2,1},
                {1,1,2}
        };
        int[] ans = maxPoints(grid, new int[]{3});
        System.out.println(Arrays.toString(ans));
    }
    static int[] maxPoints(int[][] grid, int[] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++){

            ans[i] = helper(CopyGrid(grid), queries[i], 0, 0);
        }
        return ans;
    }
    static int[][] CopyGrid(int[][] grid){
        int[][] temp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }
    static int helper(int[][] grid, int query, int r, int c){
        int count = 0;
        if (grid[r][c] < query){
            count++;
        }
        else{
            return 0;
        }
        int temp = grid[r][c];
        grid[r][c] = query;
        if (r < grid.length-1){
                count += helper(grid, query, r+1, c);

        }
        if (c > 0){
                count += helper(grid, query, r, c-1);
        }
        if (c < grid[0].length-1){
                count += helper(grid, query, r, c+1);
        }

        return count;
    }
}
