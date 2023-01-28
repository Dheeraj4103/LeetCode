public class Gas_Station {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int st, end;
        int n = gas.length;
        int ans = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]){
                st = i;
                end = (i) % n;
                if (traverseCircuit(gas, cost, st, end)){
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
    public static boolean traverseCircuit(int[] gas, int[] cost, int st, int end){
        int tank = 0;
        int StationCost = st;

        do {
            tank += gas[st];

            if (tank < cost[st]){
                return false;
            }
            tank -= cost[st];
            st = (st + 1) % gas.length;
        } while (st != end);
        return true;
    }
}
