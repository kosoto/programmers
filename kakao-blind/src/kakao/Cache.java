package kakao;

import java.util.ArrayList;
import java.util.List;

public class Cache {
	public static int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      List<String> cache = new ArrayList<>();
	      List<Integer> count = new ArrayList<>();
	      String city = "";
	      /*for(int i=0;i<cacheSize;i++) {
	    	 count.add(i, 0);
	      }*/
	      
	      for(String s : cities) {
	    	  city = s.toLowerCase();
	    	  System.out.println("city : "+city);
	    	  if(cache.contains(city.toLowerCase())) {
	    		  answer += 1;
	    	  }else {
	    		  if(cache.size()==cacheSize) {
	    			  cache.remove(count.indexOf(new Integer(cacheSize-1)));
	    			  count.add(count.indexOf(cacheSize), new Integer(1));
	    			  System.out.println(count.get(count.indexOf(cacheSize)));
	    		  }
    			  cache.add(city.toLowerCase());
    			  count.add(cache.indexOf(city), 0);
    			  System.out.println(count.size());
    			  int size = count.size();
    			  for(int i=0;i<size;i++) {
    				  count.add(i, count.get(i)+1);
    			  }
    			  answer += 5;
	    	  }
	    	  for(Integer d : count) {
	    		  System.out.println(d);
	    	  }
	      }
	      return answer;
	  }
	public static void main(String[] args) {
		//int cacheSize = 3;
		//String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		
		//int cacheSize = 3;
		//String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		
		int cacheSize = 5;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		
		System.out.println(solution(cacheSize, cities));
	}
}
