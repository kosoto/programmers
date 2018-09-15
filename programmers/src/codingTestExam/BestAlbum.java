package codingTestExam;

import java.util.HashMap;
import java.util.HashSet;

public class BestAlbum {
	 public static int[] solution(String[] genres, int[] plays) {
	        int[] answer = {};
	        HashSet<String> s = new HashSet<>();
	        HashMap<String,Integer> m = new HashMap<>();
	        for(int i=0;i<genres.length;i++) {
	        	if(!m.containsKey(genres[i])) {
	        		m.put(genres[i], plays[i]);
	        	}else {
	        		m.put(genres[i], m.get(genres[i])+plays[i]);
	        	}
	        	
	        }
	        
	        
	        
	        return answer;
	    }
	 public static void main(String[] args) {
		 String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		 int[] plays = {500,600,150,800,2500};
		 System.out.println(solution(genres, plays));
	}
}
