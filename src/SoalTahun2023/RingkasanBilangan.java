package SoalTahun2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RingkasanBilangan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nBilangan = new int[N];
        ArrayList<ArrayList<Integer>> ringkasanBilangan = new ArrayList<>();

        if (N >= 1 && N <= 100) {
            for (int i = 0; i < nBilangan.length; i++) {
                nBilangan[i] = sc.nextInt();
            }
        }
        Arrays.sort(nBilangan);

        int index = -1;
        int m = -1;
        ArrayList<Integer> subRingBilangan;
        for (int i = 0; i < nBilangan.length; i++) {
            if (nBilangan[i] - m > 1) {
                index++;
                subRingBilangan = new ArrayList<>();
                subRingBilangan.add(nBilangan[i]);
                ringkasanBilangan.add(subRingBilangan);
                m = nBilangan[i];
            } else {
                ringkasanBilangan.get(index).add(nBilangan[i]);
                m = nBilangan[i];
            }
        }

        for (int i = 0; i < ringkasanBilangan.size(); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < ringkasanBilangan.get(i).size(); j++) {
                if(ringkasanBilangan.get(i).get(j)>max){
                    max = ringkasanBilangan.get(i).get(j);
                }
            }
            if(ringkasanBilangan.get(i).size() > 1 && ringkasanBilangan.get(i).get(0) != max){
                System.out.print(ringkasanBilangan.get(i).get(0)+"-"+max);
            }else{
                System.out.print(ringkasanBilangan.get(i).get(0));
            }
            
            if(i<ringkasanBilangan.size()-1){
                System.out.print(",");
            }
        }
        System.out.println("");
    }
}

//tesr case
//contoh 1
//13
//1 2 3 1 1 2 6 6 2 5 7 10 7
//1-3,5-7,10
//contoh 2
//3
//30 20 10
//10,20,30
//contoh 3
//3
//3 2 1
//1-3
