class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        
        String lenstr1 = ""+video_len.charAt(0)+video_len.charAt(1);
        String lenstr2 = ""+video_len.charAt(3)+video_len.charAt(4);
        
        
        int videolen = Integer.parseInt(lenstr1)*60 + Integer.parseInt(lenstr2);
        
        String opstr1 = ""+op_start.charAt(0)+op_start.charAt(1);
        String opstr2 = ""+op_start.charAt(3)+op_start.charAt(4);
        
        
        int opst = Integer.parseInt(opstr1)*60 + Integer.parseInt(opstr2);
        
        String opstr3 = ""+op_end.charAt(0)+op_end.charAt(1);
        String opstr4 = ""+op_end.charAt(3)+op_end.charAt(4);
        int opend = Integer.parseInt(opstr3)*60 + Integer.parseInt(opstr4);
        
        
        String curstr1 = ""+pos.charAt(0)+pos.charAt(1);
        String curstr2 = ""+pos.charAt(3)+pos.charAt(4);
        
        int cur = Integer.parseInt(curstr1)*60 + Integer.parseInt(curstr2);
        
        
        for(String query : commands){
            
            // 오프닝 건뛰
            if(cur>=opst && cur <= opend){
                cur = opend;
            }
            
            // 쿼리
            
            if(query.equals("next")){
                cur = Math.min(videolen,cur+10);
            }
            else{
                cur = Math.max(0,cur-10);
            }
            //오프닝건뛰
            
            if(cur>=opst && cur <= opend){
                cur = opend;
            }
            
            
        }
        
        
        int tt = cur/60;
        int mm = cur%60;
        
        String anstt = ""+tt;
        String ansmm = ""+mm;
        if(tt<10){
            anstt  = 0+anstt;
        }
        if(mm<10){
            ansmm = 0+ansmm;
        }
        
        answer = anstt+":"+ansmm;
        
        return answer;
    }
}

/*

이거를 미리 만들어둘까 흠

이제 행동이
10초전
10호추
오프닝건뛰


오프닝건뛰 -> 시작과 끝에
10초전후 이거는 쿼리에

시간만어캐 잘 해야겠네




*/