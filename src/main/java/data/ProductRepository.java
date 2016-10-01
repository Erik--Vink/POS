package data;

import app.Product;

import java.util.ArrayList;

/**
 * Created by Erik on 22-9-2016.
 */
public interface ProductRepository {
    ArrayList<Product> getAll();
    Product getById(int id);
    Product getByCode(String code);
    Product create(String code, String name, double price);
    Product create(Product product);
}
