package kakao18_1;

import java.util.HashMap;

public class Two {
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int count = 0 ;
        HashMap<Integer, Integer> s = new HashMap<>();
        for(Integer d : stages) {
        	if(s.get(d)==null) {
        		s.put(d, 1);
        	}else {
        		s.put(d, s.get(d)+1);
        	}
        	count++;
        }
        HashMap<Integer, Double> f = new HashMap<>();
        for(int i=1;i<=N;i++) {
        	if(s.get(i)!=null) {
        		f.put(i, (s.get(i)/((double)count)));
        		count -= s.get(i);
        	}else {
        		f.put(i,0.0);
        	}
        	
        }
        double temp2 = 0.0;
        int cnt;
        for(int i=1;i<=N;i++) {
        	temp2 = f.get(i);
        	cnt=0;
        	for(int j=1;j<N+1;j++) {
        		if(i!=j) {
                	if(temp2<f.get(j)||(temp2==f.get(j)&&i>j)) cnt++;
        		}
        		
            }
        	answer[cnt] = i;
        }
        return answer;
    }
	public static int[] solution2(int N, int[] stages) {
		int[] answer = new int[N];
		int count = 0 ;//전체 사용자
		//각 스테이지별 멈춰진 사용자수
		HashMap<Integer, Integer> s = new HashMap<>();
		for(Integer d : stages) {
			if(s.get(d)==null) {
				s.put(d, 1);
			}else {
				s.put(d, s.get(d)+1);
			}
			count++;
		}
		/* System.out.println("count : "+count);
        for(int i=1;i<=N+1;i++) {
        	System.out.println("맵 "+i+" "+s.get(i));
        }*/
		//실패율 구하기
		HashMap<Integer, Double> f = new HashMap<>();
		for(int i=1;i<=N;i++) {
			if(s.get(i)!=null) {
				f.put(i, (s.get(i)/((double)count)));
				//System.out.println("실패율 "+i+" "+s.get(i)/((double)count));
				count -= s.get(i);
			}else {
				f.put(i,0.0);
				//System.out.println("실패율 "+i+" 0.0");
			}
			
			//System.out.println("분모 : "+count);
		}
		//여기까지 완료
		
		//정렬
		double temp2 = 0.0;
		int cnt;
		for(int i=1;i<=N;i++) {
			temp2 = f.get(i);
			System.out.println("temp2 :"+temp2);
			cnt=0;
			//j<=N&&i!=j
			for(int j=1;j<N+1;j++) {
				if(i!=j) {
					if(temp2<f.get(j)||(temp2==f.get(j)&&i>j)) cnt++;
				}
				
			}
			answer[cnt] = i;
		}
		
		
		return answer;
	}
	public static void main(String[] args) {
		int N=5;
		int[] stages= {	2, 1, 2, 6, 2, 4, 3, 3};
		int[] res = solution(N, stages);
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
			
		}
		// 3,4,2,1,5
	}
}
