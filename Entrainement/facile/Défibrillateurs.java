import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Double LON = Double.parseDouble(in.next().replace(',','.'));
        Double LAT = Double.parseDouble(in.next().replace(',','.'));
        int N = in.nextInt();
        List<String[]> defib = new ArrayList<>();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] str = DEFIB.split(";");
            defib.add(str);
        }

        String response =" "; 
        double test = Double.MAX_VALUE;

        for (String[] strings : defib) {
            double lonB = Double.parseDouble(strings[4].replace(',','.')); // long
            double latB = Double.parseDouble(strings[5].replace(',','.')); // lat
            double x = (lonB - LON) * Math.cos( ( LON + lonB ) / 2);
            double y = LAT - latB;
            double d = Math.sqrt( ((x*x) + (y*y)) * 6317);
            System.err.println(d);
            if (d <= test ){
                response = strings[1]; 
                test = d;
            }
        }

        System.out.println(response);
    }
}