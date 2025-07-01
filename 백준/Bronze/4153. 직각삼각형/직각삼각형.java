import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int arr[] = new int[3];
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0){ 
                break;
            }
            Arrays.sort(arr);
            if( (arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2])){
                bw.write("right\n");
            }
            else{
                bw.write("wrong\n");
            }
            
        }

        br.close();
        bw.close();
    }
}