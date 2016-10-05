package service;

import app.Inventory;
import app.Product;
import app.SingleProduct;
import data.DummyProductRepository;
import data.JDBCProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@Path("/products")
public class ProductResource {
    @Context
    UriInfo uriInfo;

    @GET @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAll(){
        JDBCProductRepository repository =  new JDBCProductRepository();
        ArrayList<Product> products = repository.getAll();
        return products;
    }


    @GET @Path("/{code}")
    public Product getOne(@PathParam("code") int code){
        return DummyProductRepository.getInstance().getByCode(String.valueOf(code));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(SingleProduct product){
        Product createdProduct = DummyProductRepository.getInstance().create(product);
        UriBuilder builder = UriBuilder.fromUri(uriInfo.getAbsolutePath());
        builder.path(Integer.toString(createdProduct.getId()));
        return Response.created(builder.build()).build();
    }

}
