package SoalLatihan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SelisihAnagramMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String N = sc.nextLine();
        HashSet<Integer> listBilangan = new HashSet<>();
        for (int i = 0; i < N.length(); i++) {
            for (int j = 0; j < N.length(); j++) {
                char x = N.charAt(j);
                String y;
                if(i == 0){
                    y = x+ N.substring(i+1, N.length());
                }else if(i== N.length()-1){
                    y = N.substring(0, i)+x;
                }else{
                    y = N.substring(0, i)+x+N.substring(i+1, N.length());
                }
                System.out.println(y);
                
                if(isAnagram(N, y)){
                    int z = Integer.parseInt(y);
                    listBilangan.add(z);
                }
            }
        }
        System.out.println(listBilangan);
        int[] bilResult = new int[listBilangan.size()];
        
    }
    
    private static boolean isAnagram(String N, String bilangan){
        boolean result = true;
        if(N.length()!= bilangan.length()){
            result = false;
        }else{
            char[] bilangan1 = new char[N.length()];
            for (int i = 0; i < bilangan1.length; i++) {
                bilangan1[i] = N.charAt(i);
            }
            
            char[] bilangan2 = new char[bilangan.length()];
            for (int i = 0; i < bilangan2.length; i++) {
                bilangan2[i] = bilangan.charAt(i);
            }
            
            Arrays.sort(bilangan1);
            Arrays.sort(bilangan2);
            
            result = Arrays.equals(bilangan1, bilangan2);
        }
        return result;
    }
}


