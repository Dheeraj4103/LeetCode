import java.util.*;

public class PallindromePartitioning {
    public static void main(String[] args) {
        Partition("","aabbaa");
    }

    static List<List<String>> partition(String s) {
        return null;
    }

    static void Partition (String p, String up){
        Map<String, Boolean> ans = new HashMap<>();
        if (up.length() == 0){
//            System.out.println(p);
            return;
        }
        char itm  = up.charAt(0);
        ans.put(p, ans.getOrDefault(p, isPallindrome(p)));
        ans.put(p + itm, ans.getOrDefault(p+itm, isPallindrome(p+itm)));
        ans.put(up, ans.getOrDefault(up, isPallindrome(up)));

        up.substring(1);
        Partition(p + itm, up);
        Partition(p, up);
    }

    static boolean isPallindrome(String str){
        if (str.length() == 0){
            return true;
        }
        int i = 0;
        int j = str.length()-1;

        while (i <= j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
