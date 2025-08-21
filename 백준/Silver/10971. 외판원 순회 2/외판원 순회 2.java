


/// 백준 10971 외판원 순회 2
/// https://www.acmicpc.net/problem/10971

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /// 외판원 순회 문제는 영어로 Traveling Salesman problem (TSP) 라고 불리는 문제로 
    /// comp uter science 분야에서 가장 중요하게 취급되는 문제 중 하나이다.
    /// 여러 가지 변종 문제가 있으나, 여기서는 가장 일반적인 형태의 문제를 살펴보자.
    /// 
    /// 1번부터 N번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다.
    /// 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획하려고 한다.
    /// 단, 한 번 갔던 도시로는 다시 갈 수 없다. 
    /// 가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
    /// N 최대가 10이여서 2^10 은 1024 여서 여유롭게 완전탐색할수있다
    /// 순열 nPn 하면 다 구할수있다! 

    static boolean dbg = false;
    
    static int N;
    static int[][] map;
    static int[] nums;  
    static boolean[] vis;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int min = 999999999;
    static int dfs(int idx){
        if(idx == N){
            int sum = 0;
            boolean check = true;
            for(int i = 0; i < N; i++){
                if(map[nums[i%N]][nums[(i+1)%N]] == 0){
                    check = false;
                    return 0;
                }
                
                sum += map[nums[i%N]][nums[(i+1)%N]];
            }
            if(check){
                min = Math.min(min, sum);
            }

            return 0;
        }

        for(int i = 0; i < N; i++){
            if(vis[i]) continue; 
            vis[i] = true;
            nums[idx] = i;
            dfs(idx+1);
            vis[i] = false;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        nums = new int[N];
        vis = new boolean[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(dbg){
            for(int i = 0; i < N; i++){
                System.out.println(Arrays.toString(map[i]));
            }
        }

        dfs(0);
        System.out.println(min);

    }
}