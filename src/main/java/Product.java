import lombok.Getter;

import java.util.ArrayList;

/**
 * Created by Erik on 19-9-2016.
 */
public abstract class Product {
    protected ArrayList<Product> productList;
    protected Product parent;
    @Getter protected String code;
    @Getter protected String name;
    @Getter protected double price;

    public abstract int countProducts();

    public abstract boolean add(Product productsToAdd);
    public abstract boolean remove(Product productToRemove);

    public void setParent(Product parentIn) {this.parent = parentIn; }
    public Product getParent() {return this.parent;}
}
