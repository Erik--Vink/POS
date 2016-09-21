package app;

/**
 * Created by Erik on 19-9-2016.
 */
public class SolidDiscount implements Discount {

    private double amount;

    public SolidDiscount(double amount){
        this.amount = amount;
    }

    public double getPriceIncludingDiscount(Product product) {
        double price = 0;
        if(product.getPrice() - amount > 0){
            price = product.getPrice() - amount;
        }
        return price;
    }
}
