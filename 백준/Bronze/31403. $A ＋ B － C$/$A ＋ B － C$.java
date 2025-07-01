import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st_1 = br.readLine();
        String st_2 = br.readLine();
        String st_3 = br.readLine();

        int num = Integer.parseInt(st_1) + Integer.parseInt(st_2) - Integer.parseInt(st_3);
        
        String st = "";
        st += st_1;
        st += st_2;
        int ans = Integer.parseInt(st) - Integer.parseInt(st_3);

        bw.write(String.valueOf(num) + "\n");
        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}