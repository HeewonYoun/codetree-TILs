import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 식빵 개수
        int m = Integer.parseInt(st.nextToken()); // 암호문 개수

        LinkedList<Character> ll = new LinkedList<>();
        String breadStr = br.readLine();
        for(int i = 0; i<n; i++){
            ll.addLast(breadStr.charAt(i));
        }

        ListIterator<Character> iter = ll.listIterator(ll.size());
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "L":
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case "R":
                    if(iter.hasNext()) iter.next();
                    break;
                case "D":
                    if(iter.hasNext()){
                        iter.next();
                        iter.remove();
                    }
                    break;
                case "P":
                    iter.add(st.nextToken().charAt(0));
                    break;
            }
        }

        iter = ll.listIterator();
        while(iter.hasNext()){
            System.out.print(iter.next());
        }
    }
}