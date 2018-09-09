package kakao;

import java.math.BigDecimal;

public class traffic {
	//정확성 90.9/100
	 public static int solution(String[] lines) {
		 int answer = 1;
		 double[][] table = new double[lines.length][2];
		 for(int i=0;i<lines.length;i++) {
			 String times = lines[i].split(" ")[1];
			 table[i][1] = new BigDecimal(String.valueOf(Integer.parseInt(times.split(":")[0])*3600+Integer.parseInt(times.split(":")[1])*60)).add(new BigDecimal(times.split(":")[2])).doubleValue();
			 table[i][0] = new BigDecimal(String.valueOf(table[i][1])).subtract(new BigDecimal(String.valueOf((Double.parseDouble(lines[i].split(":")[2].split(" ")[1].split("s")[0]))))).add(new BigDecimal("0.001")).doubleValue();
		 } 
		 
		 int count;
		 for(int i=0;i<lines.length;i++) {
			 count = 1;
			 for(int j=i+1;j<lines.length;j++) {
				 if(table[j][0]<(new BigDecimal(String.valueOf(table[i][1])).add(new BigDecimal("1.0")).doubleValue())) 
					 count++;
				 else 
					 break;
				  
				 answer = (answer>count)?answer:count;
			 }
		 }
		 return answer;
	  }	
	 public static int solution2(String[] lines) {
		 int answer = 1;
		 double[][] table = new double[lines.length][2];
		 //시작 시간 구하기 완료
		 for(int i=0;i<lines.length;i++) {
			 String times = lines[i].split(" ")[1];
			 String hour = times.split(":")[0];
			 String min = times.split(":")[1];
			 String sec = times.split(":")[2];
			 //시, 분을 계산한 초
			 String[] temp = lines[i].split(":")[2].split(" ");
			 double endTime = new BigDecimal(String.valueOf(Integer.parseInt(hour)*3600+Integer.parseInt(min)*60)).add(new BigDecimal(sec)).doubleValue();
			 double time = Double.parseDouble(temp[1].split("s")[0]);
			 System.out.println("time : "+time);
			 double startTime = new BigDecimal(String.valueOf(endTime)).subtract(new BigDecimal(String.valueOf(time))).add(new BigDecimal("0.001")).doubleValue();
			 System.out.println("endTime : "+endTime);
			 System.out.println("startTime : "+startTime);
			 table[i][0] = startTime;
			 table[i][1] = endTime;
			 System.out.println();
			 
		 } 
		 
		 int count;
		 for(int i=0;i<lines.length;i++) {
			 count = 1;
			 for(int j=i+1;j<lines.length;j++) {
				 System.out.println("table["+j+"][0] : "+table[j][0]);
				 System.out.println("table["+i+"][1] : "+table[i][1]);
				 System.out.println("table["+i+"][1]+1f : "+(new BigDecimal(String.valueOf(table[i][1])).add(new BigDecimal("1.0")).doubleValue()));
				 System.out.println("table["+j+"][0]<table["+i+"][1]+1f :"+(table[j][0]<(new BigDecimal(String.valueOf(table[i][1])).add(new BigDecimal("1.0")).doubleValue())));
				 if(table[j][0]<=(new BigDecimal(String.valueOf(table[i][1])).add(new BigDecimal("0.999")).doubleValue())) {
					 count++;
					 System.out.println("안  count : "+count);
				 }else {
					 break;
				 } 
				 System.out.println("count : "+count);
				 System.out.println("answer : "+answer);
				 answer = (answer>count)?answer:count;
			 }
		 }
		 
		 return answer;
	 }
	 public static void main(String[] args) {
		 //String[] lines = {"2016-09-15 03:10:33.020 0.011s"};
		 //String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		// String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		 String[] lines = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
		 System.out.println("결과 : "+solution(lines));
	}
}

















