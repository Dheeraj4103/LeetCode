import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinAbsDif {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(-59);
        arr.add(-36);
        arr.add(-13);
        arr.add(1);
        arr.add(-53);
        arr.add(-92);
        arr.add(-2);
        arr.add(-96);
        arr.add(-54);
        arr.add(75);
        System.out.println(minimumAbsoluteDifference(arr));
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++){
            if (Math.abs(arr.get(i) - arr.get(i+1)) < min){
                min = Math.abs(arr.get(i) - arr.get(i+1));
            }
        }

        return min;

    }
}
