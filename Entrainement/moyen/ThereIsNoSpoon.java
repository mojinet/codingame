import java.util.*;

import javax.sql.rowset.serial.SerialRef;

import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        char[][] board = new char[width][height];

        for (int i = 0; i < height; i++) { // pour chaque Y
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int j = 0; j < width; j++) { // pour chaque X
                board[j][i] = line.charAt(j);
            }
        }

        // reparcours le tableau et test les positions +1 et +2
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (board[x][y] == '0'){
                    StringBuilder response = new StringBuilder();
                    String coor = x + " " + y + " ";

                    //X
                    int testX = x+1;
                    boolean checkX = false;
                    String repX= "";
                    while(testX < width){
                        if (board[testX][y] == '0'){
                            repX = testX + " " + y + " ";
                            checkX = true;
                            testX = width;
                        }
                        testX++;
                    }
                    repX = checkX ? repX : "-1 -1 ";

                    //Y
                    int testY = y+1;
                    boolean checkY = false;
                    String repY= "";
                    while(testY < height){
                        if (board[x][testY] == '0'){
                            repY = x + " " + testY;
                            checkY = true;
                            testY = height;
                        }
                        testY++;
                    }
                    repY = checkY ? repY : "-1 -1";


                    System.out.println(coor + repX + repY);
                }  
            }
        }
        
    }
}