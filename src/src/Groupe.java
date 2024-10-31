import java.util.ArrayList;
import java.util.List;

class Groupe {
    private int numGroupe;
    private String Orientation;
    private int numTrimestre;


    // Constructeur
    public Groupe(int numero, String orientation, int trimestre) {
        this.numGroupe = numero;
        this.Orientation = orientation;
        this.numTrimestre = trimestre;
    }

    public String horaire (){
        return "Horaire";
    }
    public int nbEtudiant(){
        return 42;
    }
    public String nom(){
        return "NomGroupe";
    }
    public void defLecon(){
        System.out.println("Lecon définies !");
    }
}
