import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static boolean check(String st_arr[]){
        for (int i = 0; i < st_arr.length; i++) {
            if(st_arr[i].equals("q")){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        
        String arr[] = new String[st.length()];
        ArrayList<Integer> stack = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            arr[i] = st.charAt(i) + "";
        }

        String ch[] = {"q","u","a","c","k"};
        int cnt = 0;
        boolean bool = false;
        while (true) {
            bool = false;
            if(arr.length%5 != 0){
                break;
            }
            if (check(arr)) {
                break;
            }
            int ch_idx = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i].equals(ch[ch_idx])){
                    stack.add(i);
                    arr[i] = "1";
                    ch_idx++;
                }
                if(ch_idx == 5){
                    ch_idx = 0;
                    for(int k = 0; k < 5; k++){
                        arr[stack.remove(stack.size() - 1)] = "0";
                    }
                    bool = true;
                }
            }
            if(bool){
                cnt++;
            }
        }  

        boolean end = true;
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals("0")){
                end = false;
            }
            
        }
        
        if(end){
            System.out.println(cnt);
        }
        else{
            System.out.println(-1);
        }

        br.close();

    }
}