import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();                       // the number of cells on the X axis
        int height = in.nextInt();                      // the number of cells on the Y axis
        char[][] board = new char[width][height];       // make a board to represente state

        if (in.hasNextLine()) { in.nextLine(); }

        for (int x = 0; x < width; x++) {               // X
            String line = in.nextLine();                // width characters, each either 0 or .
            char[] lineChar = line.toCharArray();       // convert String to char[]

            System.err.println();                       // debug
            for (int y = 0; y < height; y++) {          // Y
                board[x][y] = lineChar[y];

                System.err.print(board[x][y]);          //debug
            }
        }

        System.out.println("0 0 1 0 0 1");
    }
}