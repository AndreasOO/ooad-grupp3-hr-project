package Database;

import java.util.*;

public class EmployeeDatabase {

    HashMap<Long, Employee> Employees = new HashMap<>();

    public EmployeeDatabase() {
        LoadData ld = new LoadData();
        loadMap(ld);
    }

    public void loadMap(LoadData loadData) {
        loadData.getEmployees().forEach(employee -> {
            Employees.put(employee.getEmployeeId(), employee);
        });
    }

    public List<Employee> searchByID(long id) {
        List<Employee> result = new ArrayList<>();
        if (Employees.containsKey(id)) {
            result.add(Employees.get(id));
        }
        return result;
    }

    public List<Employee> searchByName(String search) {
        List<Employee> matchingEmployees = new ArrayList<>();
        for (Employee employee : Employees.values()) {
            if (employee.getName().trim().equalsIgnoreCase(search.trim())) {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }
}
