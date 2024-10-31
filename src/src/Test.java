public class Test {
    public static void main(String[] args) {
        String[] names = {"John","Lennon", "Paul","Mc Cartney", "Ringo","Starr","George","Harisson","Roger","Waters","David","Gilmour"};
        Personne[] personnes = new Personne[names.length/2];
        for (int i = 0; i < personnes.length; i++) {
            personnes[i] = new Etudiant(names[2*i+1], names[2*i], 1000+i);
        }
        for (Personne p : personnes) {
            System.out.println(p);
        }
        // Définir les professeurs Daniel Rossier (DRE) et Pier Donini (PDO).
        String[] prenomProf = {"Daniel", "Pier"};
        String[] nomProf = {"Rossier", "Donini"};
        String[] abrevProf = {"DRE", "PDO"};

        Professeur[] professeurs = new Professeur[2];
        for (int i = 0; i < professeurs.length; i++) {
            professeurs[i] = new Professeur(nomProf[i], prenomProf[i], abrevProf[i]);
        }
        for (Professeur p : professeurs) {
            System.out.println(p);
        }
    }
}