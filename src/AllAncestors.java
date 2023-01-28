import java.util.*;

public class AllAncestors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] edges = new int[n][2];
        for (int i = 0; i < n;i++){
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }
        getAncestors(n, edges);
    }
    static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> ansc = new HashMap<>();
        for (int[] itm : edges){
            ansc.put(itm[1], new ArrayList<>(itm[0]));
        }
        for (int i = 0; i < n; i++){
            System.out.println(ansc.get(i));
        }
        return ans;
    }
}
