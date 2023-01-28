public class minnoofoptime {
    public static void main(String[] args) {
        convertTime("11:30", "11:31");
    }
    static int convertTime(String current, String correct) {
        int hrs1 = Integer.parseInt(current.substring(0,2));
        int hrs2 = Integer.parseInt(correct.substring(0,2));
        int mns1 = Integer.parseInt(current.substring(3,5));
        int mns2 = Integer.parseInt(correct.substring(3,5));
        int time = ((24 + (hrs2 - hrs1))%24)*60;
        time += (mns2-mns1);
        int cnt = 0;
        while (time > 0){
            if (time >= 60){
                cnt += time/60;
                time -= (time/60)*60;
            }
            else if (time >= 15){
                cnt += time/15;
                time -= (time/15)*15;
            }
            else if (time >= 5){
                cnt += time/5;
                time -= (time/5)*5;
            }
            else if (time >= 1){
                cnt += time;
                time -= time;
            }
        }
        return cnt;
    }
}
