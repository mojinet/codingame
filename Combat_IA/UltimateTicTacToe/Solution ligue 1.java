import java.util.*;

class Player {
    private static Case[][] plateau = initPlateau();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {

            // la position ou le joueur adverse à jouer au tour précedent, si -1 : premier tour
            int opponentRow = in.nextInt();
            int opponentCol = in.nextInt();

            // Le joueur adverse joue
            if (opponentRow != -1){
                playAt(opponentRow, opponentCol, Case.ADVERSAIRE);
            }

            // retourne toute les positions valide ou il est possible de jouer
            int validActionCount = in.nextInt();
            for (int i = 0; i < validActionCount; i++) {
                int row = in.nextInt();
                int col = in.nextInt();
            }

            // Reponse
            System.out.println("2 2");
        }
    }

    /*
     * Renvois l'action à jouer pour le prochain tour
     */
    private static String prendDecision(){
        String response = "";
        int[] positionGagnanteMoi = positionAFermer(Case.MOI);
        int[] positionGagnanteAdversaire = positionAFermer(Case.ADVERSAIRE);

        // Si c'est mon premier tour ET que l'adversaire n'a pas encore jouer je joue en 0,0
        if (nombrePion(Case.ADVERSAIRE) == 0){ plateau[0][0] = Case.MOI; response = "0 0";}

        // Si c'est mon premier tour ET que l'adversaire n'a pas jouer au milieu je joue en 1,1
        else if (nombrePion(Case.ADVERSAIRE) == 1 && plateau[1][1] == Case.VIDE && nombrePion(Case.MOI) == 0){ plateau[1][1] = Case.MOI; response = "1 1";}

        // Si c'est mon premier tour ET que l'adversaire a jouer au milieu je joue en 0,0
        else if (nombrePion(Case.ADVERSAIRE) == 1 && plateau[1][1] == Case.ADVERSAIRE && nombrePion(Case.MOI) == 0){ plateau[0][0] = Case.MOI; response = "0 0";}

        // Si j'ai une position gagnante je la joue
        else if (positionGagnanteMoi[0] != -1){
            response = positionGagnanteMoi[0] + " " + positionGagnanteMoi[1]; plateau[positionGagnanteMoi[0]][positionGagnanteMoi[1]] = Case.MOI;}

        // Si l'adversaire à une position gagnante je la joue
        else if (positionGagnanteAdversaire[0] != -1){
            response = positionGagnanteAdversaire[0] + " " + positionGagnanteAdversaire[1]; plateau[positionGagnanteAdversaire[0]][positionGagnanteAdversaire[1]] = Case.MOI;}

        // Test les positions double gagnante et les joue si c'est possible
        else if(plateau[0][2] != Case.ADVERSAIRE && plateau[2][2] != Case.ADVERSAIRE && (plateau[0][2] == Case.VIDE || plateau[2][2] == Case.VIDE)){
            if (plateau[0][2] == Case.VIDE){ plateau[0][2] = Case.MOI; response = "0 2";}
            else if (plateau[2][2] == Case.VIDE){ plateau[2][2] = Case.MOI; response = "2 2"; }
        }
        else if(plateau[0][2] != Case.ADVERSAIRE && plateau[2][0] != Case.ADVERSAIRE && (plateau[0][2] == Case.VIDE || plateau[2][0] == Case.VIDE)){
            if (plateau[0][2] == Case.VIDE){ plateau[0][2] = Case.MOI; response = "0 2";}
            else if (plateau[2][0] == Case.VIDE){ plateau[2][0] = Case.MOI; response = "2 0";}
        }
        else if(plateau[2][0] != Case.ADVERSAIRE && plateau[2][2] != Case.ADVERSAIRE && (plateau[0][0] == Case.VIDE || plateau[2][2] == Case.VIDE)){
            if (plateau[2][0] == Case.VIDE){ plateau[2][0] = Case.MOI; response = "2 0";}
            else if (plateau[2][2] == Case.VIDE){ plateau[2][2] = Case.MOI; response = "2 2";}
        }

        // Sinon on joue une position random : améliorer ça...
        else{
            int col;
            int row;
            boolean validAction = false;
            do{
                col = (int) Math.random() * 2;
                row = (int) Math.random() * 2;
                if (plateau[row][col] == Case.VIDE){
                    plateau[row][col] = Case.MOI;
                    response = row + " " + col;
                    validAction = true;
                }
            }while(validAction);
        }

        return response;
    }

    /*
     * retourne la position à jouer si une position gagnante est detecté pour le joueur donnée en parametre
     */
    public static int[] positionAFermer(Case caseJoueur){
        int[] response = {-1,-1};
        // Ligne
        if(plateau[0][0] == caseJoueur && plateau[0][1] == caseJoueur && plateau[0][2] == Case.VIDE){response[0] = 0; response[1] = 2; }
        else if(plateau[0][1] == caseJoueur && plateau[0][2] == caseJoueur && plateau[0][0] == Case.VIDE){response[0] = 0; response[1] = 0; }
        else if(plateau[0][2] == caseJoueur && plateau[0][0] == caseJoueur && plateau[0][1] == Case.VIDE){response[0] = 0; response[1] = 1; }
        else if(plateau[1][0] == caseJoueur && plateau[1][1] == caseJoueur && plateau[1][2] == Case.VIDE){response[0] = 1; response[1] = 2; }
        else if(plateau[1][1] == caseJoueur && plateau[1][2] == caseJoueur && plateau[1][0] == Case.VIDE){response[0] = 1; response[1] = 0; }
        else if(plateau[1][2] == caseJoueur && plateau[1][0] == caseJoueur && plateau[1][1] == Case.VIDE){response[0] = 1; response[1] = 1; }
        else if(plateau[2][0] == caseJoueur && plateau[2][1] == caseJoueur && plateau[2][2] == Case.VIDE){response[0] = 2; response[1] = 2; }
        else if(plateau[2][1] == caseJoueur && plateau[2][2] == caseJoueur && plateau[2][0] == Case.VIDE){response[0] = 2; response[1] = 0; }
        else if(plateau[2][2] == caseJoueur && plateau[2][0] == caseJoueur && plateau[2][1] == Case.VIDE){response[0] = 2; response[1] = 1; }
        // Colonne
        else if(plateau[0][0] == caseJoueur && plateau[1][0] == caseJoueur && plateau[2][0] == Case.VIDE){response[0] = 2; response[1] = 0; }
        else if(plateau[1][0] == caseJoueur && plateau[2][0] == caseJoueur && plateau[0][0] == Case.VIDE){response[0] = 0; response[1] = 0; }
        else if(plateau[2][0] == caseJoueur && plateau[0][0] == caseJoueur && plateau[1][0] == Case.VIDE){response[0] = 1; response[1] = 0; }
        else if(plateau[0][1] == caseJoueur && plateau[1][1] == caseJoueur && plateau[2][1] == Case.VIDE){response[0] = 2; response[1] = 1; }
        else if(plateau[1][1] == caseJoueur && plateau[2][1] == caseJoueur && plateau[0][1] == Case.VIDE){response[0] = 0; response[1] = 1; }
        else if(plateau[2][1] == caseJoueur && plateau[0][1] == caseJoueur && plateau[1][1] == Case.VIDE){response[0] = 1; response[1] = 1; }
        else if(plateau[0][2] == caseJoueur && plateau[1][2] == caseJoueur && plateau[2][2] == Case.VIDE){response[0] = 2; response[1] = 2; }
        else if(plateau[1][2] == caseJoueur && plateau[2][2] == caseJoueur && plateau[0][2] == Case.VIDE){response[0] = 0; response[1] = 2; }
        else if(plateau[2][2] == caseJoueur && plateau[0][2] == caseJoueur && plateau[1][2] == Case.VIDE){response[0] = 1; response[1] = 2; }
        // Diagonale
        else if(plateau[0][0] == caseJoueur && plateau[1][1] == caseJoueur && plateau[2][2] == Case.VIDE){response[0] = 2; response[1] = 2; }
        else if(plateau[2][2] == caseJoueur && plateau[0][0] == caseJoueur && plateau[1][1] == Case.VIDE){response[0] = 1; response[1] = 1; }
        else if(plateau[1][1] == caseJoueur && plateau[2][2] == caseJoueur && plateau[0][0] == Case.VIDE){response[0] = 0; response[1] = 0; }
        else if(plateau[1][1] == caseJoueur && plateau[2][0] == caseJoueur && plateau[0][2] == Case.VIDE){response[0] = 0; response[1] = 2; }
        else if(plateau[0][2] == caseJoueur && plateau[2][0] == caseJoueur && plateau[1][1] == Case.VIDE){response[0] = 1; response[1] = 1; }
        else if(plateau[1][1] == caseJoueur && plateau[2][0] == caseJoueur && plateau[0][2] == Case.VIDE){response[0] = 0; response[1] = 2; }
        System.err.println(caseJoueur + " " + response[0] + " " + response[1]);
        return response;
    }

    /*
     * Renvois le nombre de Case jouer appartenant au type donnée en parametre
     */
    private static int nombrePion(Case caseTest){
        int response = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (plateau[i][j] == caseTest){
                    response++;
                }
            }
        }
        return response;
    }

    /*
     * Initialise et retourne un plateau de jeu avec des cases vide
     */
    private static Case[][] initPlateau(){
        Case[][] plateau = new Case[3][3];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                plateau[x][y] = Case.VIDE;
            }
        }

        return plateau;
    }

    /*
     * Le joueur joue en x,y
     */
    private static void playAt(int x, int y, Case state){
        plateau[x][y] = state;
    }

}

/*
 * Enumération de l'état des cases du jeu
 */
enum Case{
    MOI,ADVERSAIRE,VIDE;
}
