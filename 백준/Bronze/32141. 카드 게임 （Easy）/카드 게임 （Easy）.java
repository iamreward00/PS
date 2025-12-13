import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int a= Integer.parseInt(st.nextToken());
            sum += a;
            if(sum >= m){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
        


    }
}

/*

*/