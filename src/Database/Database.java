package Database;

import java.util.*;

public class Database {

    HashMap<Long, Employee> employees = new HashMap<>();

    public Database() {
        LoadData dataLoader = new LoadData();
        loadMap(dataLoader);
    }

    public void loadMap(LoadData loadData) {
        loadData.getEmployees().forEach(employee -> {
            employees.put(employee.getEmployeeId(), employee);
        });
    }

    public List<Employee> searchByID(long id) {
        List<Employee> result = new ArrayList<>();
        if (employees.containsKey(id)) {
            result.add(employees.get(id));
        }
        return result;
    }

    public List<Employee> searchByPhoneNumber(String phoneNumber) {
        List<Employee> result = new ArrayList<>();
        if (employees.containsKey(phoneNumber)) {
            result.add(employees.get(phoneNumber));
        }
        return result;
    }

    public List<Employee> searchByName(String search) {
        List<Employee> matchingEmployees = new ArrayList<>();
        String temp = search.toLowerCase();
        for (Employee employee : employees.values()) {
            if (employee.getName().toLowerCase().contains(temp.trim())) {

                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }
}
