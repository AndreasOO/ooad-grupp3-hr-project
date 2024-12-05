package Database;

import java.util.*;

public class EmployeeDatabase {

    List<Employee> employees;
    HashMap<Long, Employee> Employees = new HashMap<>();

    public EmployeeDatabase() {
        LoadData ld = new LoadData();
        employees = new ArrayList<>(ld.getEmployees());
        loadMap();

    }

    public void loadMap() {

        employees.forEach(employee -> {
            Employees.put(employee.getEmployeeId(), employee);
        });
    }
}
