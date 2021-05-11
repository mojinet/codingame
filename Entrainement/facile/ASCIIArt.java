import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine().toUpperCase();
        String[] ascii = new String[H];
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            ascii[i] = ROW;
        }
        System.err.println(T);
        int letter;
        // Pour chaque ligne
        for (int i = 0; i < H; i++) {
            // Pour chaque lettre
            for (int j = 0; j < T.length(); j++) {
                if ((T.charAt(j) >= 'A') && (T.charAt(j) <= 'Z')){
                    letter = T.charAt(j) - 'A';
                    letter = letter*(L);
                } else{
                    letter = (( ('Z'+1)-'A')*L) ;
                }
                // Pour chaque caractere de la lettre
                for (int k = letter; k < letter+L; k++) {
                    System.out.print(ascii[i].charAt(k));
                }
            }
            System.out.println();
        }

    }
}