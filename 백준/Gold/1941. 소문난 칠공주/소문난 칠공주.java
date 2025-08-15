import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



/// 백준 1941 소문날 칠공주
/// https://www.acmicpc.net/problem/1941
public class Main {

    /// 25개중 7개 선택하(조합)
    /// 가로나 세로로 인접해야함
    /// 이다솜파가 4명이상이여야함
    /// 기능 3개
    /// 일단 조합 골라
    /// 그리고 이다솜4명 이상확인
    /// 그리고 가로 세로 인접확인
    /// ㄱㄱㄱㄱㄱ
    
    
    /// 7개 선택하기 i/5  j%5 하면될듯?
    
    static char[][] arr; /// 5*5 고정
    static int[] nums; // 7개 고정
    static int cnt = 0;
    static int dfs(int idx, int start){ /// idx 는 선택된 수의개수 start는 24까지가면되겠네
        
        if(idx == 7){
            /// 여기서 이다솜파 4명인지 && 가로세로 인접확인 ㄱㄱ
            if(!over4()){
                return 0;
            }
            
            if(!bfs()){
                return 0;
            }
            cnt++;
            return 0;
        }



        for(int i = start; i < 25; i++){
            nums[idx] = i;
            dfs(idx+1,i+1);
        }

        return 0;
    }

    static boolean over4(){ /// 4명이상??
        int sum = 0;
        for(int i = 0; i < 7; i++){
            int idx = nums[i]/5;
            int jdx = nums[i]%5;
            if(arr[idx][jdx] == 'S'){
                //System.out.println("야");
                sum ++;
            }
        }
        if(sum >=4){   
            return true;
        }
        else{
            return false;
        }
    }

    static boolean bfs(){

        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[26];
        
        queue.add(nums[0]);
        vis[nums[0]] = true;
        int sum = 1;
        while(!queue.isEmpty()){ /// 여기서 십자탐색 해야함
            int temp = queue.poll();
            int idx = temp/5;
            int jdx = temp%5;
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,-1,1};
            for(int i = 0; i< 4; i++){
                int nx = idx + dx[i];
                int ny = jdx + dy[i];
                int xy = nx*5 + ny;
                if(nx <0 || nx >= 5 || ny<0 || ny>=5) continue;
                if(vis[xy]) continue;
                // System.out.println(nx+"     xdfgasdf"+ny);
                for(int j = 0; j < 7; j++){
                    if(nums[j] == xy){
                        vis[nums[j]] = true;
                        queue.add(nums[j]);
                        sum ++;
                    }
                }
            }
        }
        if(sum == 7){
            return true;
        }
        return false;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = new int[7];
        arr = new char[5][5];
        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            for(int j = 0; j < 5; j++){
                arr[i][j] = str.charAt(j);
            }
        }


        dfs(0,0);
        System.out.println(cnt);



    }
}