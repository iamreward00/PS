import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



/// 백준 16401 - 과자 나눠주기
/// https://www.acmicpc.net/problem/16401
public class Main {

    /// 사람이 N 명
    /// 과자가 M 개
    /// 얼만큼 잘라야 가장 크게 N 명이 다 먹을 수 있냐????
    

    static boolean dbg = false; /// 디버깅용

    static int N,M;
    static int[] arr;
    static int max = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static boolean check(int num){
        int sum = 0;
        for(int i = 0; i < M; i++){
            sum += arr[i]/num;
        }
        if(sum >= N){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = 1000000000;

        while(left <= right){
            int mid = (left+right)/2;
            if(check(mid)){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(left -1);
        

    }
}
