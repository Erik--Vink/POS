package data.jdbc;

import app.Product;
import app.SingleProduct;
import data.DatabaseConnection;
import data.ProductRepository;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Erik on 22-9-2016.
 */
public class JDBCProductRepository implements ProductRepository {

    private Connection connection;

    public JDBCProductRepository(DatabaseConnection databaseConnection){
        this.connection = databaseConnection.getConnection();
    }

    @Override
    public ArrayList<Product> getAll() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            ArrayList<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                products.add(resultSetToProduct(resultSet));
            }
            resultSet.close();
            this.connection.close();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getById(int id) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM Products where ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            while(resultSet.next()){
                product = resultSetToProduct(resultSet);
            }
            resultSet.close();
            this.connection.close();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getByCode(String code) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM Products where CODE = ?");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            while(resultSet.next()){
                product = resultSetToProduct(resultSet);
            }
            resultSet.close();
            this.connection.close();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int create(String code, String name, double price) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO Products (CODE, NAME, PRICE) VALUES (?,?,?)");
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setFloat(3, (float) price);
            int id = preparedStatement.executeUpdate();
            this.connection.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int create(Product product) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO Products (CODE, NAME, PRICE) VALUES (?,?,?)");
            preparedStatement.setString(1, product.getCode());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setFloat(3, (float) product.getPrice());
            int id = preparedStatement.executeUpdate();
            this.connection.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private Product resultSetToProduct(ResultSet resultSet) throws SQLException {
            SingleProduct product = new SingleProduct();
            product.setId(resultSet.getInt("ID"));
            product.setCode(resultSet.getString("CODE"));
            product.setName(resultSet.getString("NAME"));
//            product.setParent(resultSet.getString("PARENT"));
            product.setPrice((double) resultSet.getFloat("PRICE"));
            return product;
    }
}
