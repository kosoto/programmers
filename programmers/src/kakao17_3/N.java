package kakao17_3;

public class N {
	public static String solution(int n, int t, int m, int p) {
		    String answer = "";
	        String num,numList="0";
	        for(int i=0;t!=0;i++){
	            num="";
	            int j=i;
	            while (j>0){
	                int quotion = j/n;
	                int remainder = j%n;
	                j = quotion;
	                num = intToString(remainder) + num;
	            }
	            numList += num;
	            if(numList.length()>m) {
	            	answer += numList.charAt(p-1);
	            	numList = numList.substring(m);
	            	t--;
	            }
	        }
	        return answer;
	  }
	public static String intToString(int d) {
		String res = "";
		switch(d) {
		case 10 : res = "A"; break;
		case 11 : res = "B"; break;
		case 12 : res = "C"; break;
		case 13 : res = "D"; break;
		case 14 : res = "E"; break;
		case 15 : res = "F"; break;
		default : res = String.valueOf(d); break;
		}
		return res;
	}
	public static void main(String[] args) {
		int n=16;
		int t=16;
		int m=2;
		int p=1;
		
		System.out.println("답 : "+solution(n, t, m, p));
		//System.out.println(parseString(10));
		
	}
}
