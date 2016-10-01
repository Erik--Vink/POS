package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Created by Erik on 19-9-2016.
 */
public class PosService {

    public static void fillInventory() {
        Inventory inventory = Inventory.getInventory();
        inventory.addProduct(new SingleProduct("555", "Laptop", 999.99));
    }

    public static Session login(String employeeCode, int deskNumber) {
        if (employeeCode != null && deskNumber != 0) {
            if (Employee.matches(employeeCode)) {
                if (CashDesk.matches(deskNumber)) {
                    return new Session(new Employee(employeeCode), new CashDesk(deskNumber));
                }
            }
        }
        return null;
    }

    public static Transaction createTransaction() {

        InputReader reader = new InputReader();
        TransactionFactory transactionFactory = new TransactionFactory();

        while (true) {
            System.out.println("Which transaction do you want to start? Type 'sale' | 'reservation' | 'refund");

            Transaction transaction = transactionFactory.createTransaction(reader.readInput());
            if (transaction != null) {
                return transaction;
            }
        }
    }

    public static void finishTransaction(Session session, Transaction transaction) {
        transaction.finishTransaction();
        session.addTransaction(transaction);
    }

    public static void addProductToTransaction(Transaction transaction, String productCode) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Product product = mapper.readValue(new URL("http://localhost:8080/api/products/"+productCode), SingleProduct.class);
//            Product product = Inventory.getInventory().getProduct(productCode);
            if(product != null){
                transaction.addProduct(product);
                System.out.println(product.getName() + " added.");
            }
            else{
                System.out.println("Invalid product code");
            }
            }
            catch(MalformedURLException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
}
