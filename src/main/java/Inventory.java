import java.util.ArrayList;

public class Inventory {

    private static Inventory inventory;
    private static ArrayList<Product> products;

    private Inventory() {}

    public static Inventory getInventory(){
        if(inventory == null){
            inventory = new Inventory();
            products = new ArrayList<Product>();
        }
        return inventory;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public ArrayList<Product> getAllProducts(){
        //Todo fill with dummy products
        return products;
    }
}
