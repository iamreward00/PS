import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        String out = br.readLine();

        boolean[] check = new boolean[26];
        char[] arr = new char[26];
        int idx = 0;
        for(int i = 0; i < in.length() ;i++){
            char c = in.charAt(i);
            if(check[c-'A']) continue;
            check[c-'A'] = true;
            arr[idx++] = c;
        }
        int ldx = 0;
        for(int i = idx; i < 26; i++){
            if(check[ldx]) {
                ldx++;
                i--;
                continue;
            }
            arr[i] = (char)(ldx + 'A');
            ldx++;
            
        }

        for(int i = 0; i < out.length(); i++){
            System.out.print( arr[out.charAt(i)-'A']);
        }

    }
}