package data;

import app.Product;
import app.Transaction;

import java.util.ArrayList;

/**
 * Created by Erik on 22-9-2016.
 */
public interface TransactionRepository {
    ArrayList<Transaction> getBySession(int sessionId);
    Transaction getById(int transactionId);
    Transaction create(String type);
    void addProductToTransaction(int transactionId, int productId);
}
