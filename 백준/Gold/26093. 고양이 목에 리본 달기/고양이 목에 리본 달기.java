import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static int n,m;
    static int[][] arr;
    static int[] one;
    static int[] two;
    static int[] oneidx;
    
    static int dfs(int idx, int prv){
        if(idx==n) return 0;

        if(one[idx] == -1){
            for (int i = 0; i < m; i++) {
                int totalScore = arr[idx][i] + dfs(idx + 1, i);
                
                if (totalScore >= one[idx]) {
                    two[idx] = one[idx];
                    one[idx] = totalScore;
                    oneidx[idx] = i;
                } 
                else if (totalScore > two[idx]) {
                    two[idx] = totalScore;
                }
            }
        }
        if (prv == oneidx[idx]) {
            return two[idx]; 
        }
        
        return one[idx];

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
            }
        }
        one = new int[n];
        two = new int[n];
        oneidx = new int[n];
        Arrays.fill(one, -1);
        Arrays.fill(two, -1);


        System.out.println(dfs(0,-1));


    }
}

/*
3달전 틀렸던건데
흠


다시보자
난
전혀 완탐하지 않았구나
그리디로 풀었구나

이게 완탐 을하면

이제 그거지

dfs(0,-1) 로해
idx , prv 인거고

처음 고양이가 for문을 통해서
k 까지 탐색을하는데
이제 그 과정에서

dfs(idx+1, k) 하는거야
이게 그러면
처음 호출 한번에 사실상
거거거거거거으이ㅡ이의 다 탐색이됨 
거기서 메모이제이션하면 됨




*/