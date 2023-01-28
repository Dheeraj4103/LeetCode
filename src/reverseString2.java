public class reverseString2 {
    public static void main(String[] args) {
        String s = "abcd";
//        System.out.println(reverseStr(s, 2));
        StringBuilder tp = new StringBuilder();
        tp.append(s);
        tp.reverse();
        System.out.println(tp);

    }
    static String reverseStr(String s, int k){
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while (i < s.length()){
            int len = (s.length() - i);
            StringBuilder temp = new StringBuilder();
            if (len < k){
                for (int j = i; j < (i+len); j++){
                    temp.insert(0, s.charAt(j));
                }
            }
            else if (len >= k && len < 2*k){
                for (int j = i; j < (i + len); j++){
                    if (j < (i+k))
                        temp.insert(0, s.charAt(j));
                    else
                        temp.append(s.charAt(j));
                }
            }
            else{
                for (int j = i; j < (i+2*k); j++){
                    if (j < (i+k)){
                        temp.insert(0, s.charAt(j));
                    }
                    else{
                        temp.append(s.charAt(j));
                    }
                }
            }
            ans.append(temp);
            i += 2*k;
        }

        return String.valueOf(ans);
    }
}
