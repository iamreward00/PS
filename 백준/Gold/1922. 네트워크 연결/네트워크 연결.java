import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> list = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        for(int i = 0; i<N+1; i++)
            list.add(new LinkedList<>());

        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.get(A).add(new Node(B, val));
            list.get(B).add(new Node(A, val));
        }

        PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        for(int i = 0; i<list.get(1).size(); i++)
            que.offer(list.get(1).get(i));
        visited[1] = true;
        int sum = 0;

        while(!que.isEmpty()){
            Node a = que.poll();

            if(visited[a.n])
                continue;

            visited[a.n] = true;
            sum += a.weight;
            for(int i = 0; i<list.get(a.n).size(); i++)
                que.offer(list.get(a.n).get(i));
        }

        System.out.println(sum);
    }
}
class Node
{
    int n,weight;

    public Node(int n, int weight)
    {
        this.n = n;
        this.weight = weight;
    }
}