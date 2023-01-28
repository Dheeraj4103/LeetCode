public class KDivisible {
    public static void main(String[] args) {
        int[] nums = {14,8,8};
        System.out.println(countDistinct(nums, 2, 17));
    }
    public static int countDistinct(int[] nums, int k, int p) {
        int count = 0;
        int i = 0;
        int pcount = 0;
        int st = 0;
        while (i < nums.length){
            if (nums[i] % p == 0){
                pcount++;
            }
            if (pcount == k){
                int n = i - st + 1;
                count += ((n * (n+1)) / 2);
                st = i+1;
                pcount = 0;
            }
            i++;
        }
        if (pcount != k){
            int n = i - st;
            count += ((n * (n+1)) / 2);
        }
        return count;
    }

}
