
import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] arr1 = {2,5,2,1,2};
//        System.out.println(combinationSum2(arr, 27));
//        Set<List<Integer>> hash = new HashSet<>();

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> ans_set = new HashSet<>();
        helper(list, candidates, 0, target, ans_set);
        ans = ans_set.stream().toList();
        return ans;
    }

    static void helper(List list, int[] cand, int i, int target, Set ans){

        // if target == 0, i.e sum == target
        if (i >= cand.length){
            return;
        }

        if (target == 0){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            Collections.sort(temp);
            ans.add(temp);
            return;
        }

        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        for (int j = i; j < cand.length; j++){
            if (target - cand[j] >= 0) {
                temp.add(cand[j]);
                helper(temp, cand, j+1, target - cand[j], ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
