package app;

import java.util.ArrayList;

/**
 * Created by Erik on 19-9-2016.
 */
public abstract class Transaction {
    protected ArrayList<Product> productsInTransaction;
    protected Card assignedCard;
    protected boolean inProgress;
    protected double totalAmount;

    public Transaction(){
        this.productsInTransaction = new ArrayList<Product>();
        this.inProgress = true;
    }

    public void finishTransaction(){
        this.inProgress = false;
    }

    public void addProduct(Product product){
        if(inProgress){
            this.productsInTransaction.add(product);
        }
    }

    public void setAssignedCard(Card card){
        this.assignedCard = card;
    }
}
