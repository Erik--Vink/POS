package app;

/**
 * Created by Erik on 21-9-2016.
 */
public class TransactionFactory {

    public Transaction createTransaction(String type) {
        TransactionType transactionType = TransactionType.fromString(type);
        if(transactionType == null){
            System.out.println("Invalid transaction type");
            return null;
        }
        else{
            Transaction transaction;

            switch (transactionType) {
                case SALE:
                    transaction = new SaleTransaction();
                    break;
                case RESERVATION:
                    transaction = new ReservationTransaction();
                    break;
                case REFUND:
                    transaction = new RefundTransaction();
                    break;
                default:
                    return null;
            }
            return transaction;
        }
    }
}
