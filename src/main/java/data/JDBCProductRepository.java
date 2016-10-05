package data;

import app.Product;
import app.SingleProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Erik on 22-9-2016.
 */
public class JDBCProductRepository implements ProductRepository {

    private Connection connection;
    private int idCounter;
    private ArrayList<Product> products;

    public JDBCProductRepository(){
        this.setConnection();
    }

    private void setConnection() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            this.connection = DriverManager.getConnection( "jdbc:oracle:thin:@//localhost:1521/XE", "erik", "oracle");

            DatabaseMetaData meta = connection.getMetaData();

            System.out.println(meta.getDriverVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Product> getAll() {
        try {
            Statement statement = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM Products";
            ResultSet resultSet = statement.executeQuery(query);
//            connection.close();

            ArrayList<Product> products = new ArrayList<>();
            while( resultSet.next()){
                SingleProduct product = new SingleProduct();
                product.setCode(resultSet.getString("CODE"));
                product.setName(resultSet.getString("NAME"));
                //            product.setParent(resultSet.getString("PARENT"));
                product.setPrice((double) resultSet.getFloat("PRICE"));
                products.add(product);
            }

            resultSet.close();
            return products;

//            return resultSetToProducts(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
    public Product create(String code, String name, double price) {
        idCounter++;
        Product product = new SingleProduct(code, name, price);
        product.setId(idCounter);
        products.add(product);
        return product;
    }

    @Override
    public Product create(Product product) {
        idCounter++;
        product.setId(idCounter);
        products.add(product);
        return product;
    }

    private ArrayList<Product> resultSetToProducts(ResultSet resultSet) throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
            while( resultSet.next()){
                SingleProduct product = new SingleProduct();
                product.setCode(resultSet.getString("CODE"));
                product.setName(resultSet.getString("NAME"));
    //            product.setParent(resultSet.getString("PARENT"));
                product.setPrice((double) resultSet.getFloat("PRICE"));
                products.add(product);
            }

        resultSet.close();
        return products;
    }
}
