import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        
        //뱀이 없는 경우 1
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //탈출 가능 경로 있으면 1, 없으면 0

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == n-1 && cur[1] == m-1){
                System.out.println(1);
                return;
            }

            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                
                if(map[nx][ny] == 1){
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println(0);

    }
}