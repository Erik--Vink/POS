package data.test;

import app.Product;
import app.Transaction;
import app.TransactionFactory;
import data.ProductRepository;
import data.SessionRepository;
import data.TransactionRepository;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Erik on 22-9-2016.
 */
public class DummyTransactionRepository implements TransactionRepository {

    private static DummyTransactionRepository dummyTransactionRepository;
    private static int idCounter;
    private static SessionRepository sessionRepository;
    private static ProductRepository productRepository;
    private static ArrayList<Transaction> transactions;
    private static TransactionFactory transactionFactory;


    private DummyTransactionRepository(){
        idCounter = 0;
        sessionRepository = DummySessionRepository.getInstance();
        transactions = new ArrayList<>();
        transactionFactory = new TransactionFactory();
        productRepository = DummyProductRepository.getInstance();
    }

    public static DummyTransactionRepository getInstance(){
        if(dummyTransactionRepository == null){
            dummyTransactionRepository = new DummyTransactionRepository();
        }
        return dummyTransactionRepository;
    }

    @Override
    public ArrayList<Transaction> getBySession(int sessionId) {
        return sessionRepository.getById(sessionId).getTransactions();
    }

    @Override
    public Transaction getById(int transactionId) {
        Predicate<Transaction> predicate = p-> p.getId() == transactionId;
        return transactions.stream().filter(predicate).findFirst().get();
    }

    @Override
    public Transaction create(String type) {
        idCounter++;
        Transaction transaction = transactionFactory.createTransaction(type);
        transaction.setId(idCounter);
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public void addProductToTransaction(int transactionId, String productCode) {
        Transaction transaction = getById(transactionId);
        Product product = productRepository.getByCode(productCode);
        transaction.addProduct(product);
    }
}
