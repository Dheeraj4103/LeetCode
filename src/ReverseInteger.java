public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));
    }
    static int reverse(int x) {
        int last = (int) Math.pow(2, 31);
        boolean sign = (x < 0 ? true : false);
        x *= (sign ? -1 : 1);
        Integer n = x;
        String str = n.toString();
        int len = str.length()-1;
        int ans = 0;

        while (x > 0){
            int dig = x % 10;
            ans += (dig * Math.pow(10, len));
            x /= 10;
            len--;
        }
        ans *= (sign ? -1 : 1);
        if (ans < (last*(-1)) || ans > (last-1))
            return 0;
        return ans;
    }
}
