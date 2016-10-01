package data;

import app.Employee;

/**
 * Created by Erik on 22-9-2016.
 */
public interface EmployeeRepository {
    Employee getById(int id);
    Employee getByCode(String code);
    Employee create(String code);
}
