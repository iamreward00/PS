import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
     * 21:34 시작
     * 연두 플워 공부함
     * N^3 이라함
     * 와 신난다
     * 
     * N 개의 정점과 M 개의 양방향 간선으로 이루어진 단순 연결 그래프
     * 정점 1부터 시작 번호
     * 딱하나의 간선만 가중치 1 나머지 0
     * 
     * 그래프에서 모든 정점 쌍의 최단 거리의 합을 구해보려고 한다
     * 
     * 
     * 아니아니 ㅋㅋㅋ잠시만요
     * 한국어가 너무 어려워요 
     * 
     * 아 어느간선이 가중치 1인지 주네요?
     * 
     * 흠
     * N 이 10만
     * M 은 20만
     * 
     * 우리가 원하는거
     * 플루이드 워셜 그 2차원 배열에 있는 모든 숫자의 합
     * 근데 플워터짐 시간
     * 
     * 이거
     * 정점 2개만 보면 되는거 아닐까?
     * 2에서 bfs 돌리고
     * 3에서 bfs 돌리면?
     * 왜냐면
     * 그전까지는 1이니까
     * 2-3->? 이거 개수랑
     * 3-2->? 이거 개수 카운트하면 될거같은데요?
     * 근데요 근데요
     * 그냥 2에서 시작하고
     * 3에서 시작하면요?
     * 아니네요
     * 2-3 -> ? 이랑
     * 3 - 2 -> ? 인데
     * 아니 똑같은거 아니에요?
     * 
     * 2에서 돌려도
     * 3에서 왔다고 치면되잖아요
     * 
     * 이게 그러니까
     * 2에서랑 3에서랑
     * 그거 양쪽 나눠서
     * 하는느낌으로
     * 하는건가?
     * 내가 ? -> 2 - > 3 - > ? 인거잖아
     * 저게 이제 모든 경우의 수가 1인거고
     * 
     * 근데 왜 6이지?
     * 
     * 아 2랑 3도 가는구나
     * 
     * 2에서 3 거쳐서 가는거 전부 1 -> 4,5
     * 3에서 2거쳐서 가는거 전부 1 -> 1
     * 
     * 2,3 뺴고 나머지
     * 
     * 2의 왼쪽것들 1 에서
     * 3오른쪽 것들로 가는법인가
     * 
     * 아니 근데 minD 뽑아보니까
     * 그냥
     * 1개수 끼리
     * 곱하면
     * 될거같은데요
     * 
     * 
     * 
     */


    static int n,m,k;
    static ArrayList<int[]>[] list;
    static int start,end;

    static int[] dijk(int idx){
        int[] minD = new int[n+1];
        Arrays.fill(minD, 999999999);
        minD[idx] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[] { idx,minD[idx]});

        boolean[] vis = new boolean[n+1];

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int a = cur[0];
            int w = cur[1];
            if(vis[a]) continue;
            vis[a] = true;

            for(int[] i : list[a]){
                int aa = i[0];
                int ww = i[1];
                if(minD[aa] > w + ww){
                    minD[aa] = w + ww;
                    pq.add(new int[] { aa, minD[aa]});
                }
            }
        }
        //System.out.println(Arrays.toString(minD));
        return minD;
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(i==k){
                list[a].add(new int[] { b,1});
                list[b].add(new int[]{a,1});
                start = a;
                end = b;
            }
            else{
                list[a].add(new int[] { b,0});
                list[b].add(new int[]{a,0});
            }
        }
        int[] srr = dijk(start);
        if(srr[end]==0){
            System.out.println(0);
            return;
        }
        int[] err = dijk(end);

        int left = 0;
        int right = 0;
        for(int i = 1;  i <= n; i++){
            if(srr[i]==1)left++;
            if(err[i]==1)right++;
        }

        

        System.out.println(1L*right*left);
        

    }
}