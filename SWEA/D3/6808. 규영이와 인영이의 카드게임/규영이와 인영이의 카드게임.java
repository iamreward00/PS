import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1 3 5 7 9 11 13 15 17 가 입력일때 규영이가 이렇게 내는게 고정임
// 남은숫자 9개로 만들수있는 있는 모든 경우를 찾아서 순서상관있고 중복 x -> 순열
// 길이가 9 일때 for문돌려서 점수 비교 하고 카운트 하나씩 올려주면 될거같은데
// 테케 T, arr배열, 그리고 이제 내 카드 내는거모음 cards 배열 ㄱㄱ 중복x라 방문체크도 필요함


class Solution
{
    static int[] arr; // 입력받을배열
    static int[] nums; // 순열탐색용배열
    static boolean[] vis; // 중복체크, 방문체크
    static int acnt; // arr 이이겼을때 점수
    static int bcnt;  // nums 가이겼을때 점수 카운트
    static int max;
    static StringTokenizer st;

    public static int dfs(int cnt){ 
        if(cnt == 9){// cnt 는 개수임 숫자들의 개수 이게 9일때 check 하면됨
            //여기서 이제 체크 탐색용 배열 nums 
            //높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
            // 이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.
            // 두 사람의 총점이 같으면 무승부이다.
            int asum = 0;
            int bsum = 0;
            for(int i = 0; i < 9; i++){
                if(arr[i] > nums[i]){// nums[i] 랑 arr[i] 랑 비교
                    asum += arr[i] + nums[i];
                }
                else if(arr[i] < nums[i]){
                    bsum += arr[i] + nums[i];
                }
            }

            if(asum>bsum){
                acnt++;
            }
            else if(bsum> asum){
                bcnt++;
            }

            return 0;
        }

        for(int i = 1; i <= 18; i++){ // 배열은 숫자카드의 값이라 i = 1 부터 18까지 감
            if(vis[i]) continue; // 여기서 첨부터 들어오지 않아서 main에서 true 한애들 그래서 아마 찾지도않고 원복도안할듯?
            nums[cnt] = i;
            vis[i] = true;
            dfs(cnt+1);
            vis[i] = false;
        }


        return 0;
    }

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            arr = new int[9];
            nums = new int[9];
            vis = new boolean[19]; //  숫자 총 18개 여서 + 1 해서 19 
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++){
                arr[i] = Integer.parseInt(st.nextToken()); // 한줄입력받기 
                vis[arr[i]] = true; // 방문체크 미리 해두기 - 입력이 아닌 숫자들 어떻게 확인하지? 하다가 방문체크 다 true 해두고 false 로 안돌리면 될거같아서 해봄
            }

            //이제 변수 초기화 하고 탐색 시작
            max = 0;
            acnt = 0;
            bcnt = 0;
            dfs(0);

            //출력 만들기 스트링빌더
            sb.append("#"+t+" "+acnt+" "+bcnt+"\n");

        }
        System.out.println(sb);

    }
}
// 4
// 1 3 5 7 9 11 13 15 17
// 18 16 14 12 10 8 6 4 2
// 13 17 9 5 18 7 11 1 15
// 1 6 7 9 12 13 15 17 18