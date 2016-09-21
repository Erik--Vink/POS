package app;

import java.util.HashMap;

public class Inventory {

    private static Inventory inventory;
    private static HashMap<String, Product> products;

    private Inventory() {}

    public static Inventory getInventory(){
        if(inventory == null){
            inventory = new Inventory();
            products = new HashMap<String, Product>();
        }
        return inventory;
    }

    public void addProduct(Product product){
        products.put(product.getCode(), product);
    }

    public HashMap<String, Product> getAllProducts(){
        //Todo fill with dummy products
        return products;
    }

    public Product getProduct(String code){
        return products.get(code);
    }
}
