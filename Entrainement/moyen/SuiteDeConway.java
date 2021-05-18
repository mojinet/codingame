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
        int R = in.nextInt();
        int L = in.nextInt();
        String line = R + ""; // initialise le premier

        for (int i = 0; i < L-1; i++) {
            System.err.println(line);
            line = getNext(line.split(" "));            
        }

        System.out.println(L==1?R:line.trim());
    }

    public static String getNext(String[] array){
        StringBuilder str = new StringBuilder();
        int[] line = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            line[i] = Integer.parseInt(array[i]);
        }

        for (int i = 0; i < line.length; i++) {
            int count = 1;
            int test = line[i];

            while (i+1 < line.length && line[i] == line[i+1]){
                count++;
                i++;
            }

            str.append(count + " " + test + " ");
        }
        return str.toString();
    }
}