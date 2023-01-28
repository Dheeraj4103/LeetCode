public class MinimumDistance {
    public static void main(String[] args) {
        System.out.println(solve("x...x.o...x"));
    }
    static int solve(String A) {
        int cnt = 1;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while (A.charAt(i) == '.'){
            i++;
        }
        char curr = A.charAt(i);
        for (int j = i+1; j < A.length(); j++){
            if (A.charAt(j) != '.'){

                if (curr != A.charAt(j))
                    min = (cnt < min ? cnt : min);
                curr = A.charAt(j);
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        if (min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}
