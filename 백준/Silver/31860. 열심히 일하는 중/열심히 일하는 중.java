import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /// 수가 작은 ㅣ충분히 완탐 가능
    /// N 일의개수
    /// M 중요도 감소 수치
    /// K k 이상일때 일 완료한거
    /// 중요도 높은 일부터 처리
    /// 만족도는 전날 만족감 Y
    /// 처리 한 일 중요도 P
    /// y/2 + P
    /// 우큐하고 while 돌리면될꺼같은데?
    /// 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            pq.add(a);
        }
        int Y = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur <= K) continue; 
            Y = cur + (Y/2);
            list.add(Y);
            cur -= M;
            if(cur <= K) continue;
            pq.add(cur);
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        System.out.println(size);
        for(int i : list){
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}