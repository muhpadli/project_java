package SoalTahun2023;

import java.util.Scanner;

public class MinES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] listIndex = {'A', 'B', 'C', 'D'};

        String[][] tabel1 = {
            {"AB", "DC", "CC", "CB"},
            {"CA", "DA", "CD", "DD"},
            {"BC", "AA", "BA", "DB"},
            {"BD", "AD", "BB", "AC"}
        };

        String[][] tabel2 = {
            {"CD", "BB", "AC", "CC"},
            {"CB", "DB", "AD", "DD"},
            {"DA", "DC", "BC", "BD"},
            {"AA", "BA", "CA", "AB"}
        };

        String pesan = sc.nextLine();
        if (pesan.length() % 2 == 0) {
            for (int i = 0; i < pesan.length(); i += 2) {
                String karakter = pesan.substring(i, i + 2);
                int index1 = 0;
                int index2 = 0;

                boolean run = true;
                int j = 0;
                while (run) {
                    for (int k = 0; k < tabel2[j].length; k++) {
                        if (karakter.equalsIgnoreCase(tabel2[j][k])) {
                            index1 = j;
                            index2 = k;
                            karakter = listIndex[j] + "" + listIndex[k];
                            run = false;
                            break;
                        }
                    }
                    j++;
                }

                run = true;
                j = 0;
                while (run) {
                    for (int k = 0; k < tabel1[j].length; k++) {
                        if (karakter.equalsIgnoreCase(tabel1[j][k])) {
                            index1 = j;
                            index2 = k;
                            karakter = listIndex[j] + "" + listIndex[k];
                            run = false;
                            break;
                        }
                    }
                    j++;
                }
                System.out.print(karakter);
            }
        }
        System.out.println("");
    }
}
