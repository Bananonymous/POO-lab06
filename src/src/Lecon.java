import java.util.Collection;

public class Lecon {

    private enum Jours {Lun, Mar, Mer, Jeu, Ven}

    private static final String[] HEURES = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15",
            "14:00", "14:55", "15:45", "16:35", "17:20"};

    private static final char SEP_COL = '|', SEP_LIGNE = '-';

    private static final int LARGEUR_PREMIERE_COL = 5,
            INITIALES_MATIERE = 5, INITIALES_SALLE = 3,
            LARGEUR_COL_JOURS = 2 + Prof.NBRE_INITIALES + INITIALES_MATIERE + INITIALES_SALLE;

    private static final String BAS_CELLULE = SEP_COL + (SEP_LIGNE + "").repeat(LARGEUR_COL_JOURS),
            CELLULE_VIDE = BAS_CELLULE.replace(SEP_LIGNE, ' '),
            SEP_HEURE = " ".repeat(LARGEUR_PREMIERE_COL),
            SEP_LIGNE_COMPLETE = SEP_HEURE + BAS_CELLULE.repeat(Jours.values().length) + SEP_COL +
                    "\n",
            FORMAT_HEURE = "%" + LARGEUR_PREMIERE_COL + "s",
            FORMAT_CELLULE = SEP_COL + "%-" + INITIALES_MATIERE + "s %" + INITIALES_SALLE + "s %" +
                    Prof.NBRE_INITIALES + "s";

    private final String matiere;

    private final int jourSemaine;

    private final int periodeDebut;

    private final int duree;

    private final String salle;

    private Prof professeur;


    // permet d'initialiser une leçon sans professeur
    public Lecon(String matiere, int jourSemaine, int periodeDebut, int duree, String salle) {
        if (periodeDebut + duree > HEURES.length) {
            throw new RuntimeException("La duree de la leçon excède la longueur de la plage " +
                    "horaire");
        }
        if (duree < 1 || periodeDebut < 1) {
            throw new RuntimeException("La duree et la periode de debut doivent être > 0");
        }
        if (jourSemaine < 1 || jourSemaine > Jours.values().length) {
            throw new RuntimeException("Le jour de la semaine doit être entre 1 et " +
                    Jours.values().length);
        }
        if (salle.length() > INITIALES_SALLE) {
            throw new RuntimeException("Les initiales de la salle ne peuvent pas dépasser" +
                    INITIALES_SALLE + " caractères. Actuellement : " + salle.length());
        }
        if (matiere.length() > INITIALES_MATIERE) {
            throw new RuntimeException("Les initiales de la matiere ne peuvent pas dépasser" +
                    INITIALES_MATIERE + " caractères. Actuellement : " + matiere.length());
        }

        this.matiere = matiere;
        this.jourSemaine = jourSemaine;
        this.periodeDebut = periodeDebut;
        this.duree = duree;
        this.salle = salle;
    }

    public Lecon(String matiere, int jourSemaine, int periodeDebut, int duree, String salle, Prof professeurAassigner) {
        this(matiere, jourSemaine, periodeDebut, duree, salle);
        if (professeurAassigner != null) {
            professeur = professeurAassigner;
            professeur.definirLecon(this);
        }
    }

    private static StringBuilder creerEnTete() {
        StringBuilder enTete = new StringBuilder(SEP_HEURE);
        for (Jours jour : Jours.values()) {
            enTete.append(String.format(SEP_COL + " %-" + (LARGEUR_COL_JOURS - 1) + "s",
                    jour.name()));
        }
        return enTete.append(SEP_COL + "\n").append(SEP_LIGNE_COMPLETE);
    }

    private static String creerCellule(int indiceLigne, Lecon lecon) {
        boolean estLignePaire = indiceLigne % 2 == 0;

        if (lecon == null) {
            if (estLignePaire) {
                return CELLULE_VIDE;
            }
            return BAS_CELLULE;
        }
        int periodeActuelle = indiceLigne / 2 - lecon.periodeDebut + 2;

        if (periodeActuelle == 1) {
            if (estLignePaire) {
                return String.format(FORMAT_CELLULE, lecon.matiere, lecon.salle,
                        lecon.professeur != null ? lecon.professeur.abreviation() : "");
            }
            if (lecon.duree > 1) {
                return CELLULE_VIDE;
            }
        }
        if (periodeActuelle < lecon.duree || estLignePaire) {
            return CELLULE_VIDE;
        }
        return BAS_CELLULE;
    }

    public static String horaire(Collection<Lecon> lecons) {
        Lecon[][] tableauLecons = new Lecon[HEURES.length][Jours.values().length];
        for (Lecon lecon : lecons) {
            for (int i = 0; i < lecon.duree; ++i) {
                tableauLecons[lecon.periodeDebut - 1 + i][lecon.jourSemaine - 1] = lecon;
            }
        }

        StringBuilder horaire = new StringBuilder(creerEnTete());
        for (int i = 0; i < (HEURES.length * 2) - 1; ++i) {
            horaire.append(i % 2 != 0 ? SEP_HEURE : String.format(FORMAT_HEURE, HEURES[i / 2]));
            for (int j = 0; j < Jours.values().length; ++j) {
                horaire.append(creerCellule(i, tableauLecons[i / 2][j]));
            }
            horaire.append(SEP_COL + "\n");
        }
        return horaire.append(SEP_LIGNE_COMPLETE).toString();
    }
}
