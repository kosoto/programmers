package kakao17_1;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class NewsClustering {
	public static int solution(String str1, String str2) {
		// 다중집합 만들기
		ArrayList<String> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		if(str1.length()==1) 
			arr1.add(str1);
		else 
			for(int i=0;i<str1.length()-1;i++) 
				arr1.add(str1.substring(i, i+2).toLowerCase());
		
		if(str2.length()==1) 
			arr2.add(str2);
		else 
			for(int i=0;i<str2.length()-1;i++) 
				arr2.add(str2.substring(i, i+2).toLowerCase());
		
		// 영문자만 남기기
		String patturn ="^[a-zA-Z]*$";
		for(int i=0;i<arr1.size();i++) 
			if(!Pattern.matches(patturn, arr1.get(i))) 
				arr1.remove(i--);
		
		for(int i=0;i<arr2.size();i++) 
			if(!Pattern.matches(patturn, arr2.get(i))) 
				arr2.remove(i--);
		
		//교집합
		int intersection = 0;
		for(int i=0;i<arr2.size();i++) 
			if(arr1.contains(arr2.get(i))) {
				arr1.remove(arr2.get(i));
				intersection += 1;
			}
		
		//합집합
		int union = arr1.size() + arr2.size();
		return (int)(((union==0)?1:(intersection/(double)union))*65536);
	}
	public static void main(String[] args) {
		//테스트 
		String[] s1 = {"FRANCE","handshake","aa1+aa2","E=M*C^2"};
		String[] s2 = {"french","shake hands","AAAA12","e=m*c^2"};
		for(int i=0; i<s1.length;i++) {
			System.out.println("테스트 "+(i+1)+" "+solution(s1[i], s2[i]));
			System.out.println();
		}
	}
}
