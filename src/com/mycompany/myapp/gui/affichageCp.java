/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Coupon;
import com.mycompany.myapp.entities.Promotion;
import com.mycompany.myapp.services.ServicePromotion;
import com.mycompany.myapp.services.ServiceCoupon;

/**
 *
 * @author pc
 */
public class affichageCp extends Form {
    
        public affichageCp(Promotion p,Resources res) {
        setTitle("Liste des Plats");
        setLayout(BoxLayout.y());
       
        
        MultiButton mb = new MultiButton("Nom =" +p.getNom());
        MultiButton me = new MultiButton("Pourcentage =" +p.getPourcentage());
        MultiButton ms = new MultiButton("Descrption =" +p.getDescription());
        MultiButton mn = new MultiButton("Prixoriginale =" +p.getPrixoriginal());
        MultiButton mt = new MultiButton("Image =" +p.getImage());
        
        
//            System.out.println(user.getId());
        Button update = new Button("modifier");
        update.setUIID("update");
            update.addActionListener(e -> new ModifierPromotion(p,res).show());
        Button delete = new Button("supprimer");
        delete.setUIID("delete");
           delete.addActionListener(e -> new DeletePromotion(p,res).show());
//            for(int i = 0; i < p; i++)
//            {
//                System.out.println();
//                }
            add(mb);
            add(me);
            add(ms);
            add(mn);
            add(mt);
            add(delete);
            add(update);
            

       
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    } public affichageCp(Coupon c,Resources res) {
        setTitle("Liste des Plats");
        setLayout(BoxLayout.y());
       
        
        MultiButton mb = new MultiButton("Nom =" +c.getNom());
        MultiButton ms = new MultiButton("Code =" +c.getCode());
        MultiButton mn = new MultiButton("Pourcentage =" +c.getPourcentage());
        
        
//            System.out.println(user.getId());
        Button update = new Button("modifier");
        update.setUIID("update");
            update.addActionListener(e -> new ModifierCoupon(c,res).show());
        Button delete = new Button("supprimer");
        delete.setUIID("delete");
           delete.addActionListener(e -> new DeleteCoupon(c,res).show());
//            for(int i = 0; i < p; i++)
//            {
//                System.out.println();
//                }
            add(mb);
            add(ms);
            add(mn);
            add(delete);
            add(update);
            

       
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
}
         
    