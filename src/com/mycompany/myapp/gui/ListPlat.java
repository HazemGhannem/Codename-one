/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Plat;
import com.mycompany.myapp.services.ServicePlat;


/**
 *
 * @author bouss
 */
public class ListPlat extends Form {
    
        public ListPlat(Resources res) {
        setTitle("Liste des Plats");
        setLayout(BoxLayout.y());
        Button btnret = new Button("return");
        
            btnret.addActionListener(e -> new ProfileForm(res).show());
        
       
        for (Plat p : ServicePlat.getInstance().getAllPlats()) {
        
        MultiButton afficher = new MultiButton("Nom ="+p.getNom());
        afficher.setUIID("Multiline1");
            afficher.addActionListener(e -> new affichage(p,res).show());
//            System.out.println(user.getId());
        Button update = new Button("modifier");
        update.setUIID("update");
            update.addActionListener(e -> new ModifierPlats(p,res).show());
            
        Button delete = new Button("supprimer");
        delete.setUIID("delete");
           delete.addActionListener(e -> new DeletePlats(p,res).show());
//            for(int i = 0; i < p; i++)
//            {
//                System.out.println();
//                }
            add(afficher);
            
            add(delete);
            add(update);
            
            
            }
     
        Button ajouter = new Button("Ajouter");
        ajouter.addActionListener(e -> new AddPlat(res).show());
        add(ajouter);
           add(btnret);
       
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
         
    
}
