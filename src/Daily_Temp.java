import java.util.ArrayList;
import java.util.Arrays;

public class Daily_Temp {
    public static void main(String[] args) {
        int[] temperatures = {30,60,90};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++){
            for (int j = i+1; j < temperatures.length; j++){
                if (temperatures[j] > temperatures[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
