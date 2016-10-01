package service;

import app.Inventory;
import app.Product;
import app.SingleProduct;
import data.DummyProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Map;

@Path("/products")
public class ProductResource {
    @Context
    UriInfo uriInfo;

    @GET @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAll(){
        return DummyProductRepository.getInstance().getAll();
    }


    @GET @Path("/{code}")
    public Product getOne(@PathParam("code") int code){
        return DummyProductRepository.getInstance().getByCode(String.valueOf(code));
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(SingleProduct product){
        DummyProductRepository.getInstance().create(product);

        return Response.created(uriInfo.getAbsolutePath()).build();
    }

}
