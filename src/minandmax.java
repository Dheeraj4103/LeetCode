import java.util.Arrays;

public class minandmax {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
        System.out.println(Arrays.toString(MinMax(arr, Integer.MAX_VALUE, 0, 0)));
    }

    static int[] MinMax(int[] arr, int min, int max, int idx){
        if (idx >= arr.length){
            return new int[] {min, max};
        }

        min = (arr[idx] < min ? arr[idx] : min);
        max = (arr[idx] > max ? arr[idx] : max);

        return MinMax(arr, min, max, idx+1);
    }
}
