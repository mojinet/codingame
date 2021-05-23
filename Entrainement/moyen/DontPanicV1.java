import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {

        // parametres
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt();                            // number of floors
        int width = in.nextInt();                               // width of the area
        int nbRounds = in.nextInt();                            // maximum number of rounds
        int exitFloor = in.nextInt();                           // floor on which the exit is found
        int exitPos = in.nextInt();                             // position of the exit on its floor
        int nbTotalClones = in.nextInt();                       // number of generated clones
        int nbAdditionalElevators = in.nextInt();               // ignore (always zero)
        int nbElevators = in.nextInt();                         // number of elevators

        // ascensceur et position
        int[] elevator = new int[nbFloors+1];
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt();                   // floor on which this elevator is found
            int elevatorPos = in.nextInt();                     // position of the elevator on its floor
            elevator[elevatorFloor] = elevatorPos;
            System.err.println(elevatorFloor + " " + elevatorPos);
        }

        elevator[exitFloor] = exitPos;                          // Extraction

        // game loop
        while (true) {
            int cloneFloor = in.nextInt();                      // floor of the leading clone
            int clonePos = in.nextInt();                        // position of the leading clone on its floor
            String direction = in.next();                       // direction of the leading clone: LEFT or RIGHT


            if (clonePos == 0 || clonePos == width -1){         // si le clone atteins le bord de la carte
                System.out.println("BLOCK");
            }else if (cloneFloor != 0){                         // si on est au dessus du RDC
                int initX = elevator[cloneFloor-1];
                int destX = elevator[cloneFloor];

                if(destX > initX){                               // L'ascenseur est à DROITE
                    if(direction.equals("RIGHT")){               // Si les clone se dirige vers la droite
                        System.out.println("WAIT");
                    }else if(direction.equals("LEFT")){          // Si les clone se dirige vers la gauche
                        if (clonePos != initX){
                            System.out.println("BLOCK");
                        }else{
                            System.out.println("WAIT");
                        }
                    }

                }else if (destX < initX) {                       // L'ascenseur est à GAUCHE
                    if(direction.equals("RIGHT")){               // Si les clone se dirige vers la droite
                        if (clonePos != initX){
                            System.out.println("BLOCK");
                        }else{
                            System.out.println("WAIT");
                        }
                    }else if(direction.equals("LEFT")){          // Si les clone se dirige vers la gauche
                        System.out.println("WAIT");
                    }
                }
            } else{
                System.out.println("WAIT");
            }


        }
    }
}