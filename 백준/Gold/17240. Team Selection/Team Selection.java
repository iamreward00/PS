
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    /*
    
    PPC 라는게임이네요
    A, B, C, D, E 총 5개의 역할군
    후보자는 총 n명이 있다
    각 역할군의 실력 이 ai, bi, ci, di, ei로 주어지며
    실력은 0에서 1000 사이의 정수

    n은 2만개

    사람, 후보? 해서 해야하나

    아 이거
    알파벳
    그러니까
    완탐이
    선택하고 안하고인데

    이거 그 머냐
    상태를 어떻게 나타내냐면
    그걸 11111 이걸로
    비트마스킹으로 나타내냐면
    배열에 저장할수있긴함

    그러니까 
    사람 idx
    abcde 체크하는 11111 가 최대인 비트마스크 숫자

    이차원 디피가되는거지


    */

    static int n;
    static int[][] arr;
    static int[][] memo;

    static int dfs(int idx, int bit){

        if(bit == (1<<5)-1 ){
            return 0;
        }
        if( idx == n){
            return -1999999999;
        }

        if(memo[idx][bit] != -1) return memo[idx][bit];


        int a = dfs(idx+1, bit);

        for(int i = 0; i < 5; i++){
            if((bit & 1<<i) == 0){
                a = Math.max(a, dfs(idx+1, bit | 1<<i) + arr[idx][i]);
            }
        }
        
        memo[idx][bit] =a;
        return memo[idx][bit];


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][5];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
            arr[i][3] = d;
            arr[i][4] = e;

        }
        memo = new int[n][1<<5];
        for(int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        System.out.println(dfs(0,0));


    }
}