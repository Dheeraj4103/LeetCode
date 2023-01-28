import java.util.ArrayList;
import java.util.List;

public class keys_and_rooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> key = new ArrayList<>();
        key.add(1);
        key.add(3);
        rooms.add(key);
        List<Integer> key1 = new ArrayList<>();
        key1.add(3);
        key1.add(0);
        key1.add(1);
        List<Integer> key2 = new ArrayList<>();
        key2.add(2);
        rooms.add(key1);
        rooms.add(key2);
        List<Integer> key3 = new ArrayList<>();
        key3.add(0);
        rooms.add(key3);

        System.out.println(canVisitAllRooms(rooms));

    }
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        GoInRoom(rooms.get(0), rooms, visited);
        for (int i = 0; i < visited.length; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
    static void GoInRoom(List<Integer> keys, List<List<Integer>> rooms, boolean[] visited){
        for (Integer key : keys){
            if (!visited[key]){
                visited[key] = true;
                GoInRoom(rooms.get(key), rooms, visited);
            }
        }
    }
}
