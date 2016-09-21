package app;

/**
 * Created by Erik on 19-9-2016.
 */
public class SingleProduct extends Product{

    public SingleProduct(String code, String name, double price){
        super(code, name, price);
    }

    public int countProducts() {
        return 1;
    }

    public boolean add(Product productsToAdd) {
        return false;
    }

    public boolean remove(Product productToRemove) {
        return false;
    }
}
