import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num * num;
        }
        bw.write(String.valueOf(sum % 10));

        bw.close();
        br.close();
        

    }
}