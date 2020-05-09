package d0419;

import java.util.Scanner;


public class BJ_13458_시험감독 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int[] A = new int[N];
   
    for (int i = 0; i < N; i++){
      A[i] = sc.nextInt();
    }
    
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    long res = 0;
    for (int i = 0; i < N; i++){
      double a = (double)(A[i] - b);
      res++;
      if(a > 0.0){
        res += Math.ceil((a / c));
      }
    }
    
    System.out.println(res);
  }
}
