package com.example.dit.resteasy;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/onlineshop")
public class OnlineShop {
	
	private ShopDAO dao = new ShopDAO();

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";    
    }
    
    @GET
    @Path("/getallproducts")
    @Produces("application/xml")
    public List<Product> getAll() {
        return dao.getAllProducts();
    }

}
