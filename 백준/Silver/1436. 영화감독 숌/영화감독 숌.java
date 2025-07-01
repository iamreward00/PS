import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static boolean check(int n){
        String st = n + "";
        for(int i = 0; i < st.length()-2; i++){
            if(st.charAt(i) == '6' && st.charAt(i+1) == '6' && st.charAt(i+2) == '6'){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        int num = Integer.parseInt(br.readLine());
        int st_num = 666;

        while (cnt < num){
            if (check(st_num)) {
                cnt++;
            }
            
            st_num++;
        }
        System.out.println(st_num - 1);
        bw.close();
        br.close();

    }
}