import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int len = 1;
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            int tmp = String.valueOf(arr[i]).length();
            if(tmp > len){
                len = tmp;  
            }
        }

        //자릿수만큼 반복
        for(int i = 1; i<=len; i++){
            sort(i-1);
        }

        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    //기수정렬
    static void sort(int k){
        ArrayList<Integer>[] list = new ArrayList[10];
        for(int i = 0; i<10; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<arr.length; i++){
            int num = (int)(arr[i]%(Math.pow(10,k+1)));
            num = (int) (num / (Math.pow(10,k)));


            list[num].add(arr[i]);
        }

        int[] result = new int[arr.length];
        int cnt = 0;
        for(int i =0; i<10; i++){
             for(int j = 0; j < list[i].size(); j++){
                result[cnt] = list[i].get(j);
                cnt++;
             }
        }
        arr = result;
    }
}