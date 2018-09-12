package codingTestExam;

public class PhoneBook {
	 public static boolean solution(String[] phoneBook) {
        boolean answer = true;
        int length;
        for(String s : phoneBook) {
        	length = s.length();
        	for(String r : phoneBook) {
        		if(r.length()>length&&r.substring(0, length).equals(s)) {
        			return false;
        		}
        	}
        }
        return answer;
    }
	 public static void main(String[] args) {
		 String[] phoneBook = {"113", "12340", "123440", "12345", "98346"};
		 System.out.println(solution(phoneBook));
	}
}
