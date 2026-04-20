package com.example.dit.resteasy;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/onlineshop")
public class OnlineShop {
	
	private ShopDAO dao = new ShopDAO();

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public Response hello(){
        return Response.ok("Hello World").build();    
    }
    
    @GET
    @Path("/getallproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAll() {
        return dao.getAllProducts();
    }
    
    @POST
    @Path("/addproduct")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addProduct(Product product) 
    {
            dao.persist(product);
            return Response.ok("Product added successfully").build();
        
    }
    //Login
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(
        @FormParam("username") String username,
        @FormParam("password") String password) {

        User user = dao.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return Response.ok("Invalid username or password").build();
        }
        return Response.ok("Login successful. Role: " + user.getAccountType()).build();
    }

    
    //Register
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    public Response register(
        @FormParam("username") String username,
        @FormParam("password") String password,
        @FormParam("email") String email,
        @FormParam("address") String address) {

        User existing = dao.getUserByUsername(username);
        if (existing != null) {
            return Response.ok("Username already taken").build();
        }
        User user = new User(username, password, "CUSTOMER", email, address);
        dao.persist(user);
        return Response.ok("Registered successfully").build();
    }
    
 

}
