import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
public class Main {


    public static void main(String[] args) throws Exception {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        for (int i = 0; i < N - 1; i++) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
        br.close();
    }
}