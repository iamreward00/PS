import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new LinkedList<>();
    int back = 0;
    for (int i = 0; i < n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        if(command.equals("push")){
            int num = Integer.parseInt(st.nextToken());
            queue.add(num);
            back = num;
          
        }
        else if(command.equals("pop")){
            if(queue.isEmpty()){
                System.out.println(-1);
            }
            else{
                System.out.println(queue.poll());
            }
          
        }
        else if(command.equals("size")){
            System.out.println(queue.size());
          
        }
        else if(command.equals("empty")){
            if(queue.isEmpty()){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
        else if(command.equals("front")){
            if(queue.isEmpty()){
                System.out.println(-1);
            }
            else{
                System.out.println(queue.peek());
            }
        }
        else if(command.equals("back")){
            if(queue.isEmpty()){
                System.out.println(-1);
              
            }
            else{
                System.out.println(back);
            }
          
        }
          
  
      
    }
    
    


    
    
  }

}