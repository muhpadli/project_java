package SoalTahun2023;

public class Test {

    public static void main(String[] args) {
        
        System.out.println(solution("011100"));
    }

    private static int solution(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                double k = Math.pow(2, i);
                sum += k;
            }
        }
        return sum;
    }
}
