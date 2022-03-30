/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Coupon;
import com.mycompany.myapp.services.ServiceCoupon;

/**
 *
 * @author bouss
 */
public class ModifierCoupon extends Form {

    Form current;

   public ModifierCoupon(Coupon c ,Resources res) {
        setTitle("edit Coupon");
        setLayout(BoxLayout.y());
        TextField id = new TextField(String.valueOf(c.getId()), "Coupon id");
        TextField tfNom = new TextField(c.getNom(), "Coupon name");
        TextField tfCode = new TextField(c.getCode(), "Coupon code");
        TextField tfPourc = new TextField(String.valueOf(c.getPourcentage()), "Coupon pourcentage");
     
        
        

        Button btnValider = new Button("edit Coupon");
        Button btnRet = new Button("Return");
        btnRet.addActionListener(e-> new ProfileForm(res).show() );

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length() == 0) && (tfCode.getText().length() == 0) && (tfPourc.getText().length() == 0)  ) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        Coupon c = new Coupon(Integer.parseInt(id.getText()), tfNom.getText(), tfCode.getText(), Float.parseFloat(tfPourc.getText()) );
                        System.out.println(c.getId());
                        System.out.println("---------");
                        System.out.println(id.getText());
                        if (ServiceCoupon.getInstance().modifierCoupon(c)) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }

                }

            }
            
        });
        

        addAll(id, tfNom, tfCode, tfPourc, btnValider,btnRet);
        // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> this.previous.showBack());

    }
}