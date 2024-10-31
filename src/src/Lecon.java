/**
 *
 */
public class Lecon {

    private static String[] joursSemaine = {"Lun", "Mar", "Mer", "Jeu", "Ven"};
    private static String[] periodes = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15", "14:00", "14:55", "15:45", "16:35", "17:20"};

    // TODO : implémenter un format pour l'affichage des horaires (colonnes, lignes et séparateurs)

    private String matiere;
    private int jourSemaine;
    private int periodeDebut;
    private int duree;
    private String salle;
    private Personne professeur;

    // permet d'initialiser une leçon sans professeur
    public Lecon(String matiere, int jourSemaine, int periodeDebut, int duree, String salle) {
        // TODO : implémenter les tests à faire pour savoir si les paramètres sont valides
        this.matiere = matiere;
        this.jourSemaine = jourSemaine;
        this.periodeDebut = periodeDebut;
        this.duree = duree;
        this.salle = salle;
    }

    // permet d'initialiser une leçon avec professeur
    public Lecon(String matiere, int jourSemaine, int periodeDebut, int duree, String salle, Personne professeur) {
        this(matiere, jourSemaine, periodeDebut, duree, salle);
        // TODO : implémenter les tests à faire pour savoir si le paramètre professeur est valide
        this.professeur = professeur;
    }

    public static String horaire() {
        // TODO : implémenter un format pour les horaires
        return "8h-12h";

    }
}
