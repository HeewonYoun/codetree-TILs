import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static ArrayList<int[]> isFilled = new ArrayList<>(); //색칠여부
    static ArrayList<Integer> list;
    static boolean[][] isVisited;

    static int max = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for(int i = 0; i<M; i++){ // 각 칸에 쓰여진 숫자
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<M; i++){ // 색칠 여부
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    isFilled.add(new int[]{i,j});
                }
            }
        }

        for(int i = 0; i<isFilled.size(); i++){
            for(int j = 0; j<isFilled.size();j++){
                if(i == j) continue;
                min = Integer.MAX_VALUE;
                int[] start = isFilled.get(i);
                int[] end = isFilled.get(j);
                isVisited = new boolean[M][N];
                list = new ArrayList<>(); //경로 저장할 리스트

                isVisited[start[0]][start[1]] = true;
                list.add(map[start[0]][start[1]]);
                check(start[0], start[1], end[0], end[1], map[start[0]][start[1]]);

            }
        }

        System.out.println(max);

    }

    static void check(int cx, int cy, int ex, int ey, int sum){
        if(cx == ex && cy == ey){
            if(sum < min){
                //max 계산
                int maxD = Math.abs(list.get(0) - list.get(1));

                for(int i = 1; i<list.size(); i++){
                    int D = Math.abs(list.get(i-1) - list.get(i));
                    if(maxD < D) maxD = D;
                }
                min = sum;

                if(max > maxD) max = maxD;
            }
            return;
        }

        for(int i = 0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(isVisited[nx][ny]) continue;

            isVisited[nx][ny] = true;
            list.add(map[nx][ny]);
            check(nx, ny, ex, ey, sum + map[nx][ny]);

            list.remove(list.size()-1);
            isVisited[nx][ny] = false;
        }
    }
}