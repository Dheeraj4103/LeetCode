import java.util.*;

public class MinRoundsCompleted {
    public static void main(String[] args) {
        int[] tasks = {2, 2,3, 2, 4, 4, 4, 4, 4};
        System.out.println(minimumRounds(tasks));
    }

    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < tasks.length; i++){
            count.put(tasks[i], count.getOrDefault(tasks[i], 0)+1);
        }

        for (int val : count.values()){
            if (val == 1){
                return -1;
            }
            ans += (val/3) + (val%3 == 0 ? 0 : 1);
        }
        return ans;
    }


}
