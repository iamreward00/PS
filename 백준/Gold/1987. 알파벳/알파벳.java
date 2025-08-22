import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/// 백준 1987 알파벳
/// https://www.acmicpc.net/problem/1987
public class Main {

    /// 알파벳의 총 숫자가 작으니 한번 비트마스킹으로 풀어보자
    /// 와 비트마스킹으로 풀어보고 왜 시간 비슷하지 했는데
    /// 비슷한게 맞네
    /// 근데 시간은 비슷한데
    /// 공간이 달라지네
    /// boolean a[26];: 최소 26 바이트(Byte)가 필요합니다.
    /// int mask;: 단 4 바이트만 필요합니다.
    /// 그리고 현재까지의 상태를
    /// 단 하나로 표현가능함
    /// 그러니까 배열이라면
    /// 26번 탐색하고
    /// 문자열만들고 해야하는데
    /// 비트마스킹이면
    /// 비트 int 변수 단 하나로! 된다는거임!!!!
    /// 그럼 이 단하나로 표현이 된다는게 무엇에 도움이 되는가???
    /// 그것은 바로 메모이제이션이 가능하게 되는거임
    /// 와
    /// 와
    /// 그러니까 원래도 메모이제이션 i ,j 좌표에 "AVFS" 라는문자열을 가지고있을수있다 라고 표현할수있었는데
    /// 이거를 AVFS 문자열만드는데도 시간오래걸리고 하니까 그랬는데
    /// 근데 이거를 비트로바꾸니까 한번에 바로 i j = 1010101 같은게 되는거지 한번에 빡
    /// 와
    /// 진짜 충격먹음
    /// 
    static boolean dbg = false;

    static int R,C;
    static char[][] map;
    //static boolean[] alpa = new boolean[30]; //알파벳몇개더라 그냥 30주고 -'A' 하자...
    static int max = 0;
    static int alpabit = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] memo;
    static int dfs(int idx, int jdx , int cnt){

    
        max = Math.max(max,cnt);
        if(max == 26){
            return 0;
        }
        

        if(dbg)System.out.println(idx + " " + jdx + " " + cnt + " " + map[idx][jdx]) ;
        
        int[] di = {1,-1,0,0};
        int[] dj = {0,0,1,-1};

        for(int i = 0; i < 4; i++){
            int ni = idx + di[i];
            int nj = jdx + dj[i];
            //if(ni<0 || ni >= R || nj < 0 || nj >= C ||  alpa[map[ni][nj]-'A'] ) continue;
            //alpa[map[ni][nj]-'A'] = true;
            //dfs(ni,nj,cnt+1);
            //alpa[map[ni][nj]-'A'] = false;
            if(ni<0 || ni >= R || nj < 0 || nj >= C  || (alpabit & (1 << map[ni][nj]-'A')) != 0  ) continue;

            if(memo[ni][nj] == (alpabit | (1 << map[ni][nj]-'A'))) continue;
            
            memo[ni][nj] = alpabit | (1 << map[ni][nj]-'A');
            alpabit = (alpabit | (1 << map[ni][nj]-'A'));
            dfs(ni,nj,cnt+1);
            alpabit = (alpabit ^ (1 << map[ni][nj]-'A'));
        }



        return 0;
    }


    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        memo = new int[R][C];
        map = new char[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        if(dbg){
            for(int i = 0; i < R; i++){
            System.out.println(Arrays.toString(map[i]));
            }
        }

        alpabit = (alpabit | (1 << map[0][0]-'A'));
        memo[0][0] = alpabit;
        dfs(0,0,1);
        
        System.out.println(max);
    }  
}









// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// /// 백준 1987 알파벳
// /// https://www.acmicpc.net/problem/1987
// public class Main {

//     /// 2년전의 나는 이문제를 틀렸다
//     /// 과연 2년후의 나는 이문제를 풀수있을것인가!!! 두둥!
//     /// R * C 격자판이 있다
//     /// 여기에 알파벳들이 적혀있다 
//     /// 알파벳 중복없이 갈때 제일 길게 얼마나 갈수있나?
//     /// 이러면 모든점에서 dfs 탐색 시작해야겠네!
//     /// 20 * 20 해서 일단 400번의 dfs 가 존재함
//     /// dfs 에서는 상하좌우 한다음
//     /// 갔는데 이미 있던거면 돌아오면될듯?
//     /// 이거 방문체크배열 두개쓰면서
//     /// 하면될거같은데?
//     /// ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ
//     /// 이제보니까 방문배열 알파벳 하나만 하면되겠네
//     /// 어짜피 알파벳 체크해버리니까 ㅇㅋ
    
//     static boolean dbg = false;

//     static int R,C;
//     static char[][] map;
//     static boolean[] alpa = new boolean[30]; //알파벳몇개더라 그냥 30주고 -'A' 하자...
//     static int max = 0;

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     static StringTokenizer st;
//     static StringBuilder sb = new StringBuilder();
    
//     static int dfs(int idx, int jdx , int cnt){


//         if(cnt > max){
//             max = cnt;

            
//         }
//         if(dbg)System.out.println(idx + " " + jdx + " " + alpa[map[idx][jdx] -'A'] + cnt + " " + map[idx][jdx]) ;
        
//         int[] di = {1,-1,0,0};
//         int[] dj = {0,0,1,-1};

//         for(int i = 0; i < 4; i++){
//             int ni = idx + di[i];
//             int nj = jdx + dj[i];
//             if(ni<0 || ni >= R || nj < 0 || nj >= C ||  alpa[map[ni][nj]-'A'] ) continue;
//             alpa[map[ni][nj]-'A'] = true;
//             dfs(ni,nj,cnt+1);
//             alpa[map[ni][nj]-'A'] = false;
//         }



//         return 0;
//     }


//     public static void main(String[] args) throws Exception{
//         st = new StringTokenizer(br.readLine());
//         R = Integer.parseInt(st.nextToken());
//         C = Integer.parseInt(st.nextToken());
//         map = new char[R][C];
//         for(int i = 0; i < R; i++){
//             String str = br.readLine();
//             for(int j = 0; j < C; j++){
//                 map[i][j] = str.charAt(j);
//             }
//         }
        
//         if(dbg){
//             for(int i = 0; i < R; i++){
//             System.out.println(Arrays.toString(map[i]));
//             }
//         }

//         alpa[map[0][0]-'A'] = true;
//         dfs(0,0,1);
        
//         System.out.println(max);
//     }  
// }
