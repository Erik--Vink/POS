package app;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by Erik on 19-9-2016.
 */
@Data
public abstract class Transaction {
    protected int id;
    protected ArrayList<Product> productsInTransaction;
    protected Card assignedCard;
    protected boolean inProgress;
    protected double totalAmount;

    public Transaction(){
        this.productsInTransaction = new ArrayList<Product>();
        this.inProgress = true;
        this.totalAmount = 0;
    }

    public void finishTransaction(){
        this.inProgress = false;
    }

    public void addProduct(Product product){
        if(inProgress){
            this.productsInTransaction.add(product);
            this.totalAmount += product.getPrice();
        }
    }

    public void setAssignedCard(Card card){
        this.assignedCard = card;
    }
}
