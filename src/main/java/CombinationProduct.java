import java.util.ArrayList;

public class CombinationProduct extends Product{

    public CombinationProduct(String name, double price){
        this.productList = new ArrayList<Product>();
        this.setName(name);
        this.setPrice(price);
    }

    public int countProducts() {
        int totalProducts = 0;
        for(Product product :this.productList){
            totalProducts+= product.countProducts();
        }
        return totalProducts;
    }

    public boolean add(Product productsToAdd) {
        productsToAdd.setParent(this);
        return this.productList.add(productsToAdd);
    }

    public boolean remove(Product productToRemove) {
        for(Product product :this.productList){
            if(product == productToRemove){
                this.productList.remove(product);
                return true;
            }
        }

        return false;
    }
}
