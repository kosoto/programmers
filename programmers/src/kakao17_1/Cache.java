package kakao17_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Cache {
	public static int solution(int cacheSize, String[] cities) {
	      if(cacheSize == 0) return cities.length *5;
	      int answer = 0;
	        String city = "";
	        ArrayList<String> cache = new ArrayList<>();
	        for(int i=0;i<cities.length;i++){
	            city = cities[i].toLowerCase();
	            if(cache.contains(city)){
	                cache.remove(city);

	                answer += 1;
	            }else{
	                if(cache.size() == cacheSize){
	                    cache.remove(0);
	                }
	                answer += 5;
	            }
	            cache.add(city);
	        }
	        return answer;
	}
	// 테스트 통과 못 함 이유 모름..
	public static int solution_Map(int cacheSize, String[] cities) {
		if(cacheSize ==0) return cities.length*5;
		int answer = 0, count;
        String city,temp,temp2;
        Map<String,Integer> cache = new HashMap<>();
        for(int i=0;i<cities.length;i++) {
        	city = cities[i].toLowerCase();
        	 if(cache.get(city)!=null) {
             	answer +=1;
             }else{
                 if(cache.size() == cacheSize){
                     count = 0;
                     temp = "";
                     Iterator<String> it = cache.keySet().iterator();
                     temp2="";
                     while(it.hasNext()) {
                     	temp2= it.next();
                     	if (count<cache.get(temp2)){
                             count = cache.get(temp2);
                             temp = temp2;
                         }
                     }
                     cache.remove(temp);
                 }
                answer += 5;
             }
             for(String c : cache.keySet()){
                 cache.put(c,cache.get(c)+1);
             }
             cache.put(city,0);
        }
        return answer;
	}
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		Random rnd =new Random();
		for(int j=0;j<100000;j++) {
			StringBuffer buf = new StringBuffer();
			for(int i=0;i<20;i++){
				buf.append((char)((int)(rnd.nextInt(26))+97));
			}
			list.add(buf.toString());
		}
		int cacheSize = 30;
		String[] cities =  list.toArray(new String[100000]);
		for(int i=0;i<100;i++) {
			System.out.println(cities[i]);
		}
		
		System.out.println(solution(cacheSize, cities));
		
	}
}
