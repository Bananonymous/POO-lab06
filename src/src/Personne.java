import java.util.ArrayList;

public class Personne {

    private final String nom;

    private final String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}

class Etud extends Personne {

    private final int matricule;

    private Groupe groupe;

    public Etud(String nom, String prenom, int matricule) {
        super(nom, prenom);
        if (matricule < 0) {
            throw new RuntimeException("Le matricule ne peut pas etre < 0");
        }
        this.matricule = matricule;
    }

    void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "Etud. " + super.toString() + " (#" + matricule + ") - " + groupe.nom();
    }
}

class Prof extends Personne {
    private final String abreviation;

    private final ArrayList<Lecon> lecons = new ArrayList<>();

    static final int NBRE_INITIALES = 3;

    public Prof(String nom, String prenom, String abreviation) {
        super(nom, prenom);
        this.abreviation = abreviation;
    }

    void definirLecon(Lecon lecon) {
        lecons.add(lecon);
    }

    public String abreviation() {
        return abreviation;
    }

    @Override
    public String toString() {
        return "Prof. " + super.toString() + " (" + abreviation + ")";
    }

    public String horaire() {
        return "-- Horaire " + this + "\n" + Lecon.horaire(lecons);
    }
}
