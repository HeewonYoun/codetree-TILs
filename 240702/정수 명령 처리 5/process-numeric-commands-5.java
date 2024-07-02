import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 명령 개수
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push_back": // 배열 맨 뒤 삽입
                    list.add(Integer.parseInt(st.nextToken()));
                    break;
                case "get": //k번째 숫자 출력
                    int k = Integer.parseInt(st.nextToken());
                    System.out.println(list.get(k-1));
                    break;
                case "pop_back": //배열 맨 뒤 삭제
                    // list.removeLast();
                    list.remove(list.size()-1);
                    break;
                case "size": //정수 개수 출력
                    System.out.println(list.size());
                    break;
            }
        }
    }
}