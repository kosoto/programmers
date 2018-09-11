package kakao17_1;

import java.util.ArrayList;

public class Friends4Block {
	public static int solution(int m, int n, String[] board) {
		  int answer = 0, n1,n2;
		  String res;
		  ArrayList<String> checkRow;
		  ArrayList<int[]> checkBox;
	   	  // 행렬로 저장
	   	  char[][] boardMtx = new char[m][n];
		      for(int i=0;i<m;i++) 
		    	  for(int j=0;j<n;j++) 
		    		  boardMtx[i][j] = board[i].charAt(j);
	      while(true) {
		      //한 행에서 연속된 문자 판별
		      checkRow = new ArrayList<>();
		      for(int i=0;i<m;i++) 
		    	  for(int j=0;j<n-1;j++) 
			    	  if(boardMtx[i][j] != 0
			    			  && boardMtx[i][j] == boardMtx[i][j+1]) 
			    		  checkRow.add(i+":"+j);
		      // 2x2 판별
		      checkBox = new ArrayList<>();
		      for(String s : checkRow) {
		    	  String[] b = s.split(":");
		    	  n1 = Integer.parseInt(b[0]);
		    	  n2 = Integer.parseInt(b[1]);
		    	  if(checkRow.contains((n1+1)+":"+b[1])
		    			  &&boardMtx[n1][n2]==boardMtx[n1+1][n2]) {
		    		  int[] i = {n1,n2};
		    		  checkBox.add(i);
		    	  }
		      }
		      // 삭제할게 없으면 삭제된 블록수 리턴
		      if(checkBox.size()==0) {
		    	  for(int i=0;i<m;i++) 
		    		  for(int j=0;j<n;j++) 
		    			  if(boardMtx[i][j]==0) 
		    				  answer+=1;
		    	  return answer;
		      }
		      // 블록 삭제
		      for(int[] d : checkBox) {
		    	  boardMtx[d[0]][d[1]] = 0;
		    	  boardMtx[d[0]][d[1]+1] = 0;
		    	  boardMtx[d[0]+1][d[1]] = 0;
		    	  boardMtx[d[0]+1][d[1]+1] = 0;
		      }
		      // 블록 내리기
		      for(int j=n-1;j>=0;j--) {
		    	  res = "";
		    	  for(int i=m-1;i>=0;i--) 
		    		  if(boardMtx[i][j]!=0) 
		    			  res += String.valueOf(boardMtx[i][j]);
		    	  for(int i=m-1,k=0;i>=0;i--,k++) 
		    		  boardMtx[i][j] = (k<res.length())?res.charAt(k):0;
		      }
	      }
	  }
	
	public static void main(String[] args) {
		int[] m = {4,6}; //행
		int[] n = {5,6}; //열
		String[] board1= {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] board2= {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		ArrayList<String[]> boards = new ArrayList<>();
		boards.add(board1);
		boards.add(board2);
		for(int i=0;i<m.length;i++) {
			System.out.println("테스트 "+(i+1)+" : "+solution(m[i], n[i], boards.get(i)));
			
		}
		
}
}
