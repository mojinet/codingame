import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        int Xmin = 0;
        int Ymin = 0;
        int Xmax = W;
        int Ymax = H;

        // game loop
        while (true) {
            String bombDir = in.next(); 
            System.err.println(bombDir);

            switch(bombDir){
                // UP
                case "U" : 
                    // U
                    Ymax = Y0;              // la position Y actuel est le MAX
                    Y0 = (Ymin + Ymax)/2;   // on additionne les position min et max qu'on divise par 2

                    break;
                case "UR" : 
                    // U
                    Ymax = Y0;
                    Y0 = (Ymin + Ymax)/2;

                    //R
                    Xmin = X0;
                    X0 = (Xmin + Xmax)/2;

                    break;
                case "UL" : 
                    // U
                    Ymax = Y0;
                    Y0 = (Ymin + Ymax)/2;

                    //L
                    Xmax = X0;
                    X0 = (Xmin + Xmax)/2;

                    break;
            
                // DOWN
                case "D" : 
                    // D
                    Ymin = Y0;              
                    Y0 = (Ymin + Ymax)/2;   

                    break;
                case "DR" : 
                    // D
                    Ymin = Y0;              
                    Y0 = (Ymin + Ymax)/2; 

                    //R
                    Xmin = X0;
                    X0 = (Xmin + Xmax)/2;

                    break;
                case "DL" : 
                    // D
                    Ymin = Y0;              
                    Y0 = (Ymin + Ymax)/2;

                    //L
                    Xmax = X0;
                    X0 = (Xmin + Xmax)/2;

                    break;

                // LEFT/RIGHT
                case "R" : 
                    //R
                    Xmin = X0;
                    X0 = (Xmin + Xmax)/2;

                    break;
                case "L" : 
                    //L
                    Xmax = X0;
                    X0 = (Xmin + Xmax)/2;

                    break;
            }

            System.out.println(X0 + " " + Y0);
        }
    }
}