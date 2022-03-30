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
import com.mycompany.myapp.entities.Promotion;
import com.mycompany.myapp.services.ServicePromotion;

/**
 *
 * @author bouss
 */
public class ModifierPromotion extends Form {

    Form current;

   public ModifierPromotion(Promotion p ,Resources res) {
        setTitle("edit Promotion");
        setLayout(BoxLayout.y());
        TextField id = new TextField(String.valueOf(p.getId()), "Promotion id");
        TextField tfNom = new TextField(p.getNom(), "Promotion name");
        TextField tfPourc = new TextField(String.valueOf(p.getPourcentage()), "Promotion pourcentage");
        TextField tfDesc = new TextField(p.getDescription(), "Promotion Description");
        TextField tfPrixoriginal = new TextField(String.valueOf(p.getPrixoriginal()), "Promotion prixoriginal");
        TextField tfImg = new TextField(p.getImage(), "Promotion image");
        
        

        Button btnValider = new Button("edit Promotion");
        Button btnRet = new Button("Return");
        btnRet.addActionListener(e-> new ProfileForm(res).show() );

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length() == 0)&& (tfPourc.getText().length() == 0) && (tfDesc.getText().length() == 0) && (tfPrixoriginal.getText().length() == 0)  && (tfImg.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        Promotion p = new Promotion(Integer.parseInt(id.getText()), tfNom.getText(), Integer.parseInt(tfPourc.getText()), tfDesc.getText(), Float.parseFloat(tfPrixoriginal.getText()) , tfImg.getText());
                        System.out.println(p.getId());
                        System.out.println("---------");
                        System.out.println(id.getText());
                        if (ServicePromotion.getInstance().modifierPromotion(p)) {
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
        

        addAll(id, tfNom, tfPourc, tfDesc, tfPrixoriginal, tfImg, btnValider,btnRet);
        // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> this.previous.showBack());

    }
}