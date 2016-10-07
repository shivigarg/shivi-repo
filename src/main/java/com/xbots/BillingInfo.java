package com.xbots;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "billinginfo")
public class BillingInfo implements Serializable {

   private static final long serialVersionUID = 1L;
   private String id;
   private double billamount;

   public BillingInfo(){}
   
   public BillingInfo(String id, double billAmount){
      this.id = id;
      this.billamount = billAmount;
   }

   public String getId() {
      return id;
   }

   @XmlElement
   public void setId(String id) {
      this.id = id;
   }
   public double getBillAmount() {
      return billamount;
   }
   @XmlElement
   public void setBillAmount(double billAmount) {
      this.billamount = billAmount;
   }
}