abstract class Personne {
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String toString(){
        return prenom + " " + nom;
    }
}

class Etud extends Personne {
    private int numMatricule;
    private Groupe groupe;

    public Etud(String nom, String prenom, int numEtudiant) {
        super(nom, prenom);
        this.numMatricule = numEtudiant;
    }

    public String toString(){
        return super.getClass().getSimpleName() + ". " + super.toString() + " N°Matricule : " + numMatricule + " - " + groupe.nom();
    }

    protected void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }
}


class Prof extends Personne {
    private String abreviation;

    public Prof(String nom, String prenom, String abreviation) {
        super(nom, prenom);
        this.abreviation = abreviation;
    }

    public String abrevation(){
        return abreviation;
    }

    public String toString(){
        return super.getClass().getSimpleName() + ". " + super.toString() + " (" + abreviation + ")";
    }

    public String horaire(){
        return "8h-12h";
    }
}