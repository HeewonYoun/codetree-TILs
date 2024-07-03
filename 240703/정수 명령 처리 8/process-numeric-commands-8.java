import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> ll = new LinkedList<>();

        for(int t = 0; t<n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push_front":
                    ll.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    ll.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    System.out.println(ll.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(ll.pollLast());
                    break;
                case "size":
                    System.out.println(ll.size());
                    break;
                case "empty":
                    if(ll.isEmpty()){
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    System.out.println(ll.peekFirst());
                    break;
                case "back":
                    System.out.println(ll.peekLast());
                    break;
            }
        }
    }
}