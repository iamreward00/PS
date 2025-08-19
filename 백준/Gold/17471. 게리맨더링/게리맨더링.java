import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



/// 백준 17471 - 게리맨더링
/// https://www.acmicpc.net/problem/17471
public class Main {
    
    /// 이건 무슨문제일까
    /// N 개의 도시
    /// 둘째줄은 각 도시의 인구수
    /// 그다음부터 세번째 줄부터 N개의 줄에 첫번째 정수는 인접구역수
    /// 이후 인접구역 번호가 주어짐
    /// A -> B 면 B -> A 됨
    /// 두개로 선거구 나우었을때 인구 차이 최소로 ㄱㄱ
    /// 두선거구로 안되면 -1 출력
    /// 각 구역은 두 선거구 중 하나에 포함되어야함
    /// 선거구는 구역을 하나 이상 포함해야함
    /// 각 선거구는 모두 연결 되어 있어야함
    /// 일단은 N 이 10 이고 인구수는 1~10
    /// 이거 N 10이니까
    /// 2^10 파워셋 모든조합 해버려서
    /// 선거구 두개로 나누고 -> true, false 두개로 boolean 배열써서 나누고
    /// 나눴을때 1개 이상일때 만 진행
    /// 했을때 bfs 해봐야하나? 만약 bfs 과정중에 반대편꺼나오면 스킵하고? ㅇㅋ ㄱㄱ
    /// 각 그룹이 있고 그 그룹 전체를 포문에 넣어서 bfs 돌리는데 만약 두번 돌면 이제 안되는거네
    /// 그러면 어떤 변수들이 필요할까
    /// 그래프 배열은 하나면 되겠고
    /// 처음 입력 N 에
    /// 인구수 배열도 필요하네?
    /// 인덱스 1부터  N 까지 쓴다고 하고
    
    static boolean dbg = false; /// 디버깅용

    static int N;
    static ArrayList<Integer>[] graph;
    static int[] people;
    static int min = 1999999999;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[] choice;
    static int dfs(int idx){ // 모든 조합 선택하고 안하고로 하자 ㅇㅇ 불리언으로 ㅇㅇ
        if(idx == N+1){ // 시작도시가 1이니까 
            /// 여기서 모든 조합 뽑았으니까 이거 가지고 해야지
            /// 일단 1 이상인거부터
            if(dbg) System.out.println("그래도 여깆ㄴ왔냐");
            int tcnt = 0;
            int fcnt = 0;
            for(int i = 1; i <= N; i++){
                if(choice[i]){
                    tcnt++;
                }
                else{
                    fcnt++;
                }
            }
            if(tcnt==0 || fcnt == 0){ // 여기서 1차로 걸러주기
                return 0;
            }
            /// 고민되는점 각 선거구 마다 배열만들까? 아니면 그냥 choice 이거 t,f 가지고 구분할까 고민중
            /// t,f 가지고 구분 해볼까 ㅇㅋ ㄱㄱ
            /// 아니다 걍 만들자 그게 편하겠다
            /// t,f 배열 만들자
            /// 아니다 일단 그냥 해보자
            if(bfs()){ // 일단 다 인접한지 체크
                /// 그리고 여기서 min 계산 ㄱㄱ
                if(dbg) System.out.println("야 그래도 트루있따 ㅋㅋ");
                int tsum = 0;
                int fsum = 0;
                for(int i = 1; i <= N; i++){
                    if(choice[i]) tsum += people[i];
                    else fsum += people[i];
                }
                int peosum = Math.abs(fsum-tsum);
                if(peosum < min){
                    min = peosum;
                }
            }; 

            
            return 0;
        }


            choice[idx] = true;
            dfs(idx+1);
            choice[idx] = false;
            dfs(idx+1);
        return 0;
    }

    static boolean bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(choice[i]){
                queue.add(i);
                vis[i] = true;
                break;
            }
        }// 제일처음나오는거 하나 그냥 넣었음
        int truecnt = 1;
        while(!queue.isEmpty()){
            int num = queue.poll();
            
            for(int i : graph[num]){
                if(vis[i] || !choice[i]) continue;
                queue.add(i);
                truecnt++;
                vis[i] = true;
            }
        }

        queue = new LinkedList<>();
        vis = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(!choice[i]){
                queue.add(i);
                vis[i] = true;
                break;
            }
        }// 제일처음나오는거 하나 그냥 넣었음
        int falsecnt = 1;
        while(!queue.isEmpty()){
            int num = queue.poll();
            
            for(int i : graph[num]){
                if(vis[i] || choice[i]) continue;
                queue.add(i);
                falsecnt++;
                vis[i] = true;
            }
        }

        if(truecnt+falsecnt != N){
            return false;
        }
        return true;
    }

    static boolean[] landcheck;
    static int checkall(int idx){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(idx);
        landcheck[idx] = true;
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i : graph[num]){
                if(landcheck[i]) continue;
                queue.add(i);
                landcheck[i] = true;
            }
        }


        return 0;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        
        people = new int[N+1];
        graph = new ArrayList[N+1];
        choice = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine()); // 인구수 한줄 로된거
        for(int i = 1; i <= N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        
        /// 0번 도시부터 N-1 번 도시까지 총 N 개 처음은 인접한거수 
        for(int i = 1; i<= N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= m; j++){
                int a = Integer.parseInt(st.nextToken());
                graph[i].add(a);
                graph[a].add(i);
            }
        }
        
        if(dbg){
            for(int i = 1; i <= N; i++){
                System.out.println(Arrays.toString(graph[i].toArray()));
            }
        }
        landcheck = new boolean[N+1];
        int landcnt = 0;
        for(int i = 1; i<= N; i++){ /// -1 나오는거 관계 저따구일때만 하기로했는데 전체 bfs 돌려서 섬이 3개 이상일떄 안된다고 해야하는듯?
            if(landcheck[i]) continue;
            if(dbg) System.out.println("ㅑ" + i);
            int a = checkall(i);
            landcnt++;
            if(landcnt>=3){
                System.out.println(-1);
                return;
            }
        }
        /// 이제 모든 조합 찾기 ㄱㄱㄱㄱㄱ
        if(dbg) System.out.println("시작");
        dfs(1);
        System.out.println(min);
        if(dbg) System.out.println("끝");
    }
}
