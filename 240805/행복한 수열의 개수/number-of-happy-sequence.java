import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //n*n 격자
        int m = Integer.parseInt(st.nextToken()); //연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열

        int[][] map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        for(int i = 0; i<n; i++){
            int count = 1;
            int tmp = 0;

            for(int k = 0; k<n; k++){
                //행
                if(count >= m){
                    sum++;
                    break;
                }
                if(map[i][k] == tmp){
                    count++;
                    if(count >= m){
                        sum++;
                        break;
                }
                    
                }else {
                    tmp = map[i][k];
                }
            }

            count = 1;
            tmp = 0;

            for(int k = 0; k<n; k++){
                //열
                if(count >= m){
                    sum++;
                    break;
                }
                if(map[k][i] == tmp){
                    count++;
                    if(count >= m){
                        sum++;
                        break;
                }
                    
                } else {
                    tmp = map[k][i];
                }
            }
        }

        System.out.println(sum);
    }
}