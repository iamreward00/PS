    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.Arrays;

    public class Main {

        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n*2+1111];
            Arrays.fill(arr, 11111111);
            arr[2] = 1;
            arr[4] = 2;
            arr[5] = 1;

            for(int i = 6; i<= n; i++){
                arr[i] = Math.min(arr[i-5]+1, arr[i-2]+1);
            }
            //System.out.println(Arrays.toString(arr));
            if(arr[n] ==11111111) System.out.println(-1);
            else System.out.println(arr[n]);

        }
    }