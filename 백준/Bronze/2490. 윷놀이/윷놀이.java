import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        char[] arr = new char[5];
        arr[0] = 'D';
        arr[3] = 'A';
        arr[2] = 'B';
        arr[1] = 'C';
        arr[4] = 'E';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int j = 0; j< 4; j++){
                int a = Integer.parseInt(st.nextToken());
                sum += a;
            }
            System.out.println(arr[sum]);
        }

    }
}
