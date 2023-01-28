public class checkpossiblity {
    public static void main(String[] args) {
        int[] nums = {1,4,1,2};
        System.out.println(checkPossibility(nums));
    }
    static boolean checkPossibility(int[] nums) {
        boolean check = false;
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > nums[i]){
                if (!check){
                    if (checkpos(nums, i-1, nums[i]) == i-1){
                        nums[i-1] = nums[i];
                        check = true;
                    }
                    else if (checkpos(nums, i-1, nums[i-1]) == i-1){
                        nums[i] = nums[i-1];
                        check = true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    static int checkpos(int[] nums, int i, int target){
        int end = i;
        int pos = end;
        while (end >= 0){
            if (nums[end] > target){
                pos = end;
            }
            end--;
        }
        return pos;
    }
}
