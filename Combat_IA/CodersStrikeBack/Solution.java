import java.util.*;
import java.io.*;
import java.math.*;

class Player {
    public static boolean boost = false;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int power;   
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();
            // Solution

            System.err.println(nextCheckpointDist);
            System.err.println(nextCheckpointAngle);
            if ((nextCheckpointAngle < -90 ) || (nextCheckpointAngle > 90)){
                power = 0;
            }else{
                power = 100;
            }
            
            
            if (boost == false){
                System.out.println(nextCheckpointX + " " + nextCheckpointY + " BOOST");
                boost=true;
            }else{
                System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + power);
            }
            
        }
    }
}