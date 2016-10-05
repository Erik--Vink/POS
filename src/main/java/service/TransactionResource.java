package service;

import app.Transaction;
import data.test.DummyTransactionRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    @Context
    UriInfo uriInfo;

    @POST @Path("/sale")
    public Response createTransactionSale(){
        Transaction transaction = DummyTransactionRepository.getInstance().create("sale");
        UriBuilder builder = UriBuilder.fromUri(uriInfo.getBaseUri());
        builder.path("transactions/" + Integer.toString(transaction.getId()));
        return Response.created(builder.build()).build();
    }

    @POST @Path("/reservation")
    public Response createTransactionReservation(){
        Transaction transaction = DummyTransactionRepository.getInstance().create("reservation");
        UriBuilder builder = UriBuilder.fromUri(uriInfo.getAbsolutePath());
        builder.path(Integer.toString(transaction.getId()));
        return Response.created(builder.build()).build();
    }

    @POST @Path("/refund")
    public Response createTransactionRefund(){
        Transaction transaction = DummyTransactionRepository.getInstance().create("refund");
        UriBuilder builder = UriBuilder.fromUri(uriInfo.getAbsolutePath());
        builder.path(Integer.toString(transaction.getId()));
        return Response.created(builder.build()).build();
    }

    @POST @Path("/{transactionId}/product/{productCode}")
    public Response addProductToTransaction(@PathParam("transactionId") int transactionId, @PathParam("productCode") String productCode) {
        DummyTransactionRepository.getInstance().addProductToTransaction(transactionId, productCode);
        UriBuilder builder = UriBuilder.fromUri(uriInfo.getAbsolutePath());
        return Response.created(builder.build()).build();
    }

    @GET
    @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
    public Transaction getOne(@PathParam("id") int id){
        return DummyTransactionRepository.getInstance().getById(id);
    }
}
