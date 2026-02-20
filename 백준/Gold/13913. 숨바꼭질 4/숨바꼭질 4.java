import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] vis = new boolean[300000];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n,0});
        vis[n] = true;

        int[] path = new int[300000];
        Arrays.fill(path, -1);

        int[] aa = {1,1,2};
        int[] bb = {-1,1,0};

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int a = cur[0];
            int cnt = cur[1];

        

            if(a==m){
                System.out.println(cnt);

                Stack<Integer> stack = new Stack<>();
                int temp = m;
                while(temp!=n){
                    stack.push(temp);
                    temp = path[temp];
                }
                stack.push(n);

                while(!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }
                System.out.println(sb);

                break;
            }

            for(int i = 0; i < 3; i++){
                int next = aa[i]*a + bb[i];
                if( next > 222200 || next < 0 || vis[next] ) continue;
                queue.add(new int[] {next, cnt+1});
                vis[next] = true;
                path[next] = a;
                
            }
        }

    }
}

/*
이거는 음
역추적을 해야하네
어떻게하나~
우리만남은
빙글빙글돌고




*/