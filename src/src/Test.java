public class Test {
    public static void main(String[] args) {
        String[] names = {"John","Lennon", "Paul","Mc Cartney", "Ringo","Starr","George","Harisson","Roger","Waters","David","Gilmour"};
        Personne[] personnes = new Personne[names.length/2];
        for (int i = 0; i < personnes.length; i++) {
            personnes[i] = new Etudiant(names[2*i+1], names[2*i], 1000+i);
        }
        for (Personne p : personnes) {
            System.out.println(p);
        }
    }
}