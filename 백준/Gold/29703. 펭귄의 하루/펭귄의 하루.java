import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws Exception{
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];


        int sti = 0;
        int stj = 0;

        int hoi = 0;
        int hoj = 0;

        for(int i = 0 ; i< n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                char c = str.charAt(j);
                arr[i][j] = c;
                if(c=='S'){
                    sti=i;
                    stj=j;
                }
                if(c=='H'){
                    hoi = i;
                    hoj = j;
                }
            }
        }

        int[][] gos = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sti,stj,0});
        vis[sti][stj] = true;

        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curi = cur[0];
            int curj = cur[1];
            int cnt = cur[2];

            if( arr[curi][curj]=='F' || gos[curi][curj] ==0 ){
                gos[curi][curj] = cnt;
            }

            for(int i = 0; i < 4; i++){
                int ni = curi + di[i];
                int nj = curj + dj[i];
                if(ni < 0 || ni >= n || nj < 0 || nj >= m || vis[ni][nj] || arr[ni][nj] =='D' ) continue;
                queue.add(new int[] { ni,nj,cnt+1});
                vis[ni][nj] = true;
            }
        }

        int[][] goh = new int[n][m];
        queue = new LinkedList<>();
        vis = new boolean[n][m];
        queue.add(new int[] { hoi,hoj,0});
        vis[hoi][hoj] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curi = cur[0];
            int curj = cur[1];
            int cnt = cur[2];

            if( arr[curi][curj]=='F' || goh[curi][curj] ==0 ){
                goh[curi][curj] = cnt;
            }

            for(int i = 0; i < 4; i++){
                int ni = curi + di[i];
                int nj = curj + dj[i];
                if(ni < 0 || ni >= n || nj < 0 || nj >= m || vis[ni][nj] || arr[ni][nj] =='D' ) continue;
                queue.add(new int[] { ni,nj,cnt+1});
                vis[ni][nj] = true;
            }
        }

        int min = 1999999999;
        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] =='F'){
                    int a = gos[i][j];
                    int b = goh[i][j];
                    if(a != 0 && b != 0){
                        min = Math.min(a+b, min);
                    }
                }
            }
        }
        if(min == 1999999999) System.out.println(-1);
        else System.out.println(min);


    }
}

/*

모든 F를가긴해야겠네 ?
S 에서 F 가는 모든 길이랑
F 에서 H 가는 모든 길이 하면될거같은데 
그러면 음 배열을ㄷ ㅜ개 더 해야겠네 





*/