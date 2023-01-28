public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -3));
    }
    static int divide(int dividend, int divisor) {
        long cnt = 0;
        System.out.println(Math.abs((long)dividend));
        boolean orsign = (divisor < 0 ? true : false);
        boolean endsign = (dividend < 0 ? true : false);
        long divend = (long) dividend;
        long divsor = (long) divisor;
        divsor *= (orsign ? -1 : 1);
        divend *= (endsign ? -1 : 1);
        if (divsor == 1)
            cnt = divend;
        else {


            while (divend > 0) {
                if (divend >= divsor)
                    cnt++;
                divend -= divsor;

            }
        }
        cnt *= (orsign ? -1 : 1);
        cnt *= (endsign ? -1 : 1);
        long last = (long) Math.pow(2, 31);
        if (cnt > (last - 1))
            return (int)(last-1);
        if (cnt < (last * (-1)))
            return (int)(last * (-1));
        return (int)cnt;
    }
}
