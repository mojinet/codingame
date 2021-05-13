import java.util.*;

import javax.sql.rowset.serial.SerialRef;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();                       // the number of cells on the X axis
        int height = in.nextInt();                      // the number of cells on the Y axis
        char[][] board = new char[height][width];       // make a board to represente state

        if (in.hasNextLine()) { in.nextLine(); }

        // pour chaque LIGNE
        for (int i = 0; i < height; i++) {              // Line
            String line = in.nextLine();                // width characters, each either 0 or .
            for (int j = 0; j < width; j++) {           // column
                board[i][j] = line.charAt(j);
            }
        }

        StringBuilder response = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == '0'){
                    response.append(i + " " + j + " ");

                    // Y
                    if ((i+1) >= height){
                        response.append("-1 -1 ");
                    }else{
                        if (board[i+1][j] == '0'){
                            response.append((i+1) + " " + j + " ");
                        }else{
                            response.append("-1 -1 ");
                        }
                    }

                    // X
                    if ((j+1) >= width) {
                        response.append("-1 -1");
                    }else{
                        if (board[i][j+1] == '0'){
                            response.append(i + " " + (j+1));
                        }else{
                            response.append("-1 -1");
                        }
                    }
                    response.append(String.format("%n"));
                }
            }
        }

        System.out.println(response.toString());
    }
}