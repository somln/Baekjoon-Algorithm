class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            str = String.format("%" + n + "s", str);
            str = str.replace('1', '#').replace('0', ' ');
            answer[i] = str;
        }
        
        return answer;
    }
}