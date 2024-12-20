package org.sid;

import org.sid.model.Produit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        while (continuer) {
            GestionStock.printMenu();
            try {
                int choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        System.out.println("----Ajouter un produit----");
                        System.out.print("Entrez le nom du produit : ");
                        String nom = scanner.next();

                        System.out.print("Entrez la quantité du produit : ");
                        int quantite = scanner.nextInt();

                        System.out.print("Entrez le prix du produit: ");
                        double prix = scanner.nextDouble();

                        Produit produit = new Produit(nom, quantite, prix);
                        GestionStock.ajouterProduit(produit);
                        break;
                    case 2:
                        System.out.println("----Modifier un produit----");
                        System.out.print("Entrez le code produit que vous souhaitez modifier: ");
                        int code = scanner.nextInt();
                        // Check if the product exists
                        GestionStock.rechercherProduitParID(code);
                        System.out.print("Entrez Nouveau Nom : ");
                        String nouveauNom = scanner.next();

                        System.out.print("Entrez Nouvelle Quantité : ");
                        int nouvelleQuantite = scanner.nextInt();

                        System.out.print("Entrez Nouveau Prix : ");
                        double nouveauPrix = scanner.nextDouble();
                        GestionStock.modifierProduit(code, nouveauNom, nouvelleQuantite, nouveauPrix);
                        break;
                    case 3:
                        boolean confirmation = false;
                        System.out.println("----- Supprimer un produit ------");
                        System.out.print("Entrez le code produit que vous souhaitez Supprimer : ");
                        code = scanner.nextInt();

                         // Check if the product exists
                        GestionStock.rechercherProduitParID(code);

                        System.out.print("Êtes-vous sûr ? (true pour confirmer, false pour annuler) : ");
                        confirmation = scanner.nextBoolean();

                        if (confirmation) {
                            GestionStock.supprimerProduit(code);
                        } else {
                            System.out.println("Suppression annulée.");
                        }
                        break;
                    case 4:
                        GestionStock.afficherProduits();
                        break;
                    case 5:
                        System.out.println("-----Rechercher un produit-----");
                        System.out.print("Entrez le nom produit que vous souhaitez rechercher : ");
                        String nomProduct = scanner.next();
                        GestionStock.rechercherProduit(nomProduct);
                        break;
                    case 6:
                        double total = GestionStock.calculerValeurStock();
                        System.out.println("la valeur totale du stock : " + total);
                        break;
                    case 0:
                        continuer = false;
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer");
                }
            }catch (InputMismatchException ex){
                System.out.println("Erreur : entrée invalide. Veuillez réessayer.");
                scanner.nextLine();
            }


        }
    }
}