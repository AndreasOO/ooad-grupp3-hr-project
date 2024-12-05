package Database;

import java.util.*;

public class EmployeeDatabase {

    List<Employee> employees;
    HashMap<Long, Employee> Employees = new HashMap<>();

    public EmployeeDatabase() {
        loadMap();
        employees = new ArrayList<>();

    }

    public void loadMap() {
        employees = Arrays.asList(
                new Employee(203214, "Andreas Ohlander", 85900, Position.PRODUCTOWNER),
                new Employee(1000, "Elsa", 20000, Position.DEVELOPER),
                new Employee(2345, "Karen", 20000, Position.SUBORDINATE),
                new Employee(1, "Tommy Olsson", 100, Position.CHEF),
                new Employee(123465, "Linn Edvardsson", 100000, Position.MANAGER),
                new Employee(539895, "Jesper Lindberg", 76000, Position.DEVELOPER),
                new Employee(45660, "Josefin Törner", 900000, Position.VD),
                new Employee(758938, "Ylva Fröjdmark", 33000, Position.SCRUM_MASTER),
                new Employee(319487, "Simba", 12000, Position.SUBORDINATE)
        );
        employees.forEach(employee -> {
            Employees.put(employee.getEmployeeId(), employee);
        });

    }
}
