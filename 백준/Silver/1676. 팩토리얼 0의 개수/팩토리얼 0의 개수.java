import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        int num = Integer.parseInt(br.readLine());

        while(num >= 5){
            cnt += num/5;
            num = num/5;
        }
        bw.write(String.valueOf(cnt));

        bw.close();
        br.close();

    }
}