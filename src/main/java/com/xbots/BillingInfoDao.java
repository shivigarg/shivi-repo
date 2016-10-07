package com.xbots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BillingInfoDao {
   private static final String FILE_NAME = "C:\\tmp\\BillingInfo.dat";

public List<BillingInfo> getAllUsersBillingInfo(){
      List<BillingInfo> billingInfoList = null;
      try {
         File file = new File(FILE_NAME);
         if (!file.exists()) {
            BillingInfo billingInfo = new BillingInfo("gasharma", 100.00);
            BillingInfo billingInfo2 = new BillingInfo("arai", 200.00);
            billingInfoList = new ArrayList<BillingInfo>();
            billingInfoList.add(billingInfo);
            billingInfoList.add(billingInfo2);
            saveUsersBillingInfoList(billingInfoList);		
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            billingInfoList = (List<BillingInfo>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }		
      return billingInfoList;
   }


public List<BillingInfo> getBillAmount(String id){
    List<BillingInfo> billingInfos = getAllUsersBillingInfo();

    for(BillingInfo billingInfo: billingInfos){
       if(billingInfo.getId().equals(id)){
    	   List<BillingInfo> list = new ArrayList<BillingInfo>();
    	   list.add(billingInfo);
          return list;
       }
    }
    return null;
 }
   private void saveUsersBillingInfoList(List<BillingInfo> billingInfoList){
      try {
         File file = new File(FILE_NAME);
         FileOutputStream fos;

         fos = new FileOutputStream(file);

         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(billingInfoList);
         oos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }   
}