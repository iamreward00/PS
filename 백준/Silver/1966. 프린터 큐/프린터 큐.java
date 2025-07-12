import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {


    public static void main(String[] args) throws Exception {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer[] = new int[T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Queue<Integer> queue = new java.util.LinkedList<>();
            for (int j = 0; j < N; j++) {
                queue.add(j);
            }
            int cnt = 0;
            boolean found = false;
            while (queue.size() > 0 && !found) {
                int max_num = 0;

                for (int j = 0; j < N; j++){
                    if(arr[j] >= max_num) {
                        max_num = arr[j];
                    }
                }



                while (true){
                    if(max_num == arr[queue.peek()]){
                        if (queue.peek() == M) {
                            cnt++;
                            found = true;
                            break;
                        }
                        arr[queue.peek()] = -1;
                        queue.poll();
                        cnt++;
                        break;
                    }
                    
                    else {
                        queue.add(queue.poll());
                    }
                }
                if(queue.size() == 0) {
                    break;
                }

            }
            answer[i] = cnt;


        }
        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
        br.close();
    }
}