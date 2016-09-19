import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Session {
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


}
