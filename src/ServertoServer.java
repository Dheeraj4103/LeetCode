import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class ServertoServer {
    public static void main(String[] args) {
        Dictionary<List<Integer>, Integer> dict = new Hashtable<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        dict.put(list, 3);
        System.out.println(list);
        System.out.println(dict);
        System.out.println(dict.get(list));

    }
}
