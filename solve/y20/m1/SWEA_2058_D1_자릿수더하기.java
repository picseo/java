package algo_basic.day1;
import java.util.*;

public class SWEA_2058_D1_자릿수더하기 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		sc= new Scanner(src);
		
		int data= sc.nextInt();
		int sum=0;
		
		sum +=data/1000;
		data= data%1000;
		sum +=data/100;
		data= data%100;
		sum +=data/10;
		data= data%10;
		sum +=data/1;
	
		
		System.out.println(sum);
		
		

	}
	
	private static String src ="6789";

}
