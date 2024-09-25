import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> num = new HashMap<>();
        int[] list = new int[N];

        for(int i = 0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(!num.containsKey(tmp)){
                num.put(tmp, 1);
            }
            list[i] = tmp;
        }

        //개수 세기
        int max = 0;
        Set<Integer> keySet = num.keySet();
        Iterator<Integer> iter = keySet.iterator();

        while(iter.hasNext()){
            int check = iter.next();
            int isContinue = list[0];
            int count = 0;

            for(int i = 0; i<N; i++){
                if(list[i] == check){
                    // System.out.println(list[i]+" "+check);
                    continue;
                }
                if(list[i] == isContinue){
                    count++;
                    // System.out.println(list[i]+" +1, count: " + count);
                } else {
                    max = Math.max(count, max);
                    isContinue = list[i];
                    count = 1;
                }
            }
        }

        System.out.println(max);
    }
}