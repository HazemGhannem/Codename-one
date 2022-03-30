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
import com.mycompany.myapp.entities.Coupon;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCoupon {

    public ArrayList<Coupon> cat;

    public static ServiceCoupon instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCoupon() {
        req = new ConnectionRequest();
    }

    public static ServiceCoupon getInstance() {
        if (instance == null) {
            instance = new ServiceCoupon();
        }
        return instance;
    }

    public boolean addCoupon(Coupon c) {
        System.out.println(c);
        System.out.println("********");
        String url = Statics.BASE_URL +"coupon/new?nom=" + c.getNom()+"&code=" + c.getCode()+"&pourcentage=" + c.getPourcentage();
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

    public ArrayList<Coupon> parseCoupons(String jsonText) {
        try {
            cat = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> couponsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) couponsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Coupon c = new Coupon();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int) id);
                String nom = obj.get("nom").toString();
                c.setNom(nom);
                String code = obj.get("code").toString();
                c.setCode(code);
                float pourcentage = Float.parseFloat(obj.get("pourcentage").toString());
                c.setPourcentage((float) pourcentage);
                
                cat.add(c);
            }

        } catch (IOException ex) {

        }
        return cat;
    }

    public ArrayList<Coupon> getAllCoupons() {
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/coupons/";
        String url = Statics.BASE_URL + "coupon/";
        System.out.println("===>" + url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cat = parseCoupons(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cat;
    }
    public Coupon DetailCoupon( Coupon c) {
        
        String url = Statics.BASE_URL+"/coupon/"+c.getId();
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                c.setNom(obj.get("nom").toString());
                c.setCode(obj.get("code").toString());
                c.setPourcentage(Float.parseFloat(obj.get("pourcentage").toString()));
               
                
                
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return c;
        
        
    }
    
    

         public boolean  Delete(Coupon c){
       String url = Statics.BASE_URL + "coupon/delete/" +c.getId();
  
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
    public boolean modifierCoupon(Coupon c) {
        String url = Statics.BASE_URL +"coupon/edit/"+c.getId()+"?nom=" + c.getNom()+"&code=" + c.getCode()+"&pourcentage=" + c.getPourcentage();
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
