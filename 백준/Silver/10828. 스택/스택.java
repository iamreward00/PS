import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.StreamTokenizer;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str_arr[] = new String[n];
		LinkedList<Integer> stack = new LinkedList<>();
		
		for( int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			int num_temp = 0;
			
			if(temp.equals("push")) {
				num_temp = Integer.parseInt(st.nextToken());
				stack.add(num_temp);
			}
			
			else if(temp.equals("pop")) {
				if(stack.size() <= 0) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.remove(stack.size()-1));					
				}

			}
			
			else if(temp.equals("size")) {
				System.out.println(stack.size());
			}
			else if(temp.equals("empty")) {
				if(stack.size()==0) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if(temp.equals("top")) {
				if(stack.size()<=0) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.get(stack.size()-1));					
				}

			}
			

			
		}

		
		
	}
}
