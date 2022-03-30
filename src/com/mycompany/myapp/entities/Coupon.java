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
public class Coupon {
    private int id ;
    private String nom ;
    private String code ;
    private float pourcentage ;

     public Coupon(int id, String nom , String code , float pourcentage) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.pourcentage = pourcentage;
    }
     public Coupon(String nom, String code , float pourcentage) {
        this.nom = nom;
        this.code = code;
        this.pourcentage = pourcentage;
    }

 

    public Coupon() {
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
   public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
      public Float getPourcentage() {
        return pourcentage;
    }
    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "Coupon{" + "id=" + id + ", nom=" + nom + ", code=" + code + ", pourcentage=" + pourcentage + '}';
    }
   
    
}
