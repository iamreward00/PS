import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new java.util.HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, 1);
        }
        for (int i = 0; i < M; i++) {
            String name2 = br.readLine();
            if( map.containsKey(name2)) {
                list.add(name2);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String name : list) {
            System.out.println(name);
        }
        br.close();
    }
}