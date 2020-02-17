package swea.d0211;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class SWEA_1225_D3_암호생성기 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            Queue<Integer> queue = new LinkedList();
            int minus = 1;
            int st = 0;
            int len = 8;
             
            for(int i = 0; i < len ; i++) {
                int tmp = sc.nextInt();
                queue.add(tmp);
            }
             
            while(true) {
                minus = minus%6;
                if(minus == 0) minus++;
                 
                int tmp = queue.poll() - (minus++);
                 
                if(tmp <= 0) {
                    tmp = 0;
                    queue.add(tmp);
                    break;
                }
 
                queue.add(tmp);
            }
            System.out.print("#"+n+" ");
            while(!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
             
        }//test_case
    }
}