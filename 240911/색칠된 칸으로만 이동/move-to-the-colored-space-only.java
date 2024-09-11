import java.io.*;
import java.util.*;

public class Main {

    static int M, N, result;

    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static List<int[]> isFilled = new ArrayList<>(); // 색칠된 칸의 좌표 목록
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for (int i = 0; i < M; i++) { // 각 칸에 쓰여진 숫자
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) { // 색칠 여부
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    isFilled.add(new int[]{i, j});
                }
            }
        }

        // 이분 탐색으로 가능한 D의 최솟값 구하기
        int left = 0;
        int right = 1_000_000_000;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 현재 D(mid)로 색칠된 모든 칸이 연결될 수 있는지 확인
            if (isConnected(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean isConnected(int D) {
        isVisited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();

        // 첫 번째 색칠된 칸을 시작으로 BFS 탐색
        int[] start = isFilled.get(0);
        queue.add(start);
        isVisited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (isVisited[nx][ny]) continue;

                int diff = Math.abs(map[cx][cy] - map[nx][ny]);

                if (diff <= D) {
                    isVisited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        for(int i = 0; i<isFilled.size(); i++){
            int[] pos = isFilled.get(i);
            if(!isVisited[pos[0]][pos[1]]){
                return false;
            }
        }

        return true;
    }
}