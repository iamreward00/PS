import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Info implements Comparable<Info>{
        int x, y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo( Info o) {
            if(this.x == o.x)
                return o.y - this.y;
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.offer(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Info first_line = pq.poll();
        int start = first_line.x;
        int end = first_line.y;
        int result = 0;
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            if(cur.x > end){
                result += end - start;
                start = cur.x;	
                end = cur.y;
                continue;
            }
            if(cur.y > end)
                end = cur.y;
        }
        result += end - start;
        System.out.println(result);
        br.close();
    }
}