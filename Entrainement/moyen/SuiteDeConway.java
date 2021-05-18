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
            line = getNext(line);            
        }

        String response = "";
        for (int i = 0; i < line.length(); i++) {
            if (i != line.length()-1){
                response += line.charAt(i) + " ";
            }else{
                response += line.charAt(i);
            }
        }

        System.out.println(L==1?R:response);
    }

    public static String getNext(String line){
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            int count = 1;
            char test = line.charAt(i);

            while (i+1 < line.length() && line.charAt(i) == line.charAt(i+1)){
                count++;
                i++;
            }
            str.append(count + "" + test);
        }

        return str.toString();
    }
}