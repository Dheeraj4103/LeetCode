import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8};
        int[] arr2 = {2, 3, 5};
        int[] arr1 = {2, 3, 6, 7};
        System.out.println(combinationSum(arr2, 8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(list, candidates, 0, target, ans);
        return ans;
    }

    static void helper(List list, int[] cand, int i, int target, List ans){

        // if target == 0, i.e sum == target
        if (target == 0){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            ans.add(temp);
            return;
        }

        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        for (int j = i; j < cand.length; j++){
            if (target - cand[j] >= 0) {
                temp.add(cand[j]);
                helper(temp, cand, j, target - cand[j], ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
