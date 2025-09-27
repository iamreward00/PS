import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int C,N;
    static int[][] arr;
    static int INF = 1999999999;
    static int[][] memo;

    static int dfs(int idx,int peo){

        if(peo >= C){
            return 0;
        }
        if(idx >= N) return INF;

        if(memo[idx][peo]!=-1) return memo[idx][peo];


        int a = dfs(idx,peo+arr[idx][1]) + arr[idx][0];
        int b = dfs(idx+1,peo);

        int res = Math.min(a, b);
        memo[idx][peo] = res;
        return memo[idx][peo] ;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a; // 비용
            arr[i][1] = b; // 사람수 a 원쓰면  b 명 확보 가능
        }
        memo = new int[N][C*3];
        for(int i = 0; i < N; i++) Arrays.fill(memo[i], -1);
        System.out.println(dfs(0,0));


    }
}

