package app;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@NoArgsConstructor
@Data
public class Session {
    private int id;
    private LocalDateTime startTimestamp;
    private ArrayList<Transaction> transactions;
    private Employee employee;
    private CashDesk cashDesk;

    public Session(Employee employee, CashDesk cashDesk){
        this.transactions = new ArrayList<Transaction>();
        this.employee = employee;
        this.cashDesk = cashDesk;
        this.startTimestamp = LocalDateTime.now();
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public void closeSession(){
        //todo: Save session to daily closure
        this.startTimestamp = null;
        this.transactions = new ArrayList<Transaction>();
        this.employee = null;
        this.cashDesk = null;
    }


}
