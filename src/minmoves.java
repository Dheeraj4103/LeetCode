public class minmoves {
    //https://leetcode.com/problems/minimum-moves-to-reach-target-score/
    public static void main(String[] args) {
        System.out.println(minMoves(10, 4));
    }
    static int minMoves(int target, int maxDoubles) {
        int cnt = 0;
        while (maxDoubles > 0 && target > 1){
            if (target % 2 == 0){
                target /= 2;
                maxDoubles--;
            }
            else
                target--;
            cnt++;
        }
        cnt += (target - 1);
        return cnt;
    }
}

