import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited;
    static int ans = 100000;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[ans + 1];
        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{N, 0});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int pos = temp[0];
            int time = temp[1];
            visited[pos] = true;

            if(pos == K) {
                ans = Math.min(ans, time);
            }
            if(pos *2 <= ans && !visited[pos * 2]) {
                queue.offer(new int[]{pos * 2, time});
            }
            if(pos + 1 <= ans && !visited[pos + 1]) {
                queue.offer(new int[]{pos + 1, time + 1});
            }
            if(pos - 1 >= 0 && !visited[pos - 1]) {
                queue.offer(new int[]{pos - 1, time + 1});
            }



        }

    
    }
}
