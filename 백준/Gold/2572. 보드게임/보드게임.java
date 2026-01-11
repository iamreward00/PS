import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     * 
     * 아 N 번 탐색? 하긴 해야하네
     * 그러니까 마을이 아무리 작거나 커도 탐색횟수는 N 번
     * 기저 if(idx==n) break; 인거고
     * 
     * 이게 백트래킹이 되나?
     * 그러니까 max 값 하나 구해놓고
     * 남은횟수 + 현재까지 카운트 < max 면 안가게
     * 해보면 얼추 될거같은데 
     * 모든 경로에서 해보고
     * 방문체크는 안하고 왜냐면 중복해서 왔다갔다 할수있으니까
     * 
     * 백트를 한다면 만약 메모이제이션도 같이 넣을 수 있을까
     * idx - 몇번째, cnt 이때까지 수
     * 에 대해서 메모이 제이션을 할 수 가 있지
     * 
     * 
     * 
     * 
     * 
     * 그리고 또 
     * R G B 3가지 경우밖에없는데 이걸로 뭐가 될까?
     * 당장은 모르겠네
     * 
     */

    
    static int n;
    static int[] arr;
    static int m, k;
    static ArrayList<int[]>[] list;
    static int answer = 0;
    static int[][] memo;

    static int dfs(int idx, int cnt){
        
        if(cnt == n){
            
            return 0;
        }

        if(memo[idx][cnt] != -1 ) return memo[idx][cnt];

        
        
        int target = arr[cnt];
        int max = 0;
        for(int i[] : list[idx]){
            int next = i[0];
            int color = i[1];
            if(target == color){
                max = Math.max(max,dfs(next, cnt+1) + 1);
            }
            else{
                max = Math.max(max,dfs(next, cnt+1));
            }
        }
        memo[idx][cnt] = max;
        return memo[idx][cnt];
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] =  st.nextToken().charAt(0);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        list = new ArrayList[m+1];
        for(int i = 1; i <= m; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            list[a].add(new int[] { b, c});
            list[b].add(new int[] { a, c});
            
        }


        memo = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            
                Arrays.fill(memo[i], -1);
            
        }
        int a = dfs(1,0);
        // for(int i = 0; i<= m; i++){
        //     System.out.println(Arrays.toString(memo[i]));
        // }

        System.out.println(a*10);
        
    }
    
}


/*
5
R G R B G
4 5
1 2 R
1 3 G
2 3 G
1 4 R
4 3 B
 * 
 */ 