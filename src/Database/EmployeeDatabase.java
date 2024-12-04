package Database;

import java.util.*;

public class EmployeeDatabase {

    List<Employee> employees;
    Employee andreas = new Employee(203214, "Andreas Ohlander", 85900, Position.PRODUCTOWNER);
    HashMap<Long, Employee> employeesByPosition = new HashMap<>();

    public EmployeeDatabase(){
        loadMap();
        employees = loadList();

    }

    public Employee findEmployeeById(long id){
        for(Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee findEmployeeByName(String name){
        for(Employee employee : employees){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findEmployeesByPosition(Position position){
        List<Employee> employeesInPosition = new ArrayList<>();
        for(Employee employee : employees){
            if (employee.getPosition().equals(position)){
                employeesInPosition.add(employee);
            }
        }
        return employeesInPosition;
    }

    public List<Employee> loadList(){
        Employee elsa = new Employee(1000, "Elsa", 20000, Position.DEVELOPER);
        Employee Karen = new Employee(2345,  "Karen", 20000, Position.SUBORDINATE );
        Employee tommyOlsson = new Employee(1, "Tommy Olsson", 100, Position.CHEF);
        Employee linn = new Employee(123465, "Linn Edvardsson", 100000, Position.MANAGER);
        Employee jesper = new Employee(539895, "Jesper Lindberg", 76000, Position.DEVELOPER);
        Employee josefin = new Employee(45660, "Josefin Törner", 900000, Position.VD);
        Employee Ylva = new Employee(758938, "Ylva Fröjdmark", 33000, Position.SCRUM_MASTER);
        Employee Simba = new Employee(319487, "Simba", 12000, Position.SUBORDINATE);
        List<Employee> temp = Arrays.asList(andreas, elsa, Karen, tommyOlsson, linn, jesper, josefin, Ylva, Simba);
        return temp;
    }
    public void loadMap() {
        Employee elsa = new Employee(1000, "Elsa", 20000, Position.DEVELOPER);
        Employee Karen = new Employee(2345,  "Karen", 20000, Position.SUBORDINATE );
        Employee tommyOlsson = new Employee(1, "Tommy Olsson", 100, Position.CHEF);
        Employee linn = new Employee(123465, "Linn Edvardsson", 100000, Position.MANAGER);
        Employee jesper = new Employee(539895, "Jesper Lindberg", 76000, Position.DEVELOPER);
        Employee josefin = new Employee(45660, "Josefin Törner", 900000, Position.VD);
        Employee Ylva = new Employee(758938, "Ylva Fröjdmark", 33000, Position.SCRUM_MASTER);
        Employee Simba = new Employee(319487, "Simba", 12000, Position.SUBORDINATE);

        employeesByPosition.put(andreas.getEmployeeId(), andreas);
        employeesByPosition.put(jesper.getEmployeeId(), jesper);
        employeesByPosition.put(Karen.getEmployeeId(), Karen);
        employeesByPosition.put(linn.getEmployeeId(), linn);

    }

//    public String searchByID(String search){
//        Employee employee = employeesByPosition.get(search);
//        if(employeesByPosition.containsKey(search)) {
//            System.out.println(employee.getEmployeeId());
//
//        }
//        return employee.getName().toString();
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        EmployeeDatabase db = new EmployeeDatabase();
//        String input = sc.nextLine();
//        db.searchByID(input);
//
//    }
}
