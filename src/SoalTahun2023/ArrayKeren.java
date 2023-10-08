package SoalTahun2023;

import java.util.Scanner;

public class ArrayKeren {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //input nilai N
        int[] nilai = new int[N];
        int[][] nilaiSubsequent = new int[N - 1][];
        for (int i = 0; i < nilai.length; i++) {
            nilai[i] = sc.nextInt();
        }

        int index = 0;
        for (int i = nilai.length; i > 1; i--) {
            nilaiSubsequent[index] = new int[i];
            for (int j = 0; j < i; j++) {
                nilaiSubsequent[index][j] = nilai[j];
            }
            index++;
        }

        int K = nilai.length + 1;
        boolean result;
        for (int i = 0; i < nilaiSubsequent.length; i++) {
            result = false;
            for (int j = 0; j < nilaiSubsequent[i].length; j++) {
                for (int k = 0; k < j; k++) {
                    double akarKuadrat = Math.sqrt(nilaiSubsequent[i][j] * nilaiSubsequent[i][k]);
                    int akarDibulatkan = (int) akarKuadrat;
                    if (akarKuadrat == akarDibulatkan && j != k) {
                        result = true;
                    }
                }
            }
            if (result == true) {
                K--;
            } else if (result != true && K == nilai.length + 1) {
                K = -1;
            }
        }

        System.out.println(K);
    }
}

//test case
//4
//8 3 27 2
//3
//3
//4 4 1
//2
//4
//2 3 5 11
//-1
