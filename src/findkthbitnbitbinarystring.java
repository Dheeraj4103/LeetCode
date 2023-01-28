public class findkthbitnbitbinarystring {
    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }

    static char findKthBit(int n, int k) {
        String s = "0";
        while (n > 0){
            String invertstr = inverse(s);
            StringBuilder str = new StringBuilder(invertstr);
            str.reverse();
            String reversestr = str.toString();
            s += ("1" + reversestr);
            n--;
        }
        return s.charAt(k-1);
    }

    static String inverse(String s){
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] == '0' ? '1' : '0');
        }
        String ans = new String(arr);
        return ans;
    }


}
