import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int idx = 0;

        while(true){
            int temp1 = N - ( 2 * idx );
            int temp2 = M - idx;
            if(temp1 < 0 || temp2 < 0 || temp1+temp2< R){
                break;
            }

            idx++;
        }
        System.out.println(idx-1);
        

    }
}
