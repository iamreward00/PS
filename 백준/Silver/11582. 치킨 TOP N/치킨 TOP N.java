import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
boj.ma/11582
치킨 TOP N
*/
public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int ppow = n/m;


        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            
            list.add(arr[i]);
            idx++;
            if(idx==ppow){
                Collections.sort(list);
                for(int j = 0; j < list.size(); j++){
                    sb.append(list.get(j)+" ");
                }
                list = new ArrayList<>();
                idx=0;
            }
        }

        System.out.println(sb);
        


    }
}

/*
치킨집의 맛의 수치를 감소하지 않는 순으로 정렬을 하고 싶었다.
치킨집이 N개



*/