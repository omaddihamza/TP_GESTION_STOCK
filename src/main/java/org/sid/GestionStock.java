package org.sid;

import org.sid.model.Produit;

public class GestionStock {

    static Produit[] produits = new Produit[100];
    /**
     * Compte le nombre de produits actuellement dans le stock.
     */
    private static int nombreDeProduits = 0;

    /**
     * Affiche le menu principal des options disponibles.
     */
    public static void printMenu() {
        System.out.println("=== Gestion de stock ===");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher  un produit");
        System.out.println("5. Rechercher un produit");
        System.out.println("6. Calculer la valeur total du stock");
        System.out.println("0. Quitter");
        System.out.print("Choisissez une option : ");
    }

    /**
     * Ajoute un produit au stock si il y a encore de la place.
     * @param produit Le produit à ajouter
     */
    public static void ajouterProduit(Produit produit) {
        if (nombreDeProduits >= produits.length) {
            System.out.println("Le stock est plein ! Impossible d'ajouter plus de produits.");
            return;
        }
        produits[nombreDeProduits] = produit;
        nombreDeProduits++;
        System.out.println("Produit ajouté avec succès !");
    }

    /**
     * Affiche tous les produits actuellement dans le stock.
     */
    public static void afficherProduits() {
        if (nombreDeProduits == 0) {
            System.out.println("Le stock est vide.");
            return;
        }

        System.out.println("=== Liste des Produits ===");
        for (int i = 0; i < nombreDeProduits; i++) {
            if (produits[i] != null) {
                System.out.println(produits[i]);
            }
        }
    }

    /**
     * Modifie un produit existant dans le stock par son code.
     * @param code Le code du produit à modifier
     * @param nouveauNom Le nouveau nom du produit
     * @param nouvelleQuantite La nouvelle quantité du produit
     * @param nouveauPrix Le nouveau prix du produit
     */
    public static void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        boolean produitModifie = false;
        for (int i = 0; i < nombreDeProduits; i++) {
            if (produits[i].getCode() == code) {
                produits[i].setNom(nouveauNom);
                produits[i].setQuantite(nouvelleQuantite);
                produits[i].setPrix(nouveauPrix);
                System.out.println("Produit modifié avec succès !");
                produitModifie = true;
            }
        }
        // Si le produit n'a pas été trouvé, afficher un message d'erreur
        if (!produitModifie) {
            System.out.println("Produit non trouvé.");
        }
    }

    /**
     * Recherche un produit par son nom.
     * @param nom Le nom du produit à rechercher
     */
    public static void rechercherProduit(String nom) {
        boolean produitTrouve = false;
        for (int i = 0; i < nombreDeProduits; i++) {
            if (produits[i].getNom().equals(nom)) {
                System.out.println("Le produit trouvé :");
                System.out.println(produits[i]);
                produitTrouve = true;
                break;
            }
        }
        if (!produitTrouve) {
            System.out.println("Produit non existant.");
        }
    }

    /**
     * Supprime un produit du stock par son code.
     * @param code Le code du produit à supprimer
     */
    public static void supprimerProduit(int code) {
        boolean produitSupprime = false;
        for (int i = 0; i < nombreDeProduits; i++) {
            if (produits[i].getCode() == code) {
                produits[i] = null;
                System.out.println("Produit avec le code " + code + " a été supprimé avec succès !");
                produitSupprime = true;
            }
        }
        // Si le produit n'a pas été trouvé, afficher un message d'erreur
        if (!produitSupprime) {
            System.out.println("Produit non trouvé.");
        }
    }

    /**
     * Calcule la valeur totale du stock en multipliant la quantité de chaque produit par son prix.
     * @return La valeur totale du stock
     */
    public static double calculerValeurStock() {
        double valeurTotal = 0;
        for (int i = 0; i < nombreDeProduits; i++) {
            if (produits[i] != null) {
                int quantite = produits[i].getQuantite();
                double prix = produits[i].getPrix();
                valeurTotal += produits[i].calculerValeurTotale(prix, quantite);
            }
        }
        return valeurTotal;
    }
}
