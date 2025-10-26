import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    /*
     * 이진트리다
     * 
     * 힌지의 등급
     * 하위트리의 금속막대총무게 + 나부터 루트까지 금속막대총무게
     * 
     * 공차의 하중
     * 리프노드까지 오는길에 모든 힌지의 등급의 합? 인가
     * 난 그렇게 이해했어
     * 
     * 최대 공차 하중을 구하는문제
     * 
     * 흠 한번에 되나?
     * 힌지의 등급은 
     * 내 위에꺼 + 내 아래꺼
     * 이거는
     * 위에꺼
     * dfs
     * 아래꺼
     * 하면될거같은데
     * 위에거는 파라메터로 올꺼고
     * 아래꺼는 리턴값으로 올꺼고
     * 
     * 그렇게 모든 노드의 등급을 구하면
     * 이제 탐색하면서 최대값 찾으면 되는거 아닌가?
     * 근데
     * 루트는 어떻게 정하지...?
     * 문제에
     * 부모노드가 없는게 루트라 나와있네
     * 그럼 일단
     * 1. 루트 노드 구하기
     * 2. 힌지 등급 구하기
     * 3. 공차 하중 구하기 
     * 
     * 트리에서 하는 다이나믹 프로그래밍 인가
     * 가주아
     * 
     * 
     */


    static int n;
    static ArrayList<int[]>[] list;
    static int[] grade;
    

    static int dfs(int idx, int weight){
        
        
        int sub = 0;
        for(int[] i : list[idx]){
            int a = i[0];
            int w = i[1];
            int nextww = w + weight;
            sub += w + dfs(a, nextww);
        }
        
        grade[idx] = sub + weight;
        return sub;
    }

    static int max = 0;
    static void find(int idx, int weight){
        max = Math.max(weight,max);
        for(int[] i : list[idx]){
            int a = i[0];
            int w = grade[a];
            find(a,  weight+w);
            
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        boolean[] whoroot = new boolean[n+1];

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[b].add(new int[] {a,c});
            whoroot[a] = true;
        }

        int root = -1;
        for(int i = 1; i <= n; i++){
            if(!whoroot[i]){
                root =  i;
                break;
            }
        }

        // 1번ㅇ ㅘㄴ료
        //System.out.println(root);

        /// 2번 시작 힌지등ㄱ브구하기
        /// 아래꺼 + 내 위에꺼
        grade = new int[n+1];
        dfs(root, 0);
        //System.out.println(Arrays.toString(grade));

        /// 이제 최대값 찾기
        find(root,grade[root]);
        System.out.println(max);

    }
}