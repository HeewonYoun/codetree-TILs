import java.io.*;
import java.util.*;


public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length-1);
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

    }

    static void merge_sort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
        if(low == high) return;
        
    }

    static void merge(int[] arr , int low, int mid, int high){
        int i = low; // 왼쪽 시작점
        int j = mid+1; //오른쪽 시작점
        int k = low;

        int[] sorted_arr = new int[arr.length];
        
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                sorted_arr[k] = arr[i];
                k++;
                i++;
            } else {
                sorted_arr[k] = arr[j];
                k++;
                j++;
            }
        }

        //오른쪽 리스트가 새 배열에 채워졌을 경우
        while(i<=mid){
            sorted_arr[k] = arr[i];
                k++;
                i++;
        }

        //왼쪽 리스트가 새 배열에 채워졌을 경우
        while(j<=high){
            sorted_arr[k] = arr[j];
                k++;
                j++;
        }

        for(int start = low ; start <= high; start++){
            arr[start] = sorted_arr[start];
        }
    }
}