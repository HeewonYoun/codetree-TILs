import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //3*3 크기 격자
        
        int max = 0;

        for(int r = 0; r<N-2; r++){
            for(int c = 0; c<N-2; c++){
                int count = 0;
                for(int j = 0; j<3; j++){
                    for(int k = 0; k < 3; k++){
                        count += map[r+j][c+k];        
                    }
                }

                if(count > max) max = count;
            }
        }
        System.out.println(max);
    }
}