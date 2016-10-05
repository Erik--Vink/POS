package data.test;

import app.Product;
import app.SingleProduct;
import data.ProductRepository;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Erik on 22-9-2016.
 */
public class DummyProductRepository implements ProductRepository {

    private static DummyProductRepository dummyProductRepository;
    private static int idCounter;
    private static ArrayList<Product> products;

    private DummyProductRepository(){
        idCounter = 0;
        products = new ArrayList<>();
    }

    public static DummyProductRepository getInstance(){
        if(dummyProductRepository == null){
            dummyProductRepository = new DummyProductRepository();
        }
        return dummyProductRepository;
    }

    @Override
    public ArrayList<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        Predicate<Product> predicate = p-> p.getId() == id;
        return products.stream().filter(predicate).findFirst().get();
    }

    @Override
    public Product getByCode(String code) {
        Predicate<Product> predicate = p-> p.getCode().equals(code);
        return products.stream().filter(predicate).findFirst().get();
    }

    @Override
    public int create(String code, String name, double price) {
        idCounter++;
        Product product = new SingleProduct(code, name, price);
        product.setId(idCounter);
        products.add(product);
        return product.getId();
    }

    @Override
    public int create(Product product) {
        idCounter++;
        product.setId(idCounter);
        products.add(product);
        return product.getId();
    }
}
