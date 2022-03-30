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
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.services.ServiceCategory;

/**
 *
 * @author bhk
 */
public class ListTasksForm extends Form {

    public ListTasksForm(Resources res) {
        setTitle("Liste des categories");
        setLayout(BoxLayout.y());
        
        for (Categorie p : ServiceCategory.getInstance().getAllTasks()) {
            
            MultiButton mb = new MultiButton(p.toString());
           
            
        add(mb);

        
        //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
         Button btnret = new Button("return");
        
            btnret.addActionListener(e -> new ProfileForm(res).show());
        
        Button ajouter = new Button("Ajouter");
            ajouter.addActionListener(e -> new AddCategory(res).show());
            
            add(ajouter);
            add(btnret);

    }
}
