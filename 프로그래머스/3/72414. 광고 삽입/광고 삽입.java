class Solution {

    static int TTS(String time) {
        String[] parts = time.split(":");
        int H = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        int S = Integer.parseInt(parts[2]);
        return H * 3600 + M * 60 + S;
    }
    static String STT(int sec) {
        int H = sec / 3600;
        int M = (sec % 3600) / 60;
        int S = sec % 60;
        
        return String.format("%02d:%02d:%02d", H, M, S);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playSec = TTS(play_time);
        int advSec = TTS(adv_time);

        int[] imos = new int[playSec + 1];

        for (String log : logs) {
            String[] parts = log.split("-");
            int startSec = TTS(parts[0]);
            int endSec = TTS(parts[1]); 
            
            imos[startSec]++;
            imos[endSec]--;
            
        }

        int[] sum = new int[playSec + 1];
        sum[0] = imos[0];
        for(int i = 1; i<= playSec; i++){
            sum[i]= sum[i-1]+imos[i];
        }

        long[] windo = new long[playSec+1];
        windo[0] = sum[0];
        for(int i = 1; i<= playSec; i++){
            windo[i]= windo[i-1]+sum[i];
        }

        long maxsum = windo[advSec]; 
        int maxidx = 0;

        for (int i = 1; i <= playSec - advSec; i++) {
            
            long current_sum = windo[ i + advSec -1] - windo[i-1];
            if (current_sum > maxsum) {
                maxsum = current_sum;
                maxidx = i;
            }
        }

        answer = STT(maxidx);

        return answer;
    }
}
/*
광고삽입이라
저도 중학교때는 광고문구를 쓰는 카피라이터를 꿈꿨지요...아무튼 가봅시다
광고삽입 될 위치를 찾는건가봐요

여러개 광고가 들어오네요
파란선은 광고를 검토중인 '전체 구간'

검은선은 '죠르디'의 동영상을 재생한 구간

빨간선은 공익광고 최적 위치에요 
이때가 사람이 가장 많이 보네요 

"죠르디"의 동영상 재생시간 길이 play_time
공익광고의 재생시간 길이 adv_time
시청자들이 해당 동영상을 재생했던 구간 정보 logs가 매개변수로 주어질 때
시청자들의 누적 재생시간이 가장 많이 나오는 곳에 공익광고를 삽입하려고 합니다

시작 시각 리턴하기 
많은곳이면 빠른곳 리턴하기

ㅇㅋ 문제이해 완료

그러니까 사람이 가장 많이 겹치는 검은선을 찾으면 되는거잖아? 파란선 안에서 

근데 문제가 HH : MM : SS 이거 초단위로 바꾸는거하나
나중에 또 반대로 하는거 하나 하고

검은색 시간들이 전부다 그 파란선 안에있나 무조건?
공익광고 재생시간은 동영상 재생시간보다 짧거나 같게 주어집니다.
ㅇㅋ 맞네

100시간 미만이니까 ㅇㅋ 이걸로 초 잡아도
1시간에 3600 여기 00
360000  36만이네 n 이 ㅇㅋ ㅇㅋ
근데 이거를
어떻게 체크하나면

쭈우우욱 돌면서 여기 겹치는거 몇개? 그렇게 하기에는
죠르디 영상 개수가 
logs 이게 30만 개여서

i 초에 몇개? 하기엔

36만 * 30만 이여서
시간초과가 날거란말이죠 
이게 완탐인데 그러면
어떻게 볼까?


그러니까 저기 36만은 시간 전체 보는거고
30만은 그시간에 대해서 탐색하는건데 이 걸 줄일수있는거죠?
어떻게?
여기서 우리는 imos 를쓰는겁니다 캬
누적합에서 나온 아이디어인데
이걸 쓰는게 세번째네요

이제 시작시간, 끝시간 해서
+1, -1 하고
그 누적힙 쭉만들어

그러면 누적합 배열이 만들어 지는데

이거를 이제 어떻게?
그 슬라이딩 윈도우인데 크기는 공익광고 크기 해서
쫙 훓터 가면서
max 값, 시작시간 하는거지
그 구간의 min 들 중에서 max 
근데 이제 이거 볼떄 한번할떄마다 계산하면 그러니까 
들어오는거 + 나가는거 - 해도 되고
아니면 누적합 해도 괜찮고 뭘해도 좋을듯
일단 ㄱㄱ

자자
imos 를 sum 으로만들면 
sum[i] 는 i 번째 시간에 시청한 사람 수가 나와요

근데 이제 우리가 
구해야하는게
sum[i] .... sum[i+play_time]
인데 이게 너무 길면
매번 n^2 나니까
이것도 누적합 처리하는거에요
헷갈릴뻔했으니까 조심


*/