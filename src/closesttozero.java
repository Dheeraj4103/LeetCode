import java.util.Arrays;

public class closesttozero {
    public static void main(String[] args) {
        int[] nums = {61488,18221,-1321,90249,-62158,55128,-93476,53905,57644,24630,89599,-95795,-14891,-60298,17690,99022,-24006,-89156,80135,-46303,18812,59924,32024,82924,-47519,-77086,1763,68618,53629,-56957,95485,99630,-7977,31164,94481,-80239,-57749,-3319,-58231,-94841,-19292,33200,-31446,-3528,2229,74241,-19992,-91852,-28073,31453,-74484,35491,38870,-9499,39838,87369,21123,-38616,-89277,-14541,-81586,-18569,-58242,-71216,10816,15086,-10519,51080,53257,-4912,-37142,-16723,-69795,54937,-24920,68970,-10010,-81717,36203,-67939,73877,-58258,-57183,36637,91518,-8492,-57476,50523,62462,73152,-9511,-66761,28333,-87163,5187};
        System.out.println(findClosestNumber(nums));
    }
    static int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int[] ans = Floor(nums, 0);
        if (Math.abs(ans[0]) > Math.abs(ans[1])){
            return ans[1];
        }
        else if (Math.abs(ans[1]) > Math.abs(ans[0])){
            return ans[0];
        }
        else{
            return Math.max(ans[0], ans[1]);
        }

    }
    static int[] Floor(int[] nums, int target){
        int st = 0, end = nums.length-1;
        while (st <= end){
            int mid = st + (end-st)/2;
            if (target > nums[mid])
                st = mid + 1;
            else
                end = mid - 1;
        }
        if (st >= nums.length){
            st--;
        }
        if (end < 0)
            end++;
        int[] ans = {nums[st], nums[end]};
        return ans;
    }
}
