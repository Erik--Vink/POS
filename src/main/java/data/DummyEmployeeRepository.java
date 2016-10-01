package data;

import app.Employee;
import app.Product;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Erik on 22-9-2016.
 */
public class DummyEmployeeRepository implements EmployeeRepository {

    private static DummyEmployeeRepository dummyEmployeeRepository;
    private static int idCounter;
    private ArrayList<Employee> employees;

    private DummyEmployeeRepository(){
        idCounter = 0;
        employees = new ArrayList<>();
    }

    public static DummyEmployeeRepository getInstance(){
        if(dummyEmployeeRepository == null){
            dummyEmployeeRepository = new DummyEmployeeRepository();
        }
        return dummyEmployeeRepository;
    }

    @Override
    public Employee getById(int id) {
        Predicate<Employee> predicate = p-> p.getId() == id;
        return employees.stream().filter(predicate).findFirst().get();
    }

    @Override
    public Employee getByCode(String code) {
        Predicate<Employee> predicate = p-> p.getCode().equals(code);
        return employees.stream().filter(predicate).findFirst().get();
    }

    @Override
    public Employee create(String code) {
        idCounter++;
        Employee employee = new Employee(code);
        employee.setId(idCounter);
        employees.add(employee);
        return null;
    }
}
