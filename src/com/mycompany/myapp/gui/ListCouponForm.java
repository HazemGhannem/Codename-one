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
import com.mycompany.myapp.entities.Coupon;
import com.mycompany.myapp.gui.affichage;
import com.mycompany.myapp.services.ServiceCoupon;


/**
 *
 * @author bhk
 */
public class ListCouponForm extends Form {

    public ListCouponForm(Resources res) {
        
         setTitle("List Coupon");
         setLayout(BoxLayout.y());
          
               Container List = new Container (BoxLayout.y());
                Button btnret = new Button("return");
        
            btnret.addActionListener(e -> new ProfileForm(res).show());
        
       
        for (Coupon c : ServiceCoupon.getInstance().getAllCoupons()) {
             MultiButton afficher = new MultiButton("Nom ="+c.getNom());
        afficher.setUIID("Multiline1");
            afficher.addActionListener(e -> new affichageCp(c,res).show());
            //System.out.println(user.getId());
        Button update = new Button("update");
        update.setUIID("update");
            update.addActionListener(e -> new ModifierCoupon(c,res).show());
        Button delete = new Button("delete");
        delete.setUIID("delete");
           delete.addActionListener(e -> new DeleteCoupon(c,res).show());
//            for(int i = 0; i < user; i++)
//            {
//                System.out.println();
//                }
            add(afficher);
            add(delete);
            add(update);
            
            
            }
        Button ajouter = new Button("Ajouter");
            ajouter.addActionListener(e -> new AddCoupon(res).show());
            
            add(ajouter);
        add(btnret);
        

//        SpanLabel sp = new SpanLabel();
//        sp.setText(ServiceCoupon.getInstance().getAllCoupons().toString());
//        add(sp);
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

}
