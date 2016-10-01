package data;

import app.CashDesk;
import app.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Erik on 22-9-2016.
 */
public class DummyCashDeskRepository implements CashDeskRepository {

    private static DummyCashDeskRepository dummyCashDeskRepository;
    private static int idCounter;
    private static ArrayList<CashDesk> cashDesks;

    private DummyCashDeskRepository(){
        idCounter = 0;
        cashDesks = new ArrayList<>();
    }

    public static DummyCashDeskRepository getInstance(){
        if(dummyCashDeskRepository == null){
            dummyCashDeskRepository = new DummyCashDeskRepository();
        }
        return dummyCashDeskRepository;
    }

    @Override
    public CashDesk create(int number) {
        idCounter++;
        CashDesk cashDesk = new CashDesk(number);
        cashDesks.add(cashDesk);
        return cashDesk;
    }

    @Override
    public CashDesk getByNumber(int number) {
        Predicate<CashDesk> predicate = p-> p.getNumber() == number;
        return cashDesks.stream().filter(predicate).findFirst().get();
    }

    @Override
    public CashDesk getById(int cashDeskId) {
        Predicate<CashDesk> predicate = p-> p.getId() == cashDeskId;
        return cashDesks.stream().filter(predicate).findFirst().get();
    }
}
