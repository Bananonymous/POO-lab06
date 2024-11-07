import java.util.ArrayList;
import java.util.List;
import java.util.Collection;


class Groupe {
    private int numGroupe;

    private String orientation;

    private int numTrimestre;

    private List<Etud> etudiants;

    private ArrayList<Lecon> lecons;

    public Groupe(int numero, String orientation, int trimestre, List<Etud> etudiants) {
        this.etudiants = new ArrayList<>();
        this.numGroupe = numero;
        this.orientation = orientation;
        this.numTrimestre = trimestre;
        this.etudiants.addAll(etudiants);
        lecons = new ArrayList<>();
        for (Etud etudiant : this.etudiants) {
            etudiant.setGroupe(this);
        }
    }

    public int nbEtudiant() {
        return etudiants.size();
    }

    public String nom() {
        return this.orientation + numTrimestre + "-" + numGroupe;
    }

    public void defLecon() {
        System.out.println("Lecon définies !");
    }

    public void definirLecons(Collection<Lecon> Lecons) {
        this.lecons.addAll(Lecons);
    }

    public String horaire() {
        return "-- Horaire du groupe " + nom() + " (" + nbEtudiant() + " étudiants)\n" +
                Lecon.horaire(lecons);
    }
}
