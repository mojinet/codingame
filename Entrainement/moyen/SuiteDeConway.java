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
        int R = in.nextInt();                                       // nombre de départ
        int L = in.nextInt();                                       // nombre d'itération

        System.out.println(L==1?R:getResponse(L,R));
    }

    public static String getResponse(int L, int R){
        ArrayList<Integer> response = new ArrayList<>();
        response.add(R);

        // boucle L fois
        for (int i = 0; i < L ; i++) {
            ArrayList<Integer> MAJResponse = new ArrayList<>();     // la réponse actualisé

            // Pour chaque boucle
            for (int j = 0; j < response.size(); j++) {
                //System.err.println(response);
                int sum = 1;                                        // cumul trouver
                int test = response.get(j);                         // le nombre actuel tester
                boolean check = true;                               // pour savoir quand sortir du while 
                
                while( j+1 < response.size() && check ){            // Tant qu'ont à une valeur en j+1 
                    if ( test == response.get(j+1)){                // Si le j+1 est le meme nombre on ajoute au cumul
                        sum++;
                    }else{                                          // sinon on sort du while
                        check = false;
                    }
                    j++;
                }

                MAJResponse.add(sum);
                MAJResponse.add(test);

                response = MAJResponse;
            }
        }

        return response.toString();
    }
}