package com.xbots;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/OfferService")
public class OfferService {
	OfferDao offerDao = new OfferDao();

	   @GET
	   @Path("/offers")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Offer> getOfferers(){
	      return offerDao.getAllOffers();
	   }	
	   
	   @GET
	   @Path("/offers/{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Offer> getUser(@PathParam("id") String id){
	      return offerDao.getOffer(id);
	   }
}
