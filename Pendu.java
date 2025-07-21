import java.util.Scanner;

public class Pendu {
    public static void main(String[] args) {
        // Liste de mots possibles
        String[] mots = {"ordinateur", "java", "programmation", "pendu", "developpeur", "console"};
        
        // Choix aléatoire d'un mot secret
        String motSecret = mots[(int)(Math.random() * mots.length)];
        
        // Tableau de caractères pour afficher l'état du mot (avec _ pour lettres non trouvées)
        char[] motCache = new char[motSecret.length()];
        for (int i = 0; i < motCache.length; i++) {
            motCache[i] = '_';
        }
        
        int essaisRestants = 6;  // Nombre d'erreurs autorisées
        boolean gagne = false;
        
        Scanner scanner = new Scanner(System.in);
        
        while (essaisRestants > 0 && !gagne) {
            // Affichage de l'état du mot
            System.out.print("Mot : ");
            for (char c : motCache) {
                System.out.print(c + " ");
            }
            System.out.println("\nEssais restants : " + essaisRestants);
            
            // Demande une lettre
            System.out.print("Devinez une lettre : ");
            String entree = scanner.nextLine().toLowerCase();
            
            if (entree.length() != 1 || !Character.isLetter(entree.charAt(0))) {
                System.out.println("Veuillez entrer une seule lettre.");
                continue;
            }
            
            char lettre = entree.charAt(0);
            
            // Vérifie si la lettre est dans le mot
            boolean bonneLettre = false;
            for (int i = 0; i < motSecret.length(); i++) {
                if (motSecret.charAt(i) == lettre && motCache[i] == '_') {
                    motCache[i] = lettre;
                    bonneLettre = true;
                }
            }
            
            if (bonneLettre) {
                System.out.println("Bien joué !");
            } else {
                System.out.println("Raté !");
                essaisRestants--;
            }
            
            // Vérifie si le joueur a gagné
            gagne = true;
            for (char c : motCache) {
                if (c == '_') {
                    gagne = false;
                    break;
                }
            }
            System.out.println();
        }
        
        if (gagne) {
            System.out.println("Félicitations, vous avez gagné ! Le mot était : " + motSecret);
        } else {
            System.out.println("Perdu... Le mot était : " + motSecret);
        }
        
        scanner.close();
    }
}
