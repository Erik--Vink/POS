package service;

import app.Product;
import app.SingleProduct;
import app.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jndi.toolkit.url.Uri;
import data.DummyTransactionRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    @Context
    UriInfo uriInfo;

    @POST @Path("/sale")
    public Response createTransactionSale(){
        Transaction transaction = DummyTransactionRepository.getInstance().create("sale");
        return Response.created(uriInfo.getAbsolutePath()).build();
    }

    @POST @Path("/reservation")
    public Response createTransactionReservation(){
        Transaction transaction = DummyTransactionRepository.getInstance().create("reservation");
        return Response.created(uriInfo.getAbsolutePath()).build();
    }

    @POST @Path("/refund")
    public Response createTransactionRefund(){
        Transaction transaction = DummyTransactionRepository.getInstance().create("refund");
        return Response.created(uriInfo.getAbsolutePath()).build();
    }

    @GET
    public ArrayList<Product> getAll(){
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new SingleProduct("555", "Laptop", 99.99));
        return products;
    }

    @POST @Path("/{transactionId}/product/{productId}")
    public static void addProductToTransaction(@PathParam("transactionId") int transactionId, @PathParam("productId") String productCode) {
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            Product product = mapper.readValue(new URL("http://localhost:8080/api/products/"+productCode), SingleProduct.class);
////            Product product = Inventory.getInventory().getProduct(productCode);
//            if(product != null){
//                transaction.addProduct(product);
//                System.out.println(product.getName() + " added.");
//            }
//            else{
//                System.out.println("Invalid product code");
//            }
//        }
//        catch(MalformedURLException e) {
//            e.printStackTrace();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
    }

    @GET @Path("/{id}")
    public Product getOne(@PathParam("id") int id){
        return new SingleProduct(String.valueOf(id), "Laptop", 99.99);
    }


}
