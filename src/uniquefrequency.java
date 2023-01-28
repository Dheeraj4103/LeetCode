import java.util.*;

public class uniquefrequency {
    public static void main(String[] args) {
        System.out.println(minDeletions("bbcebab"));
    }
    static int minDeletions(String s) {
        Map<String, Integer> ans = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            String str = ""+s.charAt(i);
            int val = ans.getOrDefault(str, 0) + 1;
            ans.put(str, val);
        }
        int[] values = new int[ans.size()];
        int i = 0;
        for (String c : ans.keySet()){
            values[i] = ans.get(c);
            i++;
        }
        Arrays.sort(values);
        int orisum = values[ans.size()-1];
        int freqsum = values[ans.size()-1];
        for (i = ans.size()-2; i >=0; i--){
            orisum += values[i];
            if (values[i] >= values[i+1]){
                values[i] = values[i+1]-1;
            }
            freqsum += (values[i] >= 0 ? values[i] : 0);
        }

        return orisum-freqsum;
    }
}
