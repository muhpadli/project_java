package SoalTahun2023;

import java.util.HashSet;
import java.util.Scanner;

public class EsKopiBoba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> daftarAngkaUnik = new HashSet<>();
        if (N >= 1 && N <= 1000) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int indexMin = 0;
            int indexMax = 0;
            for (int i = 0; i < N; i++) {
                int bilangan = sc.nextInt();
                daftarAngkaUnik.add(bilangan);
                sum += bilangan;
                if (bilangan < min) {
                    min = bilangan;
                    indexMin = i + 1;
                }
                if (bilangan > max) {
                    max = bilangan;
                    indexMax = i + 1;
                }
            }

            if (daftarAngkaUnik.size() == 1) {
                System.out.println("SESUAI");
            } else if (daftarAngkaUnik.size() <= 3 && sum % N == 0) {
                System.out.println((max - min) / 2);
                System.out.println(indexMax);
                System.out.println(indexMin);
            } else {
                System.out.println("TIDAK SESUAI");
            }
        }

    }
}
