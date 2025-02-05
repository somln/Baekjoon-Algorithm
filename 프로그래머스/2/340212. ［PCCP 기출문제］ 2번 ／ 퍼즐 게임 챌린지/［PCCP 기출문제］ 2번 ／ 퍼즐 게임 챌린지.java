class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int lf =1, rt = 100000, ans = 100000;

        while(lf<=rt){
            int mid = lf + (rt - lf)/2;
            if(canSolve(mid, diffs, times, limit)){
                ans = mid;
                rt = mid -1;
            }else{
                lf = mid +1;
            }
        }

        return ans;
    
    }
    
    public boolean canSolve(int level, int[] diffs, int[] times, long limit){
        int pre = times[0];
        long sum = 0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i]<=level){
                sum +=times[i];
            }
            else{
                sum += (diffs[i]-level) * (pre + times[i]) + times[i];
            }            
            if(sum>limit){
                return false;
            }
             pre = times[i];
         }
        return true;
    }
}