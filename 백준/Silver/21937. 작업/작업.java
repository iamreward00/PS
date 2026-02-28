import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     * 14:30 시작
     * 작업
     * 작업 N 개임
     * 순서도임
     * 5번 하기위해선4번해야하고
     * 4번하기위해선 2번해야함
     * 3은 바로 가능
     * 아
     * 
     * 오늘 X 해야함
     * X 하기위해 먼저 해야하는 작업의 개수를 구하는문제
     * 
     * 5를 하기위해선
     * 2,4 2개
     * 3을 하기위해선 1개
     * 6을 하기위해선 3개 네요
     * 
     * 그냥 탐색하면 되는거아닌가
     * 방향 역으로 돌려가지고
     * 뭐없는거같은데
     * 
     * 이게 사이클이 존재할수있나요
     * 그래도 상관없는거같은데 그림그려보면
     * 방문체크는 필요하겠는데
     * N이 10만개
     * 간선이 200000 개
     * 바로 되겠는데
     * 
     * X에서 이제 뻗어나가는 탐색하면 나올거같아요 
     * 
     */


     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }
        int target = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        queue.add(target);
        vis[target] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : list[cur]){
                if(vis[i]) continue;
                cnt++;
                queue.add(i);
                vis[i] = true;
            }
            
        }
        System.out.println(cnt);


    }
}
