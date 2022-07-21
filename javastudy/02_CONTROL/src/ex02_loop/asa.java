package ex02_loop;

public class asa {
public static void main(String[] args) {
	int begin = 100;
	int end = 1;
	
	
	 if(begin > end) { 
		  int temp; 
		  temp = begin; 
		  begin = end; 
		  end = temp; 
		  } 
	 int result = 0;
	  for(int n = begin; n<=end; n++) { 
		  	result += n;  
		  }
	  System.out.println("begin" + begin); 
	  System.out.println("end" + end);
	  System.out.println("result" + result);
	 
}
}
