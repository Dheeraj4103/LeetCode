import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    public static void main(String[] args) {
        int[][] points = {{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};

        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        Map<Double, Integer> count = new HashMap<>();
        Map<Double, ArrayList<Boolean>> visited = new HashMap<>();

        ArrayList<Boolean> temp = new ArrayList<>(points.length);
        for (int i = 0; i < points.length; i++){
            temp.add(false);
        }

        for (int i = 0; i < points.length; i++){
            for (int j = i+1; j < points.length; j++){
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                double m = (double)y / (double)x;
                if (m == -0.0){
                    m = 0.0;
                }
                if (!visited.getOrDefault(m, temp).get(j)){
                    count.put(m, count.getOrDefault(m, 0) + 1);
                    ArrayList<Boolean> updateVisited = new ArrayList<>();
                    updateVisited.addAll(visited.getOrDefault(m, temp));
                    updateVisited.set(j, true);
                    visited.put(m, updateVisited);

                }
            }
        }
        int max = 1;
        for (int value : count.values()){
            if (value + 1 > max){
                max = value + 1;
            }
        }
        return max;
    }
}
