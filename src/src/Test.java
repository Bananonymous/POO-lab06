import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Personne[] toutLeMonde;

        // 1. Définir les professeurs Daniel Rossier (DRE) et Pier Donini (PDO).
        String[] prenomProf = {"Daniel", "Pier"};
        String[] nomProf = {"Rossier", "Donini"};
        String[] abrevProf = {"DRE", "PDO"};

        Prof[] professeurs = new Prof[2];
        for (int i = 0; i < professeurs.length; i++) {
            professeurs[i] = new Prof(nomProf[i], prenomProf[i], abrevProf[i]);
        }

        // 2. Définir les trois leçons du cours de POO (PDO), la leçon du cours SYE (DRE) ainsi qu’une leçon TIC (projet non encadré).

        // Définir les trois leçons du cours de POO (PDO), la leçon du cours SYE (DRE) ainsi qu’une leçon TIC (projet non encadré).
        /*
     | Lun         | Mar         | Mer         | Jeu         | Ven         |
     |-------------|-------------|-------------|-------------|-------------|
 8:30|SYE   G01 DRE|             |             |             |             |
     |             |-------------|-------------|-------------|-------------|
 9:15|             |             |             |             |             |
     |-------------|-------------|-------------|-------------|-------------|
10:25|             |             |             |SYE   A09 DRE|             |
     |-------------|-------------|-------------|             |-------------|
11:15|             |             |             |             |             |
     |-------------|-------------|-------------|-------------|-------------|
12:00|             |             |             |             |             |
     |-------------|-------------|-------------|-------------|-------------|
13:15|             |             |POO   H02 PDO|POO   H02 PDO|             |
     |-------------|-------------|             |             |-------------|
14:00|             |             |             |             |             |
     |-------------|-------------|-------------|-------------|-------------|
14:55|             |             |             |POO   H02 PDO|             |
     |-------------|-------------|-------------|             |-------------|
15:45|             |             |             |             |             |
     |-------------|-------------|-------------|-------------|-------------|
16:35|             |TIC   F06    |             |             |             |
     |-------------|-------------|-------------|-------------|-------------|
17:20|             |             |             |             |             |
     |-------------|-------------|-------------|-------------|-------------
         */

        Lecon[] lecons = new Lecon[5];
        lecons[0] = new Lecon("SYE", 1, 1, 2, "G01");
        lecons[1] = new Lecon("TIC", 2, 10, 1, "F06");
        lecons[2] = new Lecon("POO", 3, 6, 2, "H02");
        lecons[3] = new Lecon("SYE", 4, 3, 2, "A09");
        lecons[4] = new Lecon("POO", 4, 6, 2, "H02");

        // 3. Définir les étudiants John Lennon, Paul Mc Cartney, Ringo Starr, George Harisson, Roger Waters et David Gilmour.
        String[] studNames = {"John", "Lennon", "Paul", "Mc Cartney", "Ringo", "Starr", "George", "Harisson", "Roger", "Waters", "David", "Gilmour"};
        Etud[] etudiants = new Etud[studNames.length / 2];
        for (int i = 0; i < etudiants.length; i++) {
            etudiants[i] = new Etud(studNames[2 * i + 1], studNames[2 * i], 1000 + i);
        }

        // 4. Définir un groupe IL6-1 contenant les quatre premiers étudiants et un groupe SI6-1 contenant les deux derniers.
        Groupe IL = new Groupe(1, "IL", 6, Arrays.asList(etudiants[0], etudiants[1], etudiants[2], etudiants[3]));
        Groupe SI = new Groupe(1, "SI", 6, Arrays.asList(etudiants[4], etudiants[5]));

        // 5. Affecter au groupe IL6-1 toutes les leçons existantes. Affecter au groupe SI6-1 toutes les leçons de POO.

        // 6. Définir un tableau contenant toutes les personnes et en afficher les éléments en tirant parti du mécanisme de liaison dynamique.
        int totPersonnes = etudiants.length + professeurs.length;
        toutLeMonde = new Personne[totPersonnes];
        System.arraycopy(etudiants, 0, toutLeMonde, 0, etudiants.length);
        System.arraycopy(professeurs, 0, toutLeMonde, etudiants.length, professeurs.length);

        System.out.println("--- Membres de l'école : ---");
        for (Personne personne : toutLeMonde) {
            System.out.println(personne);
        }

        // 7. Afficher les informations relatives au groupe IL6-1 (nom, nombre d’étudiants, horaire). Le nom est composé de l'orientation, du trimestre et du numero du groupe. IL6-1 est le groupe numéro 1, d'orientation IL, du 6ème trimestre.

        // 8. Afficher l’horaire du professeur PDO.
    }
}