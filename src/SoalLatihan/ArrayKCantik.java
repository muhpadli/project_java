package SoalLatihan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ArrayKCantik {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] daftarBilangan = new int[N];
        HashSet<Integer> bilUnik = new HashSet<>();
        ArrayList<ArrayList<Integer>> kCantik = new ArrayList<>();

        if (N >= 1 && N <= 200000) {
            for (int i = 0; i < N; i++) {
                int bilangan = sc.nextInt();
                daftarBilangan[i] = bilangan;
                bilUnik.add(bilangan);
            }
            ArrayList<Integer> bilUnikFinal = new ArrayList<>(bilUnik);

            for (int i = 0; i < bilUnikFinal.size(); i++) {
                ArrayList<Integer> subKCantik = new ArrayList<>();
                for (int j = 0; j < daftarBilangan.length; j++) {
                    if (bilUnikFinal.get(i) == daftarBilangan[j]) {
                        subKCantik.add(daftarBilangan[j]);
                    }
                }
                kCantik.add(subKCantik);
            }

            for (int i = 0; i < daftarBilangan.length; i++) {
                int bilMinimal = i + 1;
                ArrayList<Integer> bilMemenuhi = new ArrayList<>();
                ArrayList<Integer> bilBelumMemenuhi = new ArrayList<>();
                int sumOperasi = 0;
                int sisa = daftarBilangan.length;
                for (int j = 0; j < kCantik.size(); j++) {
                    if (kCantik.get(j).size() >= bilMinimal) {
                        sisa = sisa - bilMinimal;
                        for (int k = 0; k < bilMinimal; k++) {
                            bilMemenuhi.add(kCantik.get(j).get(0));
                        }
                    } else {
                        bilBelumMemenuhi.add(kCantik.get(j).get(0));
                    }
                }

                int jmlBilSisa = bilBelumMemenuhi.size();
                
                for (int j = 0; j < jmlBilSisa ; j++) {
                    int totalBil = 0;
                    int jmlBil = Integer.MIN_VALUE;
                    int index = 0;
                    for (int k = 0; k < bilBelumMemenuhi.size(); k++) {
                        totalBil = 0;
                        for (int l = 0; l < kCantik.size(); l++) {
                            for (int m = 0; m < kCantik.get(l).size(); m++) {
                                if (bilBelumMemenuhi.get(k) == kCantik.get(l).get(m)) {
                                    totalBil++;
                                }
                            }
                        }

                        if (totalBil > jmlBil) {
                            index = k;
                            jmlBil = totalBil;
                        }
                    }
                    
                    if (sisa >= (jmlBil + (bilMinimal - jmlBil))) {
                        sisa -= jmlBil;
                        for (int k = 0; k < jmlBil; k++) {
                            bilMemenuhi.add(bilBelumMemenuhi.get(index));
                        }
                        
                        for (int k = 0; k < (bilMinimal - jmlBil); k++) {
                            bilMemenuhi.add(bilBelumMemenuhi.get(index));
                            sisa--;
                            sumOperasi++;
                        }
                    } else {
                        int panjang = sisa;
                        for (int k = 0; k < panjang; k++) {
                            bilMemenuhi.add(bilMemenuhi.get(0));
                            sisa--;
                            sumOperasi++;
                        }
                    }
                    bilBelumMemenuhi.remove(index);
                    if (sisa == 0) {
                        break;
                    }
                }
                System.out.print(sumOperasi + " ");
            }
            System.out.println("");
        }
    }
}
