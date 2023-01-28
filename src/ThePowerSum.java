public class ThePowerSum {
    public static void main(String[] args) {
        System.out.println(powerSum(12, 2));
    }

    public static int powerSum(int X, int N) {
        // Write your code here
        return helper(X, N, 0, 1);
    }

    static int helper(int x, int n, int currsum, int next){
        if (currsum == x){
            return 1;
        }
        if (currsum > x || next > (int) Math.sqrt(x)){
            return 0;
        }


        int count = 0;
        int sqnext = (int) Math.pow(next, n);
        count += helper(x, n, currsum + sqnext, next + 1);
        count += helper(x, n, currsum, next + 1);
        return count;
    }
}
