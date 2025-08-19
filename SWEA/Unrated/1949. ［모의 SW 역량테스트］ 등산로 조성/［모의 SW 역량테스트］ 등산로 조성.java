import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/// SWEA 1949. [모의 SW 역량테스트] 등산로 조성
class Solution
{
	/// 등산로 땅은 N * N 크기
	/// 각 좌표 는 지형의 높이
	/// 등산로는 가장 높은 봉우리에서 시작해야 한다.
	/// 
	/// 등산로는 산으로 올라갈 수 있도록 반드시 높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결이 되어야 한다.
	/// 즉, 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능하다. -> 나보다 '미만' 인곳으로 상하좌우 이동 가능 이네 이거 가장 긴게 언제까지냐? 인거고
	/// 
	/// 긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.
	/// 
	/// 출력해야 할 정답은 만들 수 있는 가장 긴 등산로의 길이이다.
	/// 
	/// 1. 가장 큰 봉우리 위치 찾기 ( 최대 5개임 )
	/// 2. 그 봉오리에서 dfs 탐색 돌려버리기
	/// 3. 근데 dfs 탐색 돌리기 전에 임의의 위치 k번 -1 씩해서 비교 해야함 ㅇㅇ 
	/// 전체 테케 T 산크기 N 그리고 K  그리고 지도정보 
	/// 이거 초기화 잘하셈 테케 여러개라서 ㅇㅇㅇ
	/// ㅇㅋ ㄱㄱ 20:46 start
	/// 와 씨 원트클 ㅋㅋㅋㅋㅋㅋㅋㅋ 나이스
	/// A 형 계섯거라ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	/// 21:17 완
	/// 코드 생각하고 한거하면 얼추 시작 20:30 이라 잡아도
	/// 시간 넉넉하네 캬
	/// 역시 바로 코드 짜면 안되네 생각하고 짜야하네
	/// 계획없이 움직이는건 실패를 계획하는것과 같다
	/// 설계없이 코드를 짜는건 실패를 설계하는것과 같다
	/// 오늘부터 이런 마음가짐으로 살아보겠습니다
	
	static boolean dbg = false; /// 디버그용

	static int N,K,max_high;
	static int[][] arr;
	static int[][] higher;

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int dfs(int idx, int jdx, int lencnt, int prev){
		if(idx >N-1 || idx < 0 || jdx > N-1 || jdx < 0){ // 벗어나면 ㅃㅃ 백트래킹 임
			return 0;
		}
		if(arr[idx][jdx] >= prev){
			if(lencnt > max_high){
				if(dbg) System.out.println("여기는 dfs 종료호출" + lencnt);	
				max_high = lencnt;
			}
			return 0;
		}

		dfs(idx+1,jdx,lencnt+1,arr[idx][jdx]);
		dfs(idx,jdx+1,lencnt+1,arr[idx][jdx]);
		dfs(idx-1,jdx,lencnt+1,arr[idx][jdx]);
		dfs(idx,jdx-1,lencnt+1,arr[idx][jdx]);



		return 0;
	}


	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_c = 1; test_c <= T; test_c ++){
			/// 변수 초기화 먼저
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max_high = 0;
			arr = new int[N][N];
			
			int highigh = 0;
			for(int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] > highigh){
						highigh = arr[i][j];
					}
				}
			}
			higher = new int[5][2];
			
			int highcnt = 0;
			int tempidx = 0;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(arr[i][j] == highigh){
						higher[tempidx][0] = i;
						higher[tempidx][1] = j;
						tempidx++;
						highcnt ++;
					}
				}
			}
			
			for(int high = 0; high < highcnt; high ++){
				
				int a = higher[high][0];
				int b = higher[high][1];
				if(dbg)System.out.println(high);
				for(int i = 0; i < N; i++){
					for(int j = 0; j < N; j++){
						for(int k = 1; k <= K; k++){ /// i,j 임의의 위치 k 빼기 
							if(i==a && b == j) continue;
							
							arr[i][j] -= k;
							dfs(a,b,0,highigh+1);
							arr[i][j] += k;
						}
					}
				}


			}

			if(dbg) for(int i = 0; i < N; i++) System.out.println(Arrays.toString(arr[i]));
			if(dbg) for(int i = 0; i < highcnt; i++) System.out.println(Arrays.toString(higher[i]));





			sb.append("#" +test_c + " " +max_high +"\n");
		}
		System.out.println(sb);
		
	}
}