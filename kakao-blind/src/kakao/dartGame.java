package kakao;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class dartGame {
	 public static int solution(String dartResult) {
	    int answer = 0;
		StringTokenizer tokens = new StringTokenizer(dartResult, "*#SDT",true);
		int[] score = new int[3];
		String numPattern = "^[0-9]*$";
		String squarePattern = "[S,D,T]";
		int i = 0;
		while(tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if(Pattern.matches(numPattern, token)) {
				score[i++]= Integer.parseInt(token);
			}else if(Pattern.matches(squarePattern, token)){
				if(!token.equals("S")) score[i-1] = (int) Math.pow(score[i-1], ((token.equals("D"))?2:3));
			}else {
				if(token.equals("*")) {
					score[i-1] *= 2;
					if(i != 1) score[i-2] *= 2;
				}else score[i-1] *= -1;
			}
		}
		for(int j=0; j<3;j++) {
			answer += score[j];
		}
	      return answer;
	  }
	
	 public static void main(String[] args) {
		String dartResult = "1S*2T*3S";
		System.out.println(solution(dartResult));
		
		
	}
}
