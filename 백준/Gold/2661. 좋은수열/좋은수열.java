import java.io.BufferedReader;
import java.io.InputStreamReader;



/// 백준 2611 좋은수열
/// https://www.acmicpc.net/problem/2661
public class Main {

    /// 나올수있는수느 1,2,3 중
    /// 이게 좋은수열인지 확인하면서 가지치면서 가면될듯?
    /// 
    static int N;

    static int dfs(int idx, String str){

        if(!check(str)){
            return 0;
        }

        if(idx==N){
            System.out.println(str);
            System.exit(0);
            return 0 ;
        }


        dfs(idx+1, str+"1");
        dfs(idx+1, str+"2");
        dfs(idx+1, str+"3");

        return 0;
    }

    static boolean check(String str){
        int len = str.length();

        for(int i = 1; i <= len/2; i++){
            String f = str.substring(len- (2*i), len-i);
            String b = str.substring(len-i, len);
            if(f.equals(b)){
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0,"");
    }
}