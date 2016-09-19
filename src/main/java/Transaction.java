import java.util.ArrayList;

/**
 * Created by Erik on 19-9-2016.
 */
public abstract class Transaction {
    protected ArrayList<Product> productsInTransaction;
    protected Card assignedCard;

    public Transaction(){
        this.productsInTransaction = new ArrayList<Product>();
    }

    public void addProduct(Product product){
        this.productsInTransaction.add(product);
    }

    public void setAssignedCard(Card card){
        this.assignedCard = card;
    }
}
