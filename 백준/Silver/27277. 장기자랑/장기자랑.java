import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
        }

        Collections.sort(list);
        
        int start = list.remove(list.size()-1);
        int[] arr = new int[n];
        arr[0] = start;
        for(int i = 1; i < n; i++){
            int cur = 0;
            if(i%2==1){
                cur = list.remove(0);
            }
            else{
                cur = list.remove(list.size()-1);
            }
            arr[i] = cur;
        }

        int sum = arr[0];
        for(int i = 1; i < n; i++){
            sum += Math.max(0,arr[i]-arr[i-1]);
        }
        
        System.out.println(sum);

        

    }
}

/*

와 설날 부대에서 장기자랑이라니
좀 불쌍하네요
아무래도 앞에 공연한 사람이 너무 잘하면 뒤에 공연하는 사람이 부담감을 느껴 본 실력을 발휘하지 못할 것이라는 고민을 하게 되었다.

부대에서
고민이란걸 하네요 ? 

가장 먼저 공연하는 병사는 본인의 실력을 그대로 발휘할 수 있다.

max(0, ai-a(i-1))
만큼만 발휘할수있네요 ?

흠
내점수 - 앞에사람 점수 인데 
그러면 흠

1 2 3 4 5

이게 음

3 2 4 1 5  

3 0 2 0 5 긴한데


작은수 -> 큰수 일때만 이득인데

흠

6 1 5 2 4 3  이면 되는거아님?



*/