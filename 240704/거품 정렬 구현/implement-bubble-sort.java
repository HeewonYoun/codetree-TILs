import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
       
        boolean sorted = true;
        do {
            sorted = true;
            for(int i = 0; i<n-1; i++){
                if(num[i] > num[i+1]){
                    int tmp = num[i];
                    num[i] = num[i+1];
                    num[i+1] = tmp;
                    sorted = false;
                }
            }
        } while (sorted == false);
        
        for(int i = 0; i<n; i++){
            System.out.print(num[i]+ " ");
        }
    }
}