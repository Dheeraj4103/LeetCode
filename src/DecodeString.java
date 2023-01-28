
import java.util.Arrays;
import java.util.Stack;

public class DecodeString {
    static int i = 0;

    public static void main(String[] args) {
//        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s = "2[abc]3[cd]ef";
        String prev = "";
        Stack<Integer> n = new Stack<>();
        String[] ot = Decode(prev, s, n);
        System.out.println(Arrays.toString(ot));
    }

    static String[] Decode(String s, String prev, Stack<Integer> n){
        // first check if string is empty or ']' is present as first char
        if (prev.isEmpty() || prev.charAt(0) == ']'){
            // if stack is not empty pop the top element
            int dig = (n.isEmpty() ? 0 : n.pop());
            // multiply string dig times
            String temp = s;
            for (int i = 1; i < dig; i++){
                s += temp;
            }
            // return final string
            prev = (prev.isEmpty() ? "" : prev.substring(1));
            String[] strings = {s, prev};
            return strings;
        }

        char itm = prev.charAt(0);
        // if char is digit
        if (Character.isDigit(itm)){
            String num = ""+itm;
            int i = 1;
            // get the digit
            while (Character.isDigit(prev.charAt(i))){
                num += prev.charAt(i);
                i++;
            }
            int digits = Integer.parseInt(num);
            // push digit into the stack
            n.push(digits);
            return Decode(s, prev.substring(i), n);
        }
        // if char is '[' that means we need to make a new function call
        else if (itm == '['){
            // again call Decode this time give s as empty string
            String[] strings = Decode("", prev.substring(1), n);
            // update s
            s += strings[0];
            return Decode(s, strings[1], n);
        }
        // if it's a alphabet add it to s
        else{
            return Decode(s + itm, prev.substring(1), n);
        }
    }
}
