import java.util.HashSet;
import java.util.Set;

public class Count_Pairs_of_similar_strings {
    public static void main(String[] args) {
        String[] words = {"nba","cba","dba"};
        System.out.println(similarPairs(words));
    }
    static int similarPairs(String[] words) {

        int count = 0;
        for (int i = 0; i < words.length; i++){
            Set<Character> set = FindSet(words[i]);
            for (int j = i+1; j < words.length; j++){
                if (set.equals(FindSet(words[j]))){
                    count++;
                }
            }
        }
        return count;
    }
    static Set<Character> FindSet(String word){
        Set<Character> ans = new HashSet<>();
        for (int i = 0; i < word.length(); i++){
            ans.add(word.charAt(i));
        }
        return ans;
    }
}
