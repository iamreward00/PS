import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
public class Main {


    public static void main(String[] args) throws Exception {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int stack_num = 1;

        ArrayList<String> answer = new ArrayList<>();

        while (stack_num <= N) {

            stack.push(stack_num);
            answer.add("+");
            stack_num++;
            while (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                idx++;
                answer.add("-");
            }
            if (idx == N) {
                break;
            }
        }
        if (idx < N) {
            System.out.println("NO");
        }
        else{
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
        br.close();
    }
}