import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static int n,m;
    static int[][] map;
    static int maxnum = 0;
    static boolean[][] vis;
    static void dfs(int idx, int jdx, int cnt){

        if(idx==n){ // 나는 00 01 02 10 11 12 가다가 이제 어디가면 종료되는거지 2 0 가면 종료인가 
            maxnum = Math.max(maxnum, cnt);
            return;
        }

        int nidx = idx;
        int njdx = jdx+1;
        if(njdx==m){
            nidx=idx+1;
            njdx=0;
        }
        /// 선택한다
        /// ㄴ 
        /// 나 , 내 위, 내 오른쪽
        /// 내 위랑, 내 오른쪽이 없으면 불가능함  내위 idx-1 내오른쪽 jdx+1 
        if(idx-1 >= 0 && jdx+1 < m){
            if( !(vis[idx-1][jdx] || vis[idx][jdx+1] || vis[idx][jdx]) ) {
                vis[idx-1][jdx] = true;
                vis[idx][jdx+1] = true;
                vis[idx][jdx] = true;

                int a = map[idx][jdx] + map[idx][jdx] + map[idx-1][jdx] + map[idx][jdx+1];
                dfs(nidx,njdx,cnt+a);

                vis[idx-1][jdx] = false;
                vis[idx][jdx+1] = false;
                vis[idx][jdx] = false;

            }

        }


        /// ㄴ반대 
        /// 나, 내 위 , 내 왼쪽
        /// 내 위랑 내 왼쪽이 없으면 불가능함 
        if(idx-1 >= 0 && jdx-1 >= 0){
            if( !(vis[idx-1][jdx] || vis[idx][jdx-1] || vis[idx][jdx]) ) {
                vis[idx-1][jdx] = true;
                vis[idx][jdx-1] = true;
                vis[idx][jdx] = true;

                int a = map[idx][jdx] + map[idx][jdx] + map[idx-1][jdx] + map[idx][jdx-1];
                dfs(nidx,njdx,cnt+a);

                vis[idx-1][jdx] = false;
                vis[idx][jdx-1] = false;
                vis[idx][jdx] = false;

            }
        }


        /// ㄱ 
        /// 나, 내 왼쪽 ,내 아래
        /// 내 왼쪽, 내 아래가 없으면 불가능함 
        if(idx +1 < n && jdx -1 >= 0){
            if( !(vis[idx+1][jdx] || vis[idx][jdx-1] || vis[idx][jdx]) ) {
                vis[idx+1][jdx] = true;
                vis[idx][jdx-1] = true;
                vis[idx][jdx] = true;

                int a = map[idx][jdx] + map[idx][jdx] + map[idx+1][jdx] + map[idx][jdx-1];
                dfs(nidx,njdx,cnt+a);

                vis[idx+1][jdx] = false;
                vis[idx][jdx-1] = false;
                vis[idx][jdx] = false;

            }
        }
        
        /// ㄱ반대
        /// 나 , 내오른쪽 , 내 아래
        /// 내오른쪽 내 아래 없으면 불가능함
        if(idx + 1 < n && jdx + 1 < m){
            if( !(vis[idx+1][jdx] || vis[idx][jdx+1] || vis[idx][jdx]) ) {
                vis[idx+1][jdx] = true;
                vis[idx][jdx+1] = true;
                vis[idx][jdx] = true;

                int a = map[idx][jdx] + map[idx][jdx] + map[idx+1][jdx] + map[idx][jdx+1];
                dfs(nidx,njdx,cnt+a);

                vis[idx+1][jdx] = false;
                vis[idx][jdx+1] = false;
                vis[idx][jdx] = false;

            }
        }

        ///선택 안한다
        dfs(nidx, njdx, cnt);



    }

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        vis = new boolean[n][m];
        for(int i = 0 ; i < n ;i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m ;j  ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);


        System.out.println(maxnum);


    }
}

/*
무기공학
무공
무적의공격대

흠
이게
5x5 네요

이게 음
4방향이있는데 
그거 다 하나 흠
이게 완탐이라카면
음

그러니까 내 지금 한  i j 에서 상하좌우 다 쭉쭉쭉 가보는 거지 재귀로
백트 하면서 하면
되겠네

구현이 그러면 흠
이야 좀 빡세네

할수있는게
현재를 중심으로 선택한다
나올수있는 4가지를 하고 방문배열체크하고 재귀 진행한다

나를 선택안한다
그냥스킵한다

하면 되겠는데




*/