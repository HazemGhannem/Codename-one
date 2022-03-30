/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
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
public class AddPromotion extends Form{
    public AddPromotion(Resources res) {
        setTitle("Add a new promotion");
        setLayout(BoxLayout.y());
        
        TextField tfNom = new TextField("","promotion nom");
        TextField tfPourc = new TextField("","promotion pourcentage");
        TextField tfDesc = new TextField("","promotion description");
        TextField tfPrixoriginal = new TextField("","promotion prixoriginal");
        TextField tfImg = new TextField("","promotion image");
        
        
        
        
        Button btnValider = new Button("Add promotion");
        Button btnret = new Button("return");
        
            btnret.addActionListener(e -> new ProfileForm(res).show());
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length()==0) && (tfPourc.getText().length()==0) && (tfDesc.getText().length()==0)&& (tfPrixoriginal.getText().length()==0) && (tfImg.getText().length()==0) )
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Promotion  p = new Promotion(tfNom.getText().toString(),Integer.parseInt(tfPourc.getText().toString()),tfDesc.getText().toString(),Float.parseFloat(tfPrixoriginal.getText().toString()),tfImg.getText().toString() );
                        if( ServicePromotion.getInstance().addPromotion(p))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfNom,tfPourc,tfDesc,tfPrixoriginal,tfImg,btnValider,btnret);
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
}
