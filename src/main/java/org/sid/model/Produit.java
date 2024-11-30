package org.sid.model;

public class Produit {
    private static int globalCode = 0;
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur par défaut Permet de créer un produit sans initialisation immédiate
    public Produit() {
    }
    // Constructeur avec paramètres pour initialiser les attributs
    public Produit(String nom, int quantite, double prix) {
        globalCode ++;
        this.code = globalCode;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    //Les getters et setters sont utilisés pour encapsuler les attributs de la classe.
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     *
     * @param prix
     * @param quantite
     * @return total
     */
    public double calculerValeurTotale(double prix, int quantite){
         return prix * quantite;
    }
   //La méthode toString est surchargée pour fournir une représentation sous forme de chaîne de caractères de l'objet Produit.
    @Override
    public String toString() {
        return "Produit{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
