import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //1.
        Prof dre = new Prof("Rossier", "Daniel", "DRE");
        Prof pdo = new Prof("Donini", "Pier", "PDO");

        //2.
        Lecon poo1 = new Lecon("POO", 3, 6, 2, "H02", pdo);
        Lecon poo2 = new Lecon("POO", 4, 6, 2, "H02", pdo);
        Lecon poo3 = new Lecon("POO", 4, 8, 2, "H02", pdo);
        Lecon sye1 = new Lecon("SYE", 1, 1, 2, "G01", dre);
        Lecon sye2 = new Lecon("SYE", 4, 3, 2, "A09", dre);
        Lecon tic1 = new Lecon("TIC", 2, 10, 1, "F06");

        //3.
        Etud john   = new Etud("Lennon", "John", 1234);
        Etud paul   = new Etud("Mc Cartney", "Paul", 2341);
        Etud ringo  = new Etud("Starr", "Ringo", 3241);
        Etud george = new Etud("Harisson", "George", 4321);
        Etud roger  = new Etud("Waters", "Roger", 1324);
        Etud david  = new Etud("Gilmour", "David", 4312);

        //4.
        Groupe il61 = new Groupe(1, "IL", 6, Arrays.asList(john, paul, ringo, george));
        Groupe si61 = new Groupe(1, "SI", 6, Arrays.asList(roger, david));

        //5.
        il61.definirLecons(Arrays.asList(poo1, poo2, poo3, sye1, sye2, tic1));
        si61.definirLecons(Arrays.asList(poo1, poo2, poo3));

        //6.
        System.out.println("--Membres de l'école");
        for (Personne p : new Personne[]{pdo, dre, john, paul, ringo, george, roger, david}){
            System.out.println(p);
        }
        System.out.println();

        //7.
        System.out.println(il61.horaire());

        //8.
        System.out.println(pdo.horaire());
    }
}