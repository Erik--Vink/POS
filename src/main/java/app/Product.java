package app;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Created by Erik on 19-9-2016.
 */
@NoArgsConstructor
@Data
public abstract class Product {
    protected int id;
    protected ArrayList<Product> productList;
    protected Product parent;
    protected String code;
    protected String name;
    protected double price;

    public Product(String code, String name, double price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public abstract int countProducts();
    public abstract boolean add(Product productsToAdd);
    public abstract boolean remove(Product productToRemove);
}
