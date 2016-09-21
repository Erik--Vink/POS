package app;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Created by Erik on 19-9-2016.
 */
public abstract class Product {
    protected ArrayList<Product> productList;
    protected Product parent;
    @Setter @Getter protected String code;
    @Setter @Getter protected String name;
    @Setter @Getter protected double price;

    public Product(String code, String name, double price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public abstract int countProducts();

    public abstract boolean add(Product productsToAdd);
    public abstract boolean remove(Product productToRemove);

    public void setParent(Product parentIn) {this.parent = parentIn; }
    public Product getParent() {return this.parent;}
}
