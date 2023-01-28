import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sumofinfintearray {
    public static void main(String[] args) {
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        while (t > 0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){

                arr[i] = in.nextInt();
            }
            int q = in.nextInt();
            List<List<Long>> queries = new ArrayList<>();
            for (int i = 0; i < q; i++){
                Long x = in.nextLong();
                Long y = in.nextLong();
                List<Long> itm = new ArrayList<>();
                itm.add(x);
                itm.add(y);
                queries.add(itm);
            }
            System.out.println(sumInRanges(arr, n, queries, q));
            t--;
        }

    }
    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        // Write your code here!
        List<Integer> ans = new ArrayList<>();
        for (List<Long> itm : queries){
            int st = (int) (itm.get(0) - 1);
            int end = (int) (itm.get(1) - 1);
            int st1 = (st)%arr.length;
            int end1 = (end)%arr.length;
            int cnt = 0;
            for (int i = st1; i < arr.length; i++){
                cnt += arr[i];
            }
            st += (n-st1);
            if (st <= end){
                st1 = (st)%n;
                for (int i = st1; i <= end1; i++){
                    cnt += arr[i];
                }
                end -= ((end1-st1)+1)-1;

            }
            if ((end-st) > 0){
                int sm = 0;
                for (int i = 0; i < arr.length; i++){
                    sm += arr[i];
                }
                sm *= (end-st)%arr.length;
                cnt += sm;
            }

            ans.add(cnt);

        }
        return ans;
    }
}
