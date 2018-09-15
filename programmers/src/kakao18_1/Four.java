package kakao18_1;

import java.util.HashSet;

public class Four {
	public static int solution(int[] food_times, long k) {
        int size = food_times.length;
        HashSet<Integer> count = new HashSet<>();
        int l=0;
        for(int i=0;i<k;i++) {
        	if(food_times[l%size]>0) {
        		if(food_times[l%size]==1) count.add(l%size);
        		food_times[l%size] -= 1;
        	}else {
        		k++;
        	}
        	l++;
        	if(count.size()==size) {
        		return -1;
        	}
        	        	
        }
        return (l+1)%size;
    }
	public static int solution2(int[] food_times, long k) {
		//int answer = 0;
		int size = food_times.length;
		//System.out.println(size);
		HashSet<Integer> count = new HashSet<>();
		int l=0;
		for(int i=0;i<k;i++) {
			//System.out.println("l%size : "+l%size);
			if(food_times[l%size]>0) {
				if(food_times[l%size]==1) count.add(l%size);
				food_times[l%size] -= 1;
				System.out.println("count.size():"+count.size());
			}else {
				k++;
			}
			l++;
			if(count.size()==size) {
				return -1;
			}
			
		}
		for(int j=0;j<size;j++) {
			System.out.println("food_times["+j+"]:"+food_times[j]);
		}
		// (i+1)%size
		return (l+1)%size;
	}
	public static void main(String[] args) {
		/*int[] food_times= {1,1,1};
		long k = 2;*/
		int[] food_times= {3,1,2};
		long k = 6;
		System.out.println(solution(food_times, k));
		//답 : 1
	}
}
