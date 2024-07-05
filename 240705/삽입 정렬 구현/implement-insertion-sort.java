import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        //삽입정렬
        for(int i = 1; i<n; i++){
            int j = i-1;
            int key = num[i];
            while(j >= 0 && num[j] > key){
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = key;
        }

        for(int i = 0; i<n; i++){
            System.out.print(num[i] + " ");
        }

    }
}