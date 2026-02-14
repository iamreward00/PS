import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main {

    static int mod = 1000000007;
    static int n;
    static int[] memo;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        memo = new int[n+3];

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for(int i = 2; i <= n; i++){
            memo[i] =((memo[i-1]%mod ) + (memo[i-2]%mod) ) %mod;
        }
        System.out.println(memo[n]);

    }
}

/*




*/