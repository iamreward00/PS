import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int N,M;
    static String[] str_arr;
    static ArrayList<String> list = new ArrayList<>();
    static String answer = "";
    static char[] strings = {'a','e','i','o','u'};

    static boolean check(char ch){
        for(int i = 0; i < strings.length; i++){
            if(ch == strings[i]){
                return true;
            }
        }
        return false;
    }

    static void dfs(int idx, String str){
        if(str.length()==N){
            int mo = 0;
            int ja = 0;
            for(int i = 0; i < N; i++){
                if(check(str.charAt(i))){
                    mo++;
                }
                else{
                    ja++;
                }
            }
            if(mo>=1 && ja>=2){
                list.add(str) ;
            }
            return;
        }
        if(idx>=M){
            return;
        }

        dfs(idx+1, str);
        dfs(idx+1, str + str_arr[idx] );
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        str_arr = new String[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++){
            str_arr[i] = st.nextToken();
        }
        Arrays.sort(str_arr);
        dfs(0,"");
        // System.out.println(answer);
        Collections.sort(list);
        for (String str : list) {
            System.out.println(str);
        }
        
    }
}
