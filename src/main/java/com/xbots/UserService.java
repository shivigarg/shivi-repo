package com.xbots;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

   UserDao userDao = new UserDao();

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_JSON)
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }	
   
   @GET
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_JSON)
   public List<User> getUser(@PathParam("userid") String userid){
      return userDao.getUser(userid);
   }
   
}