import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = false;


    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n][51];
        
        for(int i = 0; i < n; i++) Arrays.fill(arr[i], "-");

        for(int i = 0; i < n; i++){
            String temp = br.readLine()+"-";
            int jdx = 0;
            for(int j = 0; j < temp.length()-1; j++){
                if(!(jdx < temp.length()-1)) break;
                char c = temp.charAt(jdx);
                char next = temp.charAt(jdx+1);
                String a = c+"";
                if(c == '-' || c==' ') break;;
                if(c=='n' && next =='g'){
                    a = "ng";
                }
                
                arr[i][j] = a;
                jdx++;
                if(c=='n' && next =='g') jdx++;

            }

        }
        if(dbg){
            for(int i = 0; i < n; i++){
                System.out.println(Arrays.toString(arr[i]));
            }
        }

        HashMap<String,Integer> map = new HashMap<>();
        String rull = "a b k d e g h i l m n ng o p r s t u w y";
        st = new StringTokenizer(rull);
        int idx = 0;
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            map.put(temp, idx++);
        }
        map.put("-",-1);

        Arrays.sort(arr, (o1, o2) -> {
            int a = map.get(o1[0]);
            int b = map.get(o2[0]);
            for(int i = 0; i < 50; i++){
                if(dbg)System.out.println(a + " 인데요 ???" +  map.get(o1[i]));
                a = map.get(o1[i]);
                b = map.get(o2[i]);
                if(a!=b){
                    break;
                }
            }
            return Integer.compare(a, b);
            } 
            
        );

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 50; j++){
                if(arr[i][j].equals("-")) break;
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

/*
정렬함수에
포문 넣을수있나?
그러면 쉬울거같은데




*/