import java.util.Arrays;

public class SubsetXor {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,3}));
    }
    static int subsetXORSum(int[] nums) {
        return helper(nums, 0);
    }
    static int helper(int[] nums, int xorsum){
        if (nums.length == 0){
            return xorsum;
        }

        int xor = xorsum ^ nums[0];
        int sum = helper(Arrays.copyOfRange(nums, 1, nums.length), xor);
        sum += helper(Arrays.copyOfRange(nums, 1, nums.length), xorsum);

        return sum;
    }

}
