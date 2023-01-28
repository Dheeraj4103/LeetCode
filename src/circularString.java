public class circularString {
    public static void main(String[] args) {
        String sentence = "leetcode exercise sound delightful";
        System.out.println(isCircularSentence(sentence));
    }

    public static boolean isCircularSentence(String sentence) {
        char prev = sentence.charAt(0);

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' '){
                prev = sentence.charAt(i-1);
                if (sentence.charAt(i+1) != prev){
                    return false;
                }
            }

        }
        if (sentence.charAt(0) != sentence.charAt(sentence.length()-1)){
            return false;
        }
        return true;
    }
}
