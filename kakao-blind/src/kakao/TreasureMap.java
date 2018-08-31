package kakao;

public class TreasureMap {
	  public static String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
			 for(int i=0;i<n;i++){
				 answer[i] = "";
				 int temp = (arr1[i] | arr2[i]);
				 for(int j=0;j<n;j++) {
					 answer[i] = ((temp % 2 ==0)?" ":"#")+answer[i];
					 temp = temp / 2;
				 }				
			 }
			 return answer;
	  }
	  public static void main(String[] args) {
		  int n = 5;
		  int[] arr1 = {9, 20, 28, 18, 11};
		  int[] arr2 = {30, 1, 21, 17, 28};
		  String[] res = solution(n,arr1,arr2);
		  for(int i=0;i<n;i++) {
			  System.out.println(res[i]);
		  }
	}
}
