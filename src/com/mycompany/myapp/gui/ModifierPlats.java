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
import com.mycompany.myapp.entities.Plat;
import com.mycompany.myapp.services.ServicePlat;

/**
 *
 * @author bouss
 */
public class ModifierPlats extends Form {

    Form current;

   public ModifierPlats(Plat p , Resources res) {
        setTitle("Modifier plat");
        setLayout(BoxLayout.y());
        TextField id = new TextField(String.valueOf(p.getId()), "id");
        TextField tfNom = new TextField(p.getNom(), "name");
        TextField tfDesc = new TextField(p.getDesc(), "description");
        TextField tfImg = new TextField(p.getImg(), "image");
        TextField tfPrix = new TextField(String.valueOf(p.getPrix()), "prix");

        Button btnValider = new Button("Modifier");
        Button btnRet = new Button("Retourner");
        btnRet.addActionListener(e-> new ProfileForm(res).show() );

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length() == 0) && (tfDesc.getText().length() == 0) && (tfPrix.getText().length() == 0)  && (tfImg.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        Plat p = new Plat(Integer.parseInt(id.getText()), tfNom.getText(), tfDesc.getText(), tfImg.getText(), Float.parseFloat(tfPrix.getText()));
                        System.out.println(p.getId());
                        System.out.println("---------");
                        System.out.println(id.getText());
                        if (ServicePlat.getInstance().modifierProduct(p)) {
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
        

        addAll(id, tfNom, tfDesc, tfImg, tfPrix , btnValider,btnRet);
//         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> this.previous.showBack());

    }
}