public class scoreofparentheses {
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }
    public static int scoreOfParentheses(String s) {
        int cnt = 0;
        int ans = 0;
        for (int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == '('){
                cnt++;
                ans += (cnt > 1 ? 2 : 0);
            }
        }
        ans += (cnt == 1 ? 1 : 0);
        return ans;
    }
}

