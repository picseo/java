package d0429;
import java.io.*;
import java.util.*;

public class Solution_d9_5653_줄기세포배양2 {
    static class Cell implements Comparable<Cell>{
        private int i;//i세로좌표
        private int j;//j가로좌표
        private int x;//x줄기세포의 생명력(처음입력값보관용)
        
        private int t;//활성화시간 언제 활성화가 되느냐
        
        public Cell(int i,int j,int x, int t) {
            this.i=i;
            this.j=j;
            this.x=x;
            this.t = t;
        }

		@Override
		public int compareTo(Cell o) {
			if(t!=o.t)return Integer.compare(t,  o.t);
			return -Integer.compare(x,  o.x);
		}
    }

    static int[] di={-1,1,0,0};//상,하,좌,우
    static int[] dj={0,0,-1,1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Cell> pq=new PriorityQueue<>();
        boolean[][] v = new boolean[700][700]; //-> 범위를 벗어나지 않게 된다.
        int T=Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++){
        	//초기화
            pq.clear();
            for(int i=0; i<v.length; i++){
               Arrays.fill(v[i],  false);
            }
            
            //입력
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());//세로 1<=N<=50
            int M=Integer.parseInt(st.nextToken());//가로 1<=N<=50
            int K=Integer.parseInt(st.nextToken());//배양시간 1<=K<=300
            int ans = 0;
            for(int i=350; i<350+N; i++){//배열의 중간를 계산(350,350)->(K/2,K/2)
                st=new StringTokenizer(br.readLine());
                
                for(int j=350; j<350+M; j++){
                    int X = Integer.parseInt(st.nextToken());//줄기세포생명력 1<=X<=10
                    if(X!=0){
                    	v[i][j] = true;
                        pq.offer(new Cell(i,j,X, X+1));
                        if(X*2>K) ans++;
                    }
                }
            }
            //처리
            int time = 0;
            while(time <= K) {
            	Cell c = pq.poll();
            	time = c.t;
            	if(time > K)
            		break;
            	for(int d = 0; d < 4; d++) {
            		int ni = c.i + di[d];
            		int nj = c.j + dj[d];
            		if(!v[ni][nj]) {
            			v[ni][nj] = true;
            			pq.offer(new Cell(ni, nj, c.x, time+c.x+1));
            			if(time+c.x*2>K)ans++;
            		}
            	}
            }
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.print(sb);
        br.close();
    }   
}
