public class countgoodnumbers {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
    static int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n / 2;
        long ans = (powerof(5l, even) * powerof(4l, odd));
        ans  = ans % 1000000007;
        return (int) ans;
    }
    static long powerof(long pow, long n){
        long ans = 1;

        while (n > 0){
            if ((n & 1) == 1){
                ans = (ans * pow) % 1000000007;
            }
            pow = (pow*pow) % 1000000007;
            n = n >> 1;
        }
        return ans;
    }
}
