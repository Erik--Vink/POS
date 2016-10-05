package data.test;

import app.Session;
import data.CashDeskRepository;
import data.EmployeeRepository;
import data.SessionRepository;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Erik on 22-9-2016.
 */
public class DummySessionRepository implements SessionRepository {

    private static DummySessionRepository dummySessionRepository;
    private static int idCounter;
    private static ArrayList<Session> sessions;
    private static EmployeeRepository employeeRepository;
    private static CashDeskRepository cashDeskRepository;

    private DummySessionRepository(){
        idCounter = 0;
        sessions = new ArrayList<>();
        employeeRepository = DummyEmployeeRepository.getInstance();
        cashDeskRepository = DummyCashDeskRepository.getInstance();

    }

    public static DummySessionRepository getInstance(){
        if(dummySessionRepository == null){
            dummySessionRepository = new DummySessionRepository();
        }
        return dummySessionRepository;
    }

    @Override
    public Session getById(int sessionId) {
        Predicate<Session> predicate = p-> p.getId() == sessionId;
        return sessions.stream().filter(predicate).findFirst().get();
    }

    @Override
    public Session create(int employeeId, int cashDeskId) {
        idCounter++;
        Session session = new Session(employeeRepository.getById(employeeId), cashDeskRepository.getById(cashDeskId));
        session.setId(idCounter);
        sessions.add(session);
        return null;
    }
}
