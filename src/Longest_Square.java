import java.util.Arrays;

public class Longest_Square {
    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        System.out.println(longestSquareStreak(nums));
    }
    static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            int target = nums[i] * nums[i];
            int idx = Binary_Search(nums, i + 1, nums.length-1, target);
            while (idx != -1) {
                count += 1;
                target = nums[idx] * nums[idx];
                idx = Binary_Search(nums, idx + 1, nums.length-1, target);
            }

            max = (count > max ? count : max);
            count = 1;
        }
        return (max == 1 ? -1 : max);
    }

    static int Binary_Search(int[] nums, int st, int end, int target){
        while (st <= end){
            int mid = st + (end - st)/2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
        return -1;
    }
}
