import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // a! / b!(a-b)!
        int arr[] = new int[11];
        arr[0] = 1;
        for (int i = 1; i <= 10; i++) {
            arr[i] = arr[i-1]*i;
        }

        int answer = arr[a] / (arr[b] * (arr[a-b]));
        System.out.println(answer);
        br.close();


    }
}