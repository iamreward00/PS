import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken());
        

        int minsum = K * (K + 1) / 2;

        if (N < minsum) {
            System.out.println(-1);
        } else {

            int a = (N - minsum) % K;
            

            if (a == 0) {
                System.out.println(K - 1);
            } 

            else {
                System.out.println(K);
            }
        }
    }
}