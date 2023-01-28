import java.util.ArrayList;

public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
//        int[] nums = {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int[] nums = {1,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1};
        System.out.println(longestOnes(nums, 9));
    }
    static int longestOnes(int[] nums, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        int check = (nums[0] == 0 ? 0 : 1);
        int cnt = 1;
        int itm = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != itm){
                ans.add(cnt);
                cnt = 0;
                itm = nums[i];
            }
            cnt++;
        }
        ans.add(cnt);
        int max = 0;
        int sm = 0;
        cnt = k;
        int i = check;
        while (i < ans.size()){
            int j = i;
            while (cnt >= 0 && j < ans.size()){
                if (j % 2 == check){
                    cnt -= ans.get(j);
                }
                if (cnt >= 0){
                    sm += ans.get(j);
                }
                if (cnt < 0){
                    cnt += ans.get(i);
                    sm += cnt;
                }
                j++;
            }
        }
        return max;
    }
}
