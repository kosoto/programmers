package codingTest;

import java.util.Queue;

public class firstTest {
	  public static int solution1(int n, int m) {
		  //거꾸로 해도 똑같은 숫자들의 갯수 구하는 문제
	        int answer = 0,size=0;
	        String temp,temp2;
	        for(int i=n;i<=m;i++) {
	        	temp = String.valueOf(i);
	        	temp2 = "";
	        	size = temp.length();
	        	for(int j=0;j<size;j++) {
	        		temp2 += temp.substring(size-j-1, size-j);
	        	}
	        	if(temp.equals(temp2)) answer +=1;
	        }
	        return answer;
	    }
	   
	  public static long solution2(int no, int[] works) {
		// 최소 패널티 비용 구하는 문제
		  int index, temp;
		  long result = 0;
		  boolean flag = false;
		  for(;no!=0;no--) {
			  index = 0;
			  temp=0;
			  for(int i=0;i<works.length;i++) {
				  flag = temp<works[i];
				  temp = (flag)?works[i]:temp;
				  index = (flag)?i:index;
			  }
			  works[index] -= 1;
		  }
		  for(Integer d : works) result += (Math.pow(d, 2));
		  return result;
	  } 
	 public static int[][] solution3(int n, int[][] signs){
		 //버스 정류장 문제 못품
	        int[][] answer = new int[n][n];
	        System.out.println("n : "+n);
	        for(int i=0;i<n;i++) {
	        	System.out.println(i+"회전시작");
	        	for(int j=0;j<n;j++) {
	        		System.out.println("signs["+i+"]["+j+"] : "+signs[i][j]);
	        		if(signs[i][j] == 1) {
	        			answer[i][j] = 1;
	        			for(int k=0;k<n;k++) {
	        				if(signs[j][k]==1) answer[i][k] = 1;
	        			}
	        		}
	        	}
	        	System.out.println(i+"회전끝");
	        }
	        return answer;
	    }
	
	public static void main(String[] args) {
	/*	int n = 3;
		int[][] signs = {{0,0,1},{0,0,1},{0,1,0}};
		int[][] signs2 = {{0,1,0},{0,0,1},{1,0,0}};
		int[][] res = solution3(n, signs2);
		//int[][] res = signs;
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				System.out.print(res[j][i]+" ");
			}
			System.out.println();
		}*/
		int no = 1000000;
		int[] works = new int[no];
		for(int i=0;i<no;i++) {
			works[i] = (int)(Math.random()*1001);
		}
		System.out.println("세팅 끝");
		/*int no = 4;
		int[] works = {4,3,3};*/
		System.out.println(solution2(no, works));
		
		
		
	}
}
