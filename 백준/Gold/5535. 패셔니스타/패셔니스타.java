import java.util.*;
import java.io.*;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static int[][] memo;
    static int[] arr;
    static int[][] clo;

    static int dfs(int idx, int prv){

        if(idx ==n){
            return 0;
        }
        if(memo[idx][prv] != -1) return memo[idx][prv];
        int max = 0;
        for(int i = 0; i < m; i++){
            int score = 0;
            if(arr[idx] < clo[i][0] || arr[idx] > clo[i][1]) continue;
            if(idx>0){
                score = Math.abs(clo[prv][2] - clo[i][2]);
            }
            max = Math.max(max, dfs(idx+1,i) + score);

        }
        return memo[idx][prv] = max;
    }

    public static void main(String[] args) throws Exception{
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr  = new int[n];
        clo = new int[m][3];
        for(int i = 0; i < n ;i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            clo[i][0] = a;
            clo[i][1] = b;
            clo[i][2] = c;
        }

        memo = new int[202][202];
        for(int i = 0; i < 202 ; i++){
            Arrays.fill(memo[i]   , -1);
        }


        System.out.println(dfs(0,0));


    }
}

/*
흠
같은옷 또입을수있네

흐으으음
그러면 흐으으음 

흐으으으으으으으으음

완탐하면

n 일에 m 번옷 입기

포문 중첩 200번
이거 재귀해야겠네

돌아가는 횟수는 어디보자

이게 음
날짜, 옷 200 200 인데
한번채우는데 200드니까
200 * 200 * 200 이면

쌉 가 능
그러면 음 
가자

[날짜][어제입은거]




*/