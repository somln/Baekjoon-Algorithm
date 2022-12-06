public class Main {
	
	private static int d(int n) {
		int sum=0;
		int num=n;
		int result;
		  while(n!=0){
	            sum += n%10;
	            n /= 10;
	        }
		 result = num+sum;
		 return result;
	}
	
	public static void main(String[] args) {

		int[] selfNum = new int[10001];
		for(int i=0; i<10000; i++) {
			if(d(i)<10001) {
			selfNum[d(i)]=1;
			}
		}
		
		for(int i=0; i<10001; i++) {
			if(selfNum[i]!=1) {
				System.out.println(i);
			}
		}
		
     }
}