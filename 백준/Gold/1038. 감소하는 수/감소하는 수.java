import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static ArrayList<Long> list2 = new ArrayList<>(); // 왜 Long 인지 생각 다시
    static HashSet<Long> set = new HashSet<>();
    static void dfs(int idx, String str,int cnt){
        
        if(cnt==10 && str.length()>0){
            
            list2.add(Long.parseLong(str));
            return;
        }
        
        if(idx>=10){
            return;
        }

        dfs(idx+1, str ,cnt + 1);
        dfs(idx+1,str+(arr[idx]+""),cnt + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dfs(0,"",0);
        
        Collections.sort(list2);
        if(N >= list2.size()){ // 왜 같아야함?
            System.out.println(-1);
        }
        else{
            System.out.println(list2.get(N));

        }

        
    
    }
}
