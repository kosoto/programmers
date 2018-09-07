package kakao;

import java.util.ArrayList;
import java.util.Collections;

public class ShuttleBus {
	public static String solution(int n, int t, int m, String[] timetable) {
	        ArrayList<Integer> list = new ArrayList<>();
	        // 시간표를 숫자로 저장하기
	        for(String s : timetable){
	            list.add(Integer.parseInt(s.split(":")[0])*60+
	                    Integer.parseInt(s.split(":")[1]));
	        }

	        // 오름차순으로 정렬하기
	        Collections.sort(list);	        
	        
	        int busTime = 540;
	        for(int i=0;i<n-1;i++){ //셔틀 운행 횟수 -1
	            for(int j=0,k=0;k<m;){
	                if(list.get(j)<=busTime){
	                    list.remove(j);
	                    k++;
	                }else break;	                
	            }
	           busTime += t;
	        }
	        int temp = -1;
	        int i=0;
	        for(i=0;i<m&&i<list.size();i++){
	               if(list.get(i)>busTime){
	                   temp = i;
	                   break;
	               }
	        }
	        
	        int res = busTime;
	        if(temp==-1&&i==m) res = list.get(i-1)-1;
	        else if(temp>0) res = list.get(temp+1)-1;	        
	        return String.format("%02d:%02d",res/60,res%60);
	      
	  }
	public static void main(String[] args) {
		int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
		String res = solution(n, t, m, timetable);
		System.out.println("결과 : "+res);
		
	}
}
