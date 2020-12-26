package repeat;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 추억의2048게임 {
    public static int[][] map = new int[20][20];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int t = 1 ; t <= T; t++){
            int n = sc.nextInt();
            String dir_str = sc.next();

            for(int i = 0; i < n ; i++){
                Arrays.fill(map[i], 0);
            }

            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n ; j++){ 
                    map[i][j] = sc.nextInt();
                }
            }

            if(dir_str.equals("left")){//left

                for(int i = 0; i < n;i++){//한 줄씩 진행
                    int n_idx = 0;
                    int pre = -1;

                    for(int j = 0; j < n; j++){
                        int now = map[i][j];
                        if(now == 0){
                            continue;
                        }

                        if(now == 2048){
                            map[i][j] = 0;
                            if(pre == -1){
                                map[i][n_idx++] = 2048;
                            }else{
                                map[i][n_idx++] = pre;
                                pre = -1;
                                map[i][n_idx++] = 2048;
                            }
                            continue;
                        }

                        if(pre == -1){//시작하는 수
                            pre = now;
                            map[i][j] = 0;
                        }else{
                            if(pre == now){
                                map[i][n_idx++]=(pre+pre);
                                pre = -1;
                                map[i][j] = 0;
                            }else{
                                map[i][n_idx++] = pre;
                                pre = now;
                                map[i][j] = 0;
                            }
                        }
                    }

                    if(pre != -1){
                        map[i][n_idx++] = pre;
                        pre = -1;
                    }
                }

            } else if (dir_str.equals("right")) {//right

                for(int i = 0; i < n;i++){//한 줄씩 진행
                    int n_idx = n-1;
                    int pre = -1;

                    for(int j = n-1; j >= 0; j--){
                        int now = map[i][j];
                        if(now == 0){
                            continue;
                        }

                        if(now == 2048){
                            map[i][j] = 0;
                            if(pre == -1){
                                map[i][n_idx--] = 2048;
                            }else{
                                map[i][n_idx--] = pre;
                                pre = -1;
                                map[i][n_idx--] = 2048;
                            }
                            continue;
                        }

                        if(pre == -1){//시작하는 수
                            pre = now;
                            map[i][j] = 0;
                        }else{
                            if(pre == now){
                                map[i][n_idx--]=(pre+pre);
                                pre = -1;
                                map[i][j] = 0;
                            }else{
                                map[i][n_idx--] = pre;
                                pre = now;
                                map[i][j] = 0;
                            }
                        }
                    }

                    if(pre != -1){
                        map[i][n_idx--] = pre;
                        pre = -1;
                    }
                }

            } else if (dir_str.equals("up")) {//up

                for(int i = 0; i < n;i++){//한 열씩 진행
                    int n_idx = 0;
                    int pre = -1;

                    for(int j = 0; j < n; j++){
                        int now = map[j][i];
                        if(now == 0){
                            continue;
                        }

                        if(now == 2048){
                            map[j][i] = 0;
                            if(pre == -1){
                                map[n_idx++][i] = 2048;
                            }else{
                                map[n_idx++][i] = pre;
                                pre = -1;
                                map[n_idx++][i] = 2048;
                            }
                            continue;
                        }

                        if(pre == -1){//시작하는 수
                            pre = now;
                            map[j][i] = 0;
                        }else{
                            if(pre == now){
                                map[n_idx++][i]=(pre+pre);
                                pre = -1;
                                map[j][i] = 0;
                            }else{
                                map[n_idx++][i] = pre;
                                pre = now;
                                map[j][i] = 0;
                            }
                        }
                    }

                    if(pre != -1){
                        map[n_idx++][i] = pre;
                        pre = -1;
                    }
                }

            } else if(dir_str.equals("down")) {//down
                for(int i = n-1; i >= 0 ;i--){//한 열씩 진행
                    int n_idx = n-1;
                    int pre = -1;

                    for(int j = n-1; j >= 0 ; j--){
                        int now = map[j][i];
                        if(now == 0){
                            continue;
                        }

                        if(now == 2048){
                            map[j][i] = 0;
                            if(pre == -1){
                                map[n_idx--][i] = 2048;
                            }else{
                                map[n_idx--][i] = pre;
                                pre = -1;
                                map[n_idx--][i] = 2048;
                            }
                            continue;
                        }

                        if(pre == -1){//시작하는 수
                            pre = now;
                            map[j][i] = 0;
                        }else{
                            if(pre == now){
                                map[n_idx--][i]=(pre+pre);
                                pre = -1;
                                map[j][i] = 0;
                            }else{
                                map[n_idx--][i] = pre;
                                pre = now;
                                map[j][i] = 0;
                            }
                        }
                    }

                    if(pre != -1){
                        map[n_idx--][i] = pre;
                        pre = -1;
                    }
                }
            }

            sb.append("#").append(t).append("\n");
            for(int i = 0; i < n; i++){
                for(int j = 0; j <n ;j++){
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
