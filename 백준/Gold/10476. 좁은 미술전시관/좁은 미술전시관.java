import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static int[][] arr;
    static int[][][][] memo;
    static int INF = 199999999;

    static int dfs(int idx, int cnt, int left, int right){

        if(cnt == m){
            return 0;
        }
        if(idx >= n || cnt > m){
            return INF;
        }
        if(memo[idx][cnt][left][right] != -1) return memo[idx][cnt][left][right];

        int a = INF;

        // 스킵한다
        a = Math.min(a,dfs(idx+1, cnt, 0, 0));

        // 선태한다
        // 그런데 이제 이전깨 0 이거나 바로 내 뒤가 1 이여야 선택 가능해요
        // 그럼 왼쪽선택 오른쪽 선택 나눠서 하죠
        
        // 왼쪽
        if(right != 1 ){
            a = Math.min(a, dfs(idx+1, cnt+1, 1, 0)+arr[idx][0]);
        }

        // 오른쪽
        if(left != 1){
            a = Math.min(a, dfs(idx+1, cnt+1, 0, 1)+arr[idx][1]);
        }

        return memo[idx][cnt][left][right] = a;


    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            sum += a + b;
        }
        st = new StringTokenizer(br.readLine());
        memo = new int[n][n][2][2];

        for(int i = 0; i < n;  i++){
            for(int j = 0; j < n ; j++){
                for(int k = 0; k < 2; k++){
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }

        System.out.println(sum-dfs(0,0,0,0));


    }
}

/*
음

세로 N 줄 가로 2칸

k 개의 방을 닫아야해요
근데 이제 바로 옆이랑
대각선은 못닫아요

0 0
0 0 
0 0
0 0 
0 0
0 0
0 0 

이며ㅕㅕㄴ 음

1 0
1 0
0 1 은안되네요 ? 그럼 여ㅕ긴 무조건 쉬어야하네 ?

꺽이는건 그러니까 한칸 건너고 건너편해야하네


스킵한다 

닫을 수 있다면 닫는다 


이제 음
idx, left , right 

로해서 
left 는 닫혔는지 안닫혔는지 하면 될거같은데 ?

3차원 메모이제이션 하면되겠당

근데 개수도 필요하지않나
cnt 가 초과면 ㅃㅃ 니까

그러며ㅕㄴ

200 200 2 2  인가 ?
안터지네


최소로 만들고 총합에서 빼면 되겠당


가치는 100이하니까 int 써도 되겠당



*/