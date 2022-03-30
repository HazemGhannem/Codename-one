
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
import com.mycompany.myapp.entities.Pack;
import com.mycompany.myapp.services.ServicePack;

/**
 *
 * @author Hazem
 */
public class AddPack extends Form{
    public AddPack(Resources res) {
        setTitle("Add a new pack");
        setLayout(BoxLayout.y());
        
        TextField tfDesc = new TextField("","description");
        TextField tfType = new TextField("","type");
        TextField tfPrix = new TextField("","Prix");
        
        Button btnValider = new Button("Add pack");
         Button btnret = new Button("return");
        
            btnret.addActionListener(e -> new ProfileForm(res).show());
        
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfPrix.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Pack c = new Pack (tfType.getText().toString(),tfDesc.getText().toString(),tfPrix.getText().toString());
                        if( ServicePack.getInstance().addPack(c))
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
        
        addAll(tfType,tfDesc,tfPrix,btnValider);
        add(btnret);
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    

}
