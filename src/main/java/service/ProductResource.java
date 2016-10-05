package service;

import app.Product;
import app.SingleProduct;
import data.DatabaseConnection;
import data.jdbc.JDBCProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;

@Path("/products")
public class ProductResource {
    @Context
    UriInfo uriInfo;

    @GET @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAll(){
        JDBCProductRepository repository =  new JDBCProductRepository(new DatabaseConnection());
        ArrayList<Product> products = repository.getAll();
        return products;
    }


    @GET @Path("/{code}") @Produces(MediaType.APPLICATION_JSON)
    public Product getOne(@PathParam("code") String code){
        JDBCProductRepository repository =  new JDBCProductRepository(new DatabaseConnection());
        return repository.getByCode(code);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(SingleProduct product){

        JDBCProductRepository repository =  new JDBCProductRepository(new DatabaseConnection());
        int id = repository.create(product);

        UriBuilder builder = UriBuilder.fromUri(uriInfo.getAbsolutePath());
        builder.path(Integer.toString(id));
        return Response.created(builder.build()).build();
    }

}
