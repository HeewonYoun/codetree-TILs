import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static int[] num;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        //각 자리수를 모두 각각 더해봤을 때 10 이상이 되는 경우가 없는 것
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        //조합
        b(0, 0, 0);
        System.out.println(result);
    }

    private static void b(int depth, int count, int sum){
        result = Math.max(result, count);

        if(depth == n) {
            return;
        }

        for(int i = depth; i < n; i++){
            if(isNotCarry(sum, num[i])){
                b(i + 1, count + 1, sum + num[i]);
            }
        }
    }

    private static boolean isNotCarry(int sum, int number){
        while(sum > 0 || number > 0){
            //자릿수 구하기
            int a = sum % 10;
            int b = number % 10;
            // System.out.println("a:" + a + " b: " + b );

            //현재 자릿수들의 합이 10이 넘으면 안됨
            if(a + b >= 10){
                return false;
            }

            sum = sum / 10;
            number = number / 10;
        }

        return true;
    }
}