package kakao18_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Three {
	public static int solution(String[][] relation) {
        int answer = 0;
        int row=relation.length, column=relation[0].length;
        ArrayList<String> flag = new ArrayList<>();
        for(int i=0;i<column;i++) {
        	flag.add(i+"");
        }
        Set<String> temp = new HashSet<>();
        // 각 1개의 열씩 체크
           
        for(int j=0;j<column;j++) {
        	for(int i=0;i<row;i++) {
            	temp.add(relation[i][j]);
            }
            if(temp.size()==row) {
            	answer++;
            	flag.remove(j+"");
            	temp = new HashSet<>();
            }
        }
        
        ArrayList<String>flag2 = null;
        if(column>1) {
        	flag2 = new ArrayList<>();
        	for(int j=0;flag.contains(j+"");j++) {
        		for(int i=0;flag.contains(j+"")&&i<j;i++) {
        			flag2.add(i+" "+j);
        		}
        	}
        	 for(String s : flag) {
             	for(String r : flag) {
             		int a = Integer.parseInt(s);
                    int b = Integer.parseInt(r);
             		if(a<b) {
             			temp = new HashSet<>();
                     	for(int i=0;i<row;i++) {
                         	temp.add(relation[i][a]+relation[i][b]);
                         }
                         if(temp.size()==row) {
                         	answer++;
                         	flag2.remove(a+" "+b);
                         }
                         
             		}
             	}
             }
        }
        ArrayList<String>flag3 = null;
        if(column>2) {
        	flag3 = new ArrayList<>();
        	for(int k=0;flag.contains(k+"");k++) {
        		for(int j=0;flag.contains(j+"")&&j<k;j++) {
            		for(int i=0;flag.contains(j+"")&&i<j;i++) {
            			flag3.add(i+" "+j+" "+k);
            		}
            	}
        	}
        	
        	for(String s : flag2) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
    			int b = Integer.parseInt(temp2[1]);
    			for(String r : flag) {
    				int c = Integer.parseInt(r);
    				if(b<c) {
    					temp = new HashSet<>();
        				for(int i=0;i<row;i++) {
        					temp.add(relation[i][a]+relation[i][b]+relation[i][c]);
        				}
        				if(temp.size()==row) {
        					answer++;
        					flag3.remove(a+" "+b+" "+c);
        				}
    					
    				}
    			}
        	}
        }
        ArrayList<String>flag4 = null;
        if(column>3) {
        	flag4 = new ArrayList<>();
        	for(String s : flag3) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		for(String r : flag) {
        			int d = Integer.parseInt(r);
        			if(c<d) {
        				flag4.add(a+" "+b+" "+c+" "+d);
        			}
        		}
        	}
        	for(String s : flag4) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		int d = Integer.parseInt(temp2[3]);
        		temp = new HashSet<>();
				for(int i=0;i<row;i++) {
					temp.add(relation[i][a]+relation[i][b]+relation[i][c]+relation[i][d]);
				}
				if(temp.size()==row) {
					answer++;
					flag4.remove(a+" "+b+" "+c+" "+d);
				}
        	}
        	
        }
        ArrayList<String>flag5 = null;
        if(column>4) {
        	flag5 = new ArrayList<>();
        	for(String s : flag4) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		int d = Integer.parseInt(temp2[3]);
        		for(String r : flag) {
        			int e = Integer.parseInt(r);
        			if(c<d) {
        				flag5.add(a+" "+b+" "+c+" "+d+" "+e);
        			}
        		}
        	}
        	for(String s : flag4) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		int d = Integer.parseInt(temp2[3]);
        		int e = Integer.parseInt(temp2[4]);
        		temp = new HashSet<>();
        		for(int i=0;i<row;i++) {
        			temp.add(relation[i][a]+relation[i][b]+relation[i][c]+relation[i][d]+relation[i][e]);
        		}
        		if(temp.size()==row) {
        			answer++;
        			flag5.remove(a+" "+b+" "+c+" "+d+" "+e);
        		}
        	}
        }
        ArrayList<String>flag6 = null;
        if(column>5&&!flag5.isEmpty()) {
        	flag6 = new ArrayList<>();
        	for(String s : flag5) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		int d = Integer.parseInt(temp2[3]);
        		int e = Integer.parseInt(temp2[4]);
        		for(String r : flag) {
        			int f = Integer.parseInt(r);
        			if(e<f) {
        				flag6.add(a+" "+b+" "+c+" "+d+" "+e+" "+f);
        			}
        		}
        	}
        	for(String s : flag6) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		int d = Integer.parseInt(temp2[3]);
        		int e = Integer.parseInt(temp2[4]);
        		int f = Integer.parseInt(temp2[5]);
        		temp = new HashSet<>();
        		for(int i=0;i<row;i++) {
        			temp.add(relation[i][a]+relation[i][b]+relation[i][c]+relation[i][d]+relation[i][e]+relation[i][f]);
        		}
        		if(temp.size()==row) {
        			answer++;
        			flag6.remove(a+" "+b+" "+c+" "+d+" "+e+" "+f);
        		}
        	}
        }
        ArrayList<String>flag7 = null;
        if(column>6&&!flag6.isEmpty()) {
        	flag7 = new ArrayList<>();
        	for(String s : flag6) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[3]);
        		int d = Integer.parseInt(temp2[4]);
        		int e = Integer.parseInt(temp2[5]);
        		int f = Integer.parseInt(temp2[6]);
        		for(String r : flag) {
        			int g = Integer.parseInt(r);
        			if(f<g) {
        				flag7.add(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);
        			}
        		}
        	}
        	for(String s : flag7) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		int d = Integer.parseInt(temp2[3]);
        		int e = Integer.parseInt(temp2[4]);
        		int f = Integer.parseInt(temp2[5]);
        		int g = Integer.parseInt(temp2[6]);
        		temp = new HashSet<>();
        		for(int i=0;i<row;i++) {
        			temp.add(relation[i][a]+relation[i][b]+relation[i][c]+relation[i][d]+relation[i][e]+relation[i][f]+relation[i][g]);
        		}
        		if(temp.size()==row) {
        			answer++;
        			flag7.remove(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);
        		}
        	}
        }
        ArrayList<String>flag8 = null;
        if(column>7&&!flag7.isEmpty()) {
        	flag8 = new ArrayList<>();
        	for(String s : flag7) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[3]);
        		int d = Integer.parseInt(temp2[4]);
        		int e = Integer.parseInt(temp2[5]);
        		int f = Integer.parseInt(temp2[6]);
        		int g = Integer.parseInt(temp2[7]);
        		for(String r : flag) {
        			int h = Integer.parseInt(r);
        			if(g<h) {
        				flag8.add(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h);
        			}
        		}
        	}
        	for(String s : flag8) {
        		String[] temp2 = s.split(" ");
        		int a = Integer.parseInt(temp2[0]);
        		int b = Integer.parseInt(temp2[1]);
        		int c = Integer.parseInt(temp2[2]);
        		int d = Integer.parseInt(temp2[3]);
        		int e = Integer.parseInt(temp2[4]);
        		int f = Integer.parseInt(temp2[5]);
        		int g = Integer.parseInt(temp2[6]);
        		int h = Integer.parseInt(temp2[7]);
        		temp = new HashSet<>();
        		for(int i=0;i<row;i++) {
        			temp.add(relation[i][a]+relation[i][b]+relation[i][c]+relation[i][d]+relation[i][e]+relation[i][f]+relation[i][g]+relation[i][h]);
        		}
        		if(temp.size()==row) {
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[][] relation = 
		
		{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
			
		System.out.println(solution(relation));
	}
}
