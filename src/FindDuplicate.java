import java.util.ArrayList;
import java.util.Scanner;

public class FindDuplicate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int t = in.nextInt();
       while (t > 0) {
           ArrayList<Integer> l = new ArrayList<>();
           int n = in.nextInt();
           for (int i = 0; i < n; i++) {
               int x = in.nextInt();
               l.add(x);
           }
           System.out.println(findDuplicate(l, n));
           t--;
       }

    }
    static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        int i = 0;
        while (i < arr.size()){
            int correct = arr.get(i)-1;
            if (arr.get(correct) != arr.get(i)){
                swap(arr, i, correct);
            }
            else{
                if (i < arr.size() && i+1 != arr.get(i)){
                    return arr.get(i);
                }
                i++;
            }
        }

        return arr.size();
    }
    static void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
