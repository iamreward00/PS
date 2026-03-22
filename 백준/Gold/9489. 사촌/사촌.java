import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static int[] arr;
    static int[] tree ;
    static int targetidx ;

    public static void main(String[] args) throws Exception{
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n==0 && m==0) break;

            arr = new int[n]; 
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int a = Integer.parseInt(st.nextToken());
                arr[i] = a;
                if(a==m){
                    targetidx=i;
                }
                
            }

            
            
            tree = new int[1111]; // 0 = 부모 , 1 = 랭크 ? 해서 완탐 돌리면 될듯
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            queue.add(0); // 하나더넣어두면 편할듯?
            int last = -111;
            for(int i = 1; i < n; i++){
                int cur = arr[i];
                if(cur-last != 1){
                    queue.poll();
                }
                int peek = queue.peek();
                tree[i] = peek;
                queue.add(i);
                last = cur;
            }
            
            tree[0] = -1;
            
            int cnt = 0;

            if(targetidx > 0 && tree[targetidx] > 0){
                int a = tree[targetidx];
                int aa = tree[a];
                for (int i = 0; i < n; i++) {
                    int b = tree[i];   
                    if (b != -1 && tree[b] != -1) { 
                        int bb = tree[b];     
                        if (a != b && aa == bb) {
                            cnt++;
                        }
                    }
                }
            }
            sb.append(cnt +"\n");
        }
        System.out.println(sb);


    }
}

/*
트리로 구현하기만 하면
트리탐색으로 쉽게할거같은데

트리로 어떻게 잘 만드는지가 관건인거같아요

큐를 써볼까요?

일단 1이 들어와

그다음 루트 노드+1보다 크다.

그러면 첫수는 무조건 루트네요 ?

그다음 이제 연속된게 만약 3 4 가 들어왔다가 다음에 7 들어온다면 ? 음 
만약 이전과 연속이지 않다면 지금 현재 큐를 빼버리는거지 그리고 그다음 peek 로 이제 계속 넣으면 될거같은데요 ? 

그러니까

1 3 4 7 8 10  이라면

처음에 큐에
1
들어옴
그다음 3
1 3
근데 이제 그 리스트에 1.add 3 하는거지
그다음 4 들어오면 연속된숫자네? 하면서 1.add 4 하고 큐삽임

현재큐 1 3 4

그다음 7인데
연속이아니네? 
현재 큐 poll
그다음 peek 에 (3)
3.add 7

이거 반복하면서 만들면 될듯 ?




*/