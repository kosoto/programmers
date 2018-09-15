package kakao18_1;

import java.util.HashMap;

public class One {
	public static String[] solution(String[] record) {
       
        HashMap<String, String> p = new HashMap<>();
        String[] temp = new String[3];
        int count = 0;
        for(String s : record) {
        	temp = s.split(" ");
        	if(!temp[0].equals("Leave")) {
        		p.put(temp[1], temp[2]);
        	}
        	if(!temp[0].equals("Change")) {
        		count++;
        	}
        }
        String[] answer = new String[count];
        count=0;
        for(String s : record) {
        	temp = s.split(" ");
        	switch(temp[0]) {
        	case "Enter":
        		answer[count++] = p.get(temp[1])+"님이 들어왔습니다.";
        		break;
        	case "Leave":
        		answer[count++] = p.get(temp[1])+"님이 나갔습니다.";
        		break;
        	default : break;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		String[] record = 
			{"Enter uid1234 Muzi", "Enter uid4567 Prodo",
			"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		//Prodo님이 들어왔습니다., Ryan님이 들어왔습니다., 
		//Prodo님이 나갔습니다., Prodo님이 들어왔습니다.
		String[] a = solution(record);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
	}

}
