


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/// 백준 1766 문제집
/// https://www.acmicpc.net/problem/1766
public class Main {

    /// 이거 위상정렬 하기전에
    /// list 에 다 add 해서 정렬하고
    /// list에 넣고 remove(0 )
    /// 하면 풀수는있을거같은데
    
    static boolean dbg = false;

    static int N,M;
    static boolean[][] vis;
    static ArrayList<Integer>[] list;
    static int[] inD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inD = new int[N+1];
        
        list = new ArrayList[N+1];
        for(int i = 1; i<= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            inD[b]++;
        }

        if(dbg){
            for(int i = 1; i<= N; i++){
                System.out.println(list[i]);
            }
        }

        
        ArrayList<Integer> minlist = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(inD[i] == 0){
                minlist.add(i);
            }
        }
        Collections.sort(minlist);
        while(!minlist.isEmpty()){
            int cur = minlist.remove(0);
            sb.append(cur +" ");
            for(int i : list[cur]){
                inD[i] --;
                if(inD[i] == 0){
                    minlist.add(i);
                    Collections.sort(minlist);
                }
            }

        }
    System.out.println(sb);
    }
}