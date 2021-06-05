import java.util.*;
import java.io.*;
import java.math.*;

class Player {
    final static int JOUEUR = 0;
    final static int COUNT = 1;
    final static int PROD = 2;
    final static int USELESS1 = 3;
    final static int USELESS2 = 4;
    final static int ID = 5;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int factoryCount = in.nextInt();                        // the number of factories
        int linkCount = in.nextInt();                           // the number of links between factories
        int[][] distanceTab = new int[factoryCount][factoryCount];    // initialise un tableau pour les distance
        for (int i = 0; i < linkCount; i++) {
            int factory1 = in.nextInt();
            int factory2 = in.nextInt();
            int distance = in.nextInt();
            distanceTab[factory1][factory2] = distance;
        }

        // game loop
        while (true) {
            int entityCount = in.nextInt();                     // the number of entities (e.g. factories and troops)
            int[][] factoryTab = new int[entityCount][6];       // initialise un tableau pour contenir toute les infos
            for (int i = 0; i < entityCount; i++) {
                int entityId = in.nextInt();
                String entityType = in.next();
                factoryTab[i][JOUEUR] = in.nextInt();           // joueur qui possede l'usine : 1 moi / -1 ennemis / 0 neutre
                factoryTab[i][COUNT] = in.nextInt();            // nombre de cyborg dans l'usine
                factoryTab[i][PROD] = in.nextInt();             // produciton de l'usine entre 0 et 3
                factoryTab[i][USELESS1] = in.nextInt();         // useless
                factoryTab[i][USELESS2] = in.nextInt();         // useless
                factoryTab[i][ID] = i;                          // ID
            }

            // calcule response
            // distancetab
            // factory tab

            for (int[] factory : factoryTab) {
                // Si c'est notre usine
                if(factory[JOUEUR] == 1){
                    for (int[] is : factoryTab) {
                        if(is[JOUEUR] == 0 || is[JOUEUR]==-1){
                            System.out.println("MOVE " + factory[ID] + " " + is[ID] + " 4");
                        }
                    }
                // si c'est une usine d'ennemie
                }else if(factory[JOUEUR] == 0){
                    System.out.println("WAIT");
                // si c'est une usine neutre
                }else{
                    System.out.println("WAIT");
                }
            }
        }
    }
}