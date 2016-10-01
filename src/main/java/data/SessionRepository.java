package data;

import app.Employee;
import app.Session;

/**
 * Created by Erik on 22-9-2016.
 */
public interface SessionRepository {
    Session getById(int sessionId);
    Session create(int employeeId, int cashDeskId);
}
