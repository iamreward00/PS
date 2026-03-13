import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = true;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m,k;
    static long[] seg;
    static long[] arr;


    static long init(int node , int start, int end){
        if(start == end ){
            return seg[node] = arr[start];
        }
        int mid = (start+end)/2;
        long left = init(node*2, start,mid);
        long right = init(node*2+1, mid+1, end);
        return seg[node] = left+right;
    }

    static long update(int node, int start, int end, int idx, long num){
        if(idx < start || idx > end){
            return seg[node];
        }

        if(start == end ){
            return seg[node] = num;
        }
        int mid = (start+end)/2;
        long left = update(node*2, start, mid, idx, num);
        long right = update(node*2+1, mid+1, end, idx, num);

        return seg[node] = left+right;


    }

    static long get(int node, int start, int end , int targetstart, int targetennd){
        if(start > targetennd || end < targetstart) {
            return 0;
        }

        if(targetstart <= start && end <= targetennd){
            return seg[node];
        }

        int mid = (start+end)/2;
        long left = get( node*2,  start,  mid ,  targetstart,  targetennd);
        long right = get( node*2+1,  mid+1,  end ,  targetstart,  targetennd);

        return left+right;

    }




    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seg = new long[4*(n+1)];
        arr = new long[n+1];
        for(int i = 1; i <= n; i++){
            long a = Long.parseLong(br.readLine());
            arr[i] = a;
        }

        init(1,1,n);
        
        for(int i = 0; i < m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            

            if(a==1){

                update(1, 1, n, b, c);



            }
            else{

                System.out.println(get(1, 1, n, b, (int)c));

            }

        }



    }
}

/*




*/