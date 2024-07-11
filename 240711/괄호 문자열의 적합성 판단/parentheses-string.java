import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] bracket = br.readLine().toCharArray();

        Stack<Character> s = new Stack<>();
        for(int i = 0; i<bracket.length; i++){
            if(bracket[i] == '('){
                s.push(bracket[i]);
            } else if(bracket[i] == ')'){
                if(!s.isEmpty()){
                    s.pop();
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }

        if(s.isEmpty()){
            System.out.println("Yes");
        } else {
             System.out.println("No");
        }
    }
}