package Database;


public class Employee {
    private long employeeId;
    private String name;
    private double salary;
    private Position position;

    public Employee(long employeeId, String name, double salary, Position position) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void getSalary() {

    }

    public Position getPosition() {
        return position;
    }

   public void getWorkingProcentage(double precentage) {

   }
   public void getContactInformation(String contactInfo){

   }

   @Override
   public String toString(){
        return "EmplymentID : " + employeeId + " " + name + " tjänar: " + salary + " position: " + position;
   }
}
