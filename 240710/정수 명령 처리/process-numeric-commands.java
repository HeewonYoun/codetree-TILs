import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push":
                    s.push(Integer.parseInt(st.nextToken()));
                    break;
                case "size":
                    System.out.println(s.size());
                    break;
                case "empty":
                    if(s.isEmpty()){
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "pop":
                    System.out.println(s.pop());
                    break;
                case "top":
                    System.out.println(s.peek());
                    break;
            }
        }        
    }
}