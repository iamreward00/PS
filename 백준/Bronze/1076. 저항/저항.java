import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 색상 순서에 따라 값과 곱을 배열로 정의
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        
        // 배열을 리스트로 변환하여 indexOf 메소드를 쉽게 사용
        List<String> colorList = Arrays.asList(colors);

        // 세 개의 색상 입력 받기
        String firstColor = br.readLine();
        String secondColor = br.readLine();
        String thirdColor = br.readLine();

        // 첫 번째와 두 번째 색상의 값 찾기
        String valueStr = "" + colorList.indexOf(firstColor) + colorList.indexOf(secondColor);
        
        // 문자열로 합쳐진 값을 long으로 변환
        long value = Long.parseLong(valueStr);

        // 세 번째 색상의 인덱스를 찾아 10의 거듭제곱으로 곱셈 값 계산
        long multiplier = (long) Math.pow(10, colorList.indexOf(thirdColor));
        
        // 최종 저항값 계산
        long resistance = value * multiplier;

        // 결과 출력
        System.out.println(resistance);
    }
}