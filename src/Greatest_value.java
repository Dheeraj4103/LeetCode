public class Greatest_value {
    public static void main(String[] args) {
        int[][] grid = {{1,2,4}, {3,3,1}};
        System.out.println(deleteGreatestValue(grid));
    }
    static int deleteGreatestValue(int[][] grid) {
        int max_idx = 0;
        int max = 0;
        int ans = 0;
        for (int k = 0; k < grid[0].length; k++){
            for (int i = 0; i < grid.length; i++) {
                int temp = 0;
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] > temp){
                        temp = grid[i][j];
                        max_idx = j;
                    }
                }
                grid[i][max_idx] = 0;
                if (temp > max){
                    max = temp;
                }
            }
            ans += max;
            max = 0;
        }
        return ans;
    }
}
