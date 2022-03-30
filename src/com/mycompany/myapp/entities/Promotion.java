/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author bouss
 */
public class Promotion {
    private int id;
    private String nom;
    private int pourcentage;
    private String Description;
    private float prixoriginal;
    private float prixpromotion;
    private String image ;


    public Promotion(int id, String nom,int pourcentage, String Description, float prixoriginal, float prixpromotion, String image) {
        this.id=id;
        this.nom = nom;
        this.pourcentage = pourcentage;
        this.Description = Description;
        this.prixoriginal = prixoriginal;
        this.prixpromotion = prixpromotion;
        this.image = image;
        
    }

    public Promotion(int id, String nom, int pourcentage, String Description, float prixoriginal, String image) {
        this.id = id;
        this.nom = nom;
        this.pourcentage = pourcentage;
        this.Description = Description;
        this.prixoriginal = prixoriginal;
        this.image = image;
    }
    
    public Promotion( String nom,int pourcentage, String Description, float prixoriginal, float prixpromotion, String image) {
         this.nom = nom;
        this.pourcentage = pourcentage;
        this.Description = Description;
        this.prixoriginal = prixoriginal;
        this.prixpromotion = prixpromotion;
        this.image = image;
    }
     public Promotion( String nom,int pourcentage, String Description, float prixoriginal,  String image) {
         this.nom = nom;
        this.pourcentage = pourcentage;
        this.Description = Description;
        this.prixoriginal = prixoriginal;
        this.image = image;
    }


    public Promotion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
    public float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    
    public float getPrixoriginal() {
        return prixoriginal;
    }

    public void setPrixoriginal(float prixoriginal) {
        this.prixoriginal = prixoriginal;
    }
    public float getPrixpromotion() {
        return prixpromotion;
    }

    public void setPrixpromotion(float prixpromotion) {
        this.prixpromotion = prixpromotion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", nom=" + nom + ", pourcentage=" + pourcentage + ", Description=" + Description + ", prixoriginal=" + prixoriginal + ", prixpromotion=" + prixpromotion + ", image=" + image + '}';
    }

   
    

    
   

    
    
}
