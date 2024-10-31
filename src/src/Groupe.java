import java.util.ArrayList;
import java.util.List;

class Groupe {
    private int numGroupe;
    private String orientation;
    private int numTrimestre;
    private List<Etud> etudiants;


    // Constructeur
    public Groupe(int numero, String orientation, int trimestre, List<Etud> etudiants) {
        this.etudiants = new ArrayList<>();
        this.numGroupe = numero;
        this.orientation = orientation;
        this.numTrimestre = trimestre;
        this.etudiants.addAll(etudiants);
        for (Etud etudiant : this.etudiants) {
            etudiant.setGroupe(this);
        }
    }

    public String horaire (){
        return "Horaire";
    }
    public int nbEtudiant(){
        return etudiants.size();
    }
    public String nom(){
        return this.orientation + numTrimestre + "-" + numGroupe;
    }
    public void defLecon(){
        System.out.println("Lecon définies !");
    }
}
