package data;

import app.CashDesk;

/**
 * Created by Erik on 22-9-2016.
 */
public interface CashDeskRepository {

    CashDesk create(int number);
    CashDesk getByNumber(int number);
    CashDesk getById(int cashDeskId);
}
