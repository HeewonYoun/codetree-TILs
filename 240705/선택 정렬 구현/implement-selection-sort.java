import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken()); 
        }

        //선택 정렬
        
        for(int i = 0; i<n-1; i++){
            int min = i;
            for(int j = i; j<n-1; j++){
                if(num[min] > num[j]){
                    min = j;
                }
            }
            int tmp = num[i];
            num[i] = num[min];
            num[min] = tmp;
        }

        for(int i = 0; i<n; i++){
            System.out.print(num[i] + " " );
        }



    }
}