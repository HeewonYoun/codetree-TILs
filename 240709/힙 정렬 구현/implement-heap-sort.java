import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        heap_sort(n);
        // System.out.print("durl");
        for(int i = 1; i<n+1; i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void heapify(int index, int n){
        int largest = index;
        int left = largest * 2;
        int right = largest * 2 + 1;

        if(left <= n && arr[left] > arr[largest]){
            largest = left;
        }

        if(right <= n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != index){
            int tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;
            heapify(largest, n);
        }
    }

    static void heap_sort(int n){
        for(int i = n/2; i>0; i--){
            heapify(i, n);
        }

        for(int i = n; i > 0; i--){
            int tmp = arr[i];
            arr[i] = arr[1];
            arr[1] = tmp;
            
            heapify(1, i-1);
        }
    }
}