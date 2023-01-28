public class leastcommonelement {
    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {3, 0, 1};
        int k = 1;

        System.out.println(getCommon(nums1, nums2, k));
    }

    static int getCommon(int[] nums1, int[] nums2, int k) {
        int add = 0, rm = 0;
        boolean getInside = false;
        for (int i = 0; i < nums1.length; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (nums1[i] < nums2[i]){
                getInside = true;
                if (diff % k == 0){
                    add += diff / k;
                }
            }
            if (nums1[i] > nums2[i]){
                getInside = true;
                if (diff % k == 0){
                    add += diff / k;
                }
            }
        }

        if (getInside){
            if (add != rm || add == 0 || rm == 0){
                return -1;
            }
        }
        return rm;

    }
}
