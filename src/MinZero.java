public class MinZero {
    public static int mod = 1_000_000_007;
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(5));
    }
    public static int minNonZeroProduct(int p) {

        if (p == 1){
            return 1;
        }

        long mx = (long) (Math.pow(2, p)) - 1;
        long sm = mx - 1;
        long n = sm / 2;
        long power = powerof(sm, n);

        return (int)(power * (mx % mod) % mod);
    }
    static long powerof(long val, long n){
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return (val % mod);
        }
        long newVal = ((val % mod) * (val % mod)) % mod;
        if (n % 2 != 0) {
            return ((powerof(newVal, n/2) % mod) * (val % mod)) % mod;
        }

        return powerof(newVal, n/2) % mod;
    }

}
