import java.util.ArrayList;
import java.util.List;

class Groupe {
    private int numGroupe;
    private String Orientation;
    private int numTrimestre;
    private List<Etudiant> etudiants;


    // Constructeur
    public Groupe(int numero, String orientation, int trimestre) {
        this.numGroupe = numero;
        this.Orientation = orientation;
        this.numTrimestre = trimestre;
        this.etudiants = new ArrayList<>();
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
