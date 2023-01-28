import java.util.Arrays;

public class targetsum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int[] nums1 = {1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    static int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0){
            if (target == 0){
                return 1;
            }
            return 0;
        }
        int count = 0;
        int value = nums[0];
        int negvalue = value*(-1);
        int[] temp = Arrays.copyOfRange(nums, 1, nums.length);
        count += findTargetSumWays(temp, target-value);
        count += findTargetSumWays(temp, target - negvalue);

        return count;
    }

}
