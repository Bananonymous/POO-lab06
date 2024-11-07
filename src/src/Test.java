import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //1. Définir les professeurs Daniel Rossier (DRE) et Pier Donini (PDO).
        Prof dre = new Prof("Rossier", "Daniel", "DRE");
        Prof pdo = new Prof("Donini", "Pier", "PDO");

        //2. Définir les trois leçons du cours de POO (PDO), la leçon du cours SYE (DRE) ainsi qu’une leçon TIC (projet non encadré).
        Lecon poo1 = new Lecon("POO", 3, 6, 2, "H02", pdo);
        Lecon poo2 = new Lecon("POO", 4, 6, 2, "H02", pdo);
        Lecon poo3 = new Lecon("POO", 4, 8, 2, "H02", pdo);
        Lecon sye1 = new Lecon("SYE", 1, 1, 2, "G01", dre);
        Lecon sye2 = new Lecon("SYE", 4, 3, 2, "A09", dre);
        Lecon tic1 = new Lecon("TIC", 2, 10, 1, "F06");

        //3.Définir les étudiants John Lennon, Paul Mc Cartney, Ringo Starr, George Harisson, Roger Waters et David Gilmour.
        Etud john   = new Etud("Lennon", "John", 1234);
        Etud paul   = new Etud("Mc Cartney", "Paul", 2341);
        Etud ringo  = new Etud("Starr", "Ringo", 3241);
        Etud george = new Etud("Harisson", "George", 4321);
        Etud roger  = new Etud("Waters", "Roger", 1324);
        Etud david  = new Etud("Gilmour", "David", 4312);

        //4.Définir un groupe IL6-1 contenant les quatre premiers étudiants et un groupe SI6-1 contenant les deux derniers.
        Groupe il = new Groupe(1, "IL", 6, Arrays.asList(john, paul, ringo, george));
        Groupe si = new Groupe(1, "SI", 6, Arrays.asList(roger, david));

        //5.Affecter au groupe IL6-1 toutes les leçons existantes. Affecter au groupe SI6-1 toutes les leçons de POO.
        il.definirLecons(Arrays.asList(poo1, poo2, poo3, sye1, sye2, tic1));
        si.definirLecons(Arrays.asList(poo1, poo2, poo3));

        //6.Définir un tableau contenant toutes les personnes et en afficher les éléments en tirant parti du mécanisme de liaison dynamique.
        System.out.println("--Membres de l'école");
        for (Personne p : new Personne[]{pdo, dre, john, paul, ringo, george, roger, david}){
            System.out.println(p);
        }
        System.out.println();

        //7.Afficher les informations relatives au groupe IL6-1 (nom, nombre d’étudiants, horaire). Le nom est composé de l'orientation, du trimestre et du numero du groupe. IL6-1 est le groupe numéro 1, d'orientation IL, du 6ème trimestre.
        System.out.println(il.horaire());

        //8.Afficher l’horaire du professeur PDO.
        System.out.println(pdo.horaire());
    }
}