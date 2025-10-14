import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    /*
     * N 은 100
     * 시간T 10000
     * 비용 M 10000
     * 
     * 최소비용을 구하는 문제
     * 1. 갈수있냐?
     * 2. 갈수있다면 최소비용은 얼마인가?
     * 
     * 이게
     * 경우가 너무 많아
     * n! 나오니까
     * 최적화가 되는가?
     * 순열이니까
     * 백트래킹을 한다면?
     * 근데 최악의 경우는
     * 1만번 돌긴하네? 
     * 시간이 1 이상
     * 돈이 0 이상이니까
     * 아무리 많이 돌아도 1만번 도네?
     * 근데 1만번 도는게 1만개일려나  애매하네
     * 여기도 메모이제이션이 되는가?
     * 흠
     * idx : 건물번호
     * T : 비용
     * M : 시간
     * 
     * 이라고 한다면!
     * 흠
     * 1만 * 1만 * 1만이네
     * 그러면
     * 시간을 바꿔봐야하나
     * 결국 비용따라 가는거니까
     * 근데 ㅇ그럼 없는경우는 어떻게 찾아
     * 최대값이 초기값이면 그거겠지
     * 없는거
     * 그러면 메모이제이션을
     * idx, 비용
     * 으로한다면
     * 저거의 [][] 값은 시간! 이려나?
     * 애매하긴한데
     * 이게 결국 반복문 되는거잖아
     * 간선이 여러개니까
     * 그러면 bfs 쪽으로 완탐을 해본다면?
     * bfs 에 우큐를 넣는다면?
     * 본인이 본인꺼가는경우는없으니까
     * 작성하기전에 생각부터 해보자
     * bfs + 우큐 라면?
     * 간선이 최대 1만개니까
     * 
     * 
     * 
     * 될거같은데
     * 
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        int nn = Integer.parseInt(br.readLine());
        for(int i = 0; i < nn; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // t
            int d = Integer.parseInt(st.nextToken()); // m
            list[a].add(new int[] { b,c,d});
            list[b].add(new int[] { a,c,d});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[2], o2[2]));
        pq.add(new int[] {1,0,0}); // idx, t , m 
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int a = cur[0];
            int time = cur[1];
            int money = cur[2];
            if(money > m) continue;
            if(time > t) continue;
            if(a == n){
                System.out.println(money);
                return;
            }
            for(int i[] : list[a]){
                int aa = i[0];
                int tt = i[1];
                int mm = i[2];
                if(money+ mm > m) continue;
                if(time +tt> t) continue;
                pq.add(new int[]{aa, time + tt, money + mm});
            }
        }
        System.out.println(-1);
    }
}