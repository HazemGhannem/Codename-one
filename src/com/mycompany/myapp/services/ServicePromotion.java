/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Promotion;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bouss
 */
public class ServicePromotion {
     public ArrayList<Promotion> Promo;

    public static ServicePromotion instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicePromotion() {
        req = new ConnectionRequest();
    }

    public static ServicePromotion getInstance() {
        if (instance == null) {
            instance = new ServicePromotion();
        }
        return instance;
    }

    public boolean addPromotion(Promotion p) {
        System.out.println(p);
        System.out.println("********");
        String url = Statics.BASE_URL +"promotion/new?nom=" + p.getNom()+"&pourcentage=" + p.getPourcentage()+"&Description=" +p.getDescription()+"&prixoriginal=" + p.getPrixoriginal()+"&image=" + p.getImage();
        //String url = Statics.BASE_URL + "create";

        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Promotion> parsePromotions(String jsonText) {
        try {
            Promo = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> promotionsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) promotionsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Promotion p = new Promotion();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int) id);
                String nom = obj.get("nom").toString();
                p.setNom(nom);
               float pourcentage = Float.parseFloat(obj.get("pourcentage").toString());
                p.setPourcentage((int) pourcentage);
                String desc = obj.get("description").toString();
                p.setDescription(desc);
                float prixoriginal = Float.parseFloat(obj.get("prixoriginal").toString());
                p.setPrixoriginal((int) prixoriginal);
                p.setPrixpromotion((float) prixoriginal-((float) prixoriginal*(int) pourcentage)/100);
                String image = obj.get("image").toString();
                p.setImage(image);
                
                
                
                Promo.add(p);
            }

        } catch (IOException ex) {

        }
        return Promo;
    }

    public ArrayList<Promotion> getAllPromotion() {
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL + "promotion/aff";
        System.out.println("===>" + url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Promo = parsePromotions(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Promo;
    }
    
     public Promotion DetailPromotion( Promotion p) {
        
        String url = Statics.BASE_URL+"/promotion/"+p.getId();
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                p.setNom(obj.get("nom").toString());
                p.setPourcentage(Integer.parseInt(obj.get("pourcentage").toString()));
                p.setDescription(obj.get("description").toString());
                p.setPrixoriginal(Integer.parseInt(obj.get("prixoriginal").toString()));
                p.setPrixoriginal(Integer.parseInt(obj.get("prixpromotion").toString()));
                p.setImage(obj.get("image").toString());
                
                
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return p;
        
        
    }
    
    

         public boolean  Delete(Promotion p){
       String url = Statics.BASE_URL + "promotion/delete/" +p.getId();
  
        req.setUrl(url);
        req.setPost(false);
        req.setFailSilently(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                 resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
    
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;

      
}
             //Update 
    public boolean modifierPromotion(Promotion p) {
        String url = Statics.BASE_URL +"promotion/edit/"+p.getId()+"?nom=" + p.getNom()+"&pourcentage=" + p.getPourcentage()+"&Description=" +p.getDescription()+"&prixoriginal=" + p.getPrixoriginal()+"&image=" + p.getImage();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOK;
        
    }

}

 
 
