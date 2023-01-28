public class SingleElement {
    // https://leetcode.com/problems/single-element-in-a-sorted-array/
    public static void main(String[] args) {
        int[] arr = {1,1,2};
//        int[] arr = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr));
    }
    static int singleNonDuplicate(int[] arr) {
        int st = 0, end = arr.length-1;

        while (st <= end){
            int mid = st + (end-st)/2;
            int pivot;
            int prev = (arr.length+(mid-1))%arr.length;
            int next = (arr.length+(mid+1))%arr.length;
            if (arr[mid] == arr[prev]){
                pivot = mid;
            }
            else if (arr[mid] == arr[next]){
                pivot = mid+1;
            }
            else
                return arr[mid];
            int lenleft = pivot-st+1;
            int lenright = end - (pivot+1) + 1;
            if (lenleft%2 != 0){
                end = pivot - 2;
            }
            else
                st = pivot+1;
        }
        return -1;
    }
}
