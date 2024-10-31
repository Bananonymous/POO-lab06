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

class Etudiant extends Personne {
    private int numMatricule;

    public Etudiant(String nom, String prenom, int numEtudiant) {
        super(nom, prenom);
        this.numMatricule = numEtudiant;
    }

    public String toString(){
        return super.toString() + " N°Matricule : " + numMatricule;
    }
}