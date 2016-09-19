/**
 * Created by Erik on 19-9-2016.
 */
public class RefundTransaction extends Transaction {

    public void changeProductPrice(Product product, double price){
        int index;
        if((index = this.productsInTransaction.indexOf(product)) != 0){
            this.productsInTransaction.get(index).setPrice(price);
        }
    }

}
