package data;

import app.Product;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Erik on 22-9-2016.
 */
public interface ProductRepository {
    ArrayList<Product> getAll() throws SQLException;
    Product getById(int id);
    Product getByCode(String code);
    int create(String code, String name, double price);
    int create(Product product);
}
