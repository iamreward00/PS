import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		int temp = 0;
        StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> temp_map = new HashMap<>();
		for(int j = 1; j <= 20; j++) {
			temp_map.put(j, 1);
		}

        for( int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("add")) {
				temp = Integer.parseInt(st.nextToken());
				map.put(temp, 1);
			}
			
			else if(str.equals("remove")) {
				temp = Integer.parseInt(st.nextToken());
				if(map.containsKey(temp)) {
					map.remove(temp);					
				}
			}
			
			else if(str.equals("check")) {
				temp = Integer.parseInt(st.nextToken());
				sb.append(map.containsKey(temp) ? 1 : 0).append("\n");
			}
			
			else if(str.equals("toggle")) {
				temp = Integer.parseInt(st.nextToken());
				if(map.containsKey(temp)) {
					map.remove(temp);
				}
				else {
					map.put(temp, 1);
				}
			}
			else if(str.equals("all")) {
                map = new HashMap<>(temp_map);
			}
			else if(str.equals("empty")) {
				map = new HashMap<>();
			}
			
		
			
		}
		
		br.close();
        System.out.print(sb.toString()); 
	}
}