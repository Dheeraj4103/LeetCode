public class lake {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
//        int[] arr = {5, 4, 1, 2};
        System.out.println(WaterLake(arr));
    }
    static int WaterLake(int[] arr){
        int mx = arr[0];
        int i = 1;
        int fnl = 0, cnt = 0;
        while (i < arr.length){
            if (arr[i] < mx){

                int mx1 = 0;
                int idx = i+1;
                for (int j = i; j < arr.length; j++){
                    idx = (arr[j] >= mx1 ? j : idx);
                    mx1 = Math.max(mx1, arr[j]);
                    if (mx1 >= mx){
                        mx = mx1;
                        idx = j;
                        break;
                    }
                    cnt += (mx - arr[j]);
                }

                if (mx1 < mx){

                    for (int j = idx; j < arr.length; j++){
                        cnt -= (mx - arr[j]);
                    }
                    int mx_diff = mx - mx1;
                    cnt -= (idx-i)*mx_diff;
                    i = idx+1;
                }
                else{
                    i = idx+1;
                }
                fnl += cnt;
                cnt = 0;

            }
            else{
                mx = arr[i];
                i++;
            }

        }
        return fnl;
    }
}
