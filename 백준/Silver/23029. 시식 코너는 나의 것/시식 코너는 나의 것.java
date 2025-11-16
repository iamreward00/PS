import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
     * 가톨릭대학교
     * N 개의 시식콘커
     * 
     * 최대한 많은양
     * 연속 3개 방문 못함
     * 
     * 연속 2개할경우 1/2 밖에 못ㅁ거음
     * 0개인 음식코너 존재
     * 
     * 먹을수있는 최대개수
     * 
     */


    static int n;
    static int[] arr;
    static int[][] memo;
    

    static int dfs(int idx, int cnt){

        if(idx == n ) return 0;

        if(memo[idx][cnt] != -1) return memo[idx][cnt];
        int a = 0;
        if(cnt == 0){
            a = Math.max(a, dfs(idx+1, 1)) + arr[idx];
            a = Math.max(a, dfs(idx+1, 0)) ;
        }
        else if(cnt == 1){
            a = Math.max(a, dfs(idx+1, 2)) + arr[idx]/2;
            a = Math.max(a, dfs(idx+1, 0)) ;
        }
        else if(cnt == 2){
            a = Math.max(a, dfs(idx+1, 0)) ;
        }
        
        return memo[idx][cnt] = a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = Integer.parseInt(br.readLine());
        memo = new int[n][3];
        for(int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        System.out.println(dfs(0,0));

    }
}