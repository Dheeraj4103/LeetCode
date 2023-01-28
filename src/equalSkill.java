import java.util.ArrayList;
import java.util.Arrays;

public class equalSkill {
    public static void main(String[] args) {
        int[] skill = {3,2,5,1,3,4};
        System.out.println(dividePlayers(skill));
    }
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < skill.length; i++) {
            sum += skill[i];
            temp.add(skill[i]);
        }

        long target = (long)(((double)sum/(double)skill.length) * 2);
        long count = 0;
        long chem = 0;
        int st = 0;
        int end = skill.length-1;
        int[] arr = temp.stream().mapToInt(i -> i).toArray();
        while (st < end){
            int result = BinarySearch(arr, st, end, target-arr[st]);
            if (result != -1){
                count ++;
                chem += (skill[st] * skill[result]);
                temp.remove(st);
                temp.remove(result-1);
                end = temp.size() - 1;
                arr = temp.stream().mapToInt(i -> i).toArray();
            }
            else{
                break;
            }

        }
        if (count != (skill.length / 2)){
            return -1;
        }
        return chem;

    }

    public static int BinarySearch(int[] skill, int st, int end, long target){

        while (st <= end){
            int mid = st + (end-st)/2;
            if (skill[mid] == target){
                return mid;
            }
            else if (skill[mid] > target){
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
        return -1;
    }
}
