public class uppercase {
    public static void main(String[] args) {
        String s = "geekS";
        System.out.println(FirstUpperCase(s));
    }

    static char FirstUpperCase(String s){
        if (Character.isUpperCase(s.charAt(0))){
            return s.charAt(0);
        }
        return FirstUpperCase(s.substring(1));
    }
}
