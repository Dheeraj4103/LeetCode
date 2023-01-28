import java.util.ArrayList;

public class largestnumafterswap {
    public static void main(String[] args) {
//        largestInteger(1234);
        int s = 01;
        System.out.println(s);
    }
    static void largestInteger(int num) {
        int n = num;
        ArrayList<Integer> ans = new ArrayList<>();
        while (n > 0){
            int digit = n%10;
            ans.add(digit);
            n /= 10;
        }
        int p = 1;
        while (num > 0){
            int digit = (num%10) % 2;
            int min = Integer.MAX_VALUE;
            for (int itm : ans){
                if (itm%10 == digit) {
                    min = Math.min(itm, min);
                    ans.remove(min);
                }
            }
            num /= 10;
            n += min*p;
            p *= 10;
        }
        System.out.println(n);
    }
}
