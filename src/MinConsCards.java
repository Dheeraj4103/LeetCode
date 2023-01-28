import java.sql.Array;
import java.util.*;

public class MinConsCards {
    public static void main(String[] args) {
        int[] cards = {1,0,5,3};
        System.out.println(minimumCardPickup(cards));
    }
    public static int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;
        Map<Integer, ArrayList<Integer>> count = new HashMap<>();
        for (int i = 0; i < cards.length; i++){
            ArrayList<Integer> temp = count.getOrDefault(cards[i], new ArrayList<>());
            temp.add(i);
            count.put(cards[i], temp);
        }

        Set s = count.keySet();
        for (Object n : s){
            ArrayList<Integer> list = count.get(n);
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    int cal = (list.get(i) - list.get(i-1) + 1);
                    min = Math.min(min, cal);
                }
            }
        }
        return (min == Integer.MAX_VALUE ? -1 : min);
    }
}
