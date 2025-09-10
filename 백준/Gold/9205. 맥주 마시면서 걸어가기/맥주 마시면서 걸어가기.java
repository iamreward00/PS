import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /// AI X
    /// n 개의 편의점위 치가있음
    /// 현재 위치에서 갈수있냐? 멘헨톤거리가 1000밑이냐? 하면 갈수있음
    /// 갈슁ㅆ는것들 큐에넣고
    /// 큐에넣고...넣고..반복하면서
    /// 끝위치나오면 해피출력하기
    /// 아니면 슬퍼 ㅜㅜ
    /// 


    /// 오랜만에 전역변수없이 ㄱㄱㄱㄱ
    /// 어짜피 bfs 니까~

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++ ){
            int N = Integer.parseInt(br.readLine()); // 편의점 개수
            
            st = new StringTokenizer(br.readLine());
            int stx = Integer.parseInt(st.nextToken());
            int sty = Integer.parseInt(st.nextToken());

            int[][] cu = new int[N][2]; // [i][0] x  [i][0] y
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                cu[i][0] = a;
                cu[i][1] = b;
            }
            st = new StringTokenizer(br.readLine());
            int edx = Integer.parseInt(st.nextToken());
            int edy = Integer.parseInt(st.nextToken());
            boolean[] vis = new boolean[N]; /// i 번째 편의점 방문체큰
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{stx,sty});
            
            boolean check = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int a = cur[0];
                int b = cur[1];
                if( Math.abs(a-edx) + Math.abs(b - edy ) <= 1000){
                    sb.append("happy\n");
                    check = false;
                    break;
                }

                for(int i = 0; i < N; i++){
                    if(vis[i]) continue;
                    if( Math.abs(a-cu[i][0]) +  Math.abs(b-cu[i][1]) > 1000) continue;
                    q.add(new int[] { cu[i][0], cu[i][1]});
                    vis[i] = true;
                }


            }
            if(check) sb.append("sad\n");
        }
        System.out.println(sb);


    }
}