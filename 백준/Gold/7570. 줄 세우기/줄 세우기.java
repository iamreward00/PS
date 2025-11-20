import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     * 줄세우기
     * 이거 분명 1달? 2달안에 풀었던 문제다
     * 줄 서있는거중 하나를
     * 맨 앞이나 맨 뒤로 보내는데
     * 그전에
     * https://atcoder.jp/contests/abc426/tasks/abc426_d
     * 이거랑 비슷한 문제이다
     * 
     * 가장 최소 횟수로 보내야 하니까
     * 위에 링크문제에서는 가장긴연속된 문자열을 찾았던거고 그거기준으로 한건데
     * 
     * 이번문제는
     * 
     * 내뒤에 큰숫자가 나랑 1차이 나야한다 이다
     * 오름차순 정렬이 목표니까
     * 5 2 4 1 3  같은경우에
     * 
     * 2,3 이있으니까
     * 이거 두개는 움직일 필요가없다
     * 여기 사이에 숫자 끼워넣는게 아니니까
     * 
     * 그러니까 이게
     * 기준 하나 잡고 거기 양옆으로 숫자 이동시켜주면 되는거다
     * 그 기준은
     * 1차이 오름차순의 길이이다
     * 
     * 그 길이를
     * 전체에서 빼면 된다
     * 그럼 이걸 어떻게 하냐?
     * 구해야하는건
     * 어떤 숫자인지가 아니라
     * 숫자의 '길이' 인거야
     * 그 길이를 어떻게 구할까?
     * 이중포문으로 할수는있는데 그러면
     * 시간초과남
     * 
     * 세그트리로 해볼까 생각했는데
     * 버블정렬 스왑횟수 찾는거처럼
     * 근데 그게 안되는게
     * 여기는 있고없고가 아니라
     * 순서가 중요함
     * 2 34
     * 2 43 둘이 다름
     * 근데 만약 2 일때
     * 3,4 둘다있네 ? 하면안됨
     * 아무튼 세그는 안됨
     * 그러면 어떻게할수있을까?
     * 
     * 
     * 5 2 4 1 3
     * 
     * 이이렇게있으면
     * 카운팅배열하는거지
     * countarr[5] = 1
     * countarr[2] = 2
     * countarr[4] = 3
     * countarr[1] = 4
     * countarr[3] = 5
     * 
     * 해서
     * 
     * 우리가원하는건 1차이나는것들이니까
     * 위에꺼 인덱스 순서로 바꾸면
     * countarr[1] = 4
     * countarr[2] = 2
     * countarr[3] = 5
     * countarr[4] = 3
     * countarr[5] = 1
     * 
     * 인데
     * countarr[1] < countarr[2]
     * countarr[2] < countarr[3]
     * ... 이런식으로하면
     * 가장 긴 부분수열 길이 알수있음
     * 어떤부분수열?
     * 오름차순이면서
     * 차이가 1나는거
     * 
     * 그 길이만 알면 전체에서 뺴면 되는거임
     * 
     * 
     * 
     */


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[a] = i;
        }
        int count = 1;
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i+1]) count ++;
            else count = 1;
            ans = Math.max(count, ans);
        }
        System.out.println(n-ans);
    }
}