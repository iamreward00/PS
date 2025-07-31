import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[6];
        int [] idx = new int[6];
        for(int i = 0; i < 6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            idx[i] = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ansidx = -1;
        for(int i = 0; i < 6; i++){
            if(idx[i] == idx[(i+2)%6] && idx[(i+1)%6] == idx[(i+3)%6]){
                ansidx = i;
                break;
            }
        }

        int height = arr[ansidx] + arr[(ansidx+2)%6];
        int weight = arr[(ansidx+1)%6] + arr[(ansidx+3)%6];
        
        int minus = arr[(ansidx+2)%6] * arr[(ansidx+1)%6];
        System.out.println((weight * height - minus) * N);

        

    }


}
