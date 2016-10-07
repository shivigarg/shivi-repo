package com.xbots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferDao {
	   private static final String FILE_NAME = "C:\\tmp\\Offers.dat";

	   public List<Offer> getAllOffers(){
	         List<Offer> offerList = null;
	         try {
	            File file = new File(FILE_NAME);
	            if (!file.exists()) {
	               Offer offer1 = new Offer("1", "3G 1 GB Add On", new Date(),100);
	               Offer offer2 = new Offer("2", "4G 1 GB Add On", new Date(),150);
	               offerList = new ArrayList<Offer>();
	               offerList.add(offer1);
	               offerList.add(offer2);
	               saveOfferList(offerList);		
	            }
	            else{
	               FileInputStream fis = new FileInputStream(file);
	               ObjectInputStream ois = new ObjectInputStream(fis);
	               offerList = (List<Offer>) ois.readObject();
	               ois.close();
	            }
	         } catch (IOException e) {
	            e.printStackTrace();
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         }		
	         return offerList;
	      }


	   public List<Offer> getOffer(String id){
	       List<Offer> offers = getAllOffers();

	       for(Offer offer: offers){
	          if(offer.getId().equals(id)){
	        	  List<Offer> offerList = new ArrayList<Offer>();
	        	  offerList.add(offer);
	        	  return offerList;
	          }
	       }
	       return null;
	    }
	      private void saveOfferList(List<Offer> offerList){
	         try {
	            File file = new File(FILE_NAME);
	            FileOutputStream fos;

	            fos = new FileOutputStream(file);

	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(offerList);
	            oos.close();
	         } catch (FileNotFoundException e) {
	            e.printStackTrace();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }   
	   }