public class kthsymbolingrammer {
    public static void main(String[] args) {
        System.out.println(kthGrammar(2, 2));

    }

    static int kthGrammar(int n, int k) {
        int ans = helper(new StringBuilder("0"), n, k) - '0';
        return ans;
    }
    static char helper(StringBuilder s, int n, int k){
        // base condition
        // when we get final string return char at that position
        if (n == 1){
            return s.charAt(k-1);
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            buffer.append(s.charAt(i) == '0' ? "01" : "10");
        }

        return helper(buffer, n-1, k);
    }
}
