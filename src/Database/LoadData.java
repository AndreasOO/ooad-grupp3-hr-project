package Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadData {

    List<Employee> employees;

    LoadData() {

        employees = Arrays.asList(
                new Employee(203214, "Andreas Ohlander", 85900, Position.PRODUCT_OWNER),
                new Employee(1000, "Elsa", 20000, Position.DEVELOPER),
                new Employee(2345, "Karen", 20000, Position.SUBORDINATE),
                new Employee(1, "Tommy Olsson", 100, Position.CHEF),
                new Employee(123465, "Linn Edvardsson", 100000, Position.MANAGER),
                new Employee(539895, "Jesper Lindberg", 76000, Position.DEVELOPER),
                new Employee(45660, "Josefin Törner", 900000, Position.VD),
                new Employee(758938, "Ylva Fröjdmark", 33000, Position.SCRUM_MASTER),
                new Employee(319487, "Simba", 12000, Position.SUBORDINATE),
                new Employee(31, "Fairy Godmother", 12000, Position.DEVELOPER),
                new Employee(329487, "The Phantom Blot", 500, Position.SUBORDINATE),
                new Employee(339487, "Beagle Boy 167–671", 12000, Position.MANAGER),
                new Employee(349487, "Aurora S. Beautée", 150000, Position.VD),
                new Employee(31999, "Old Reliable", 7000, Position.SUBORDINATE),
                new Employee(4297, "Pärlan", 50000, Position.DEVELOPER),
                new Employee(4539487, "Hen Wise t. Little", 12000, Position.MANAGER),
                new Employee(469487, "Mrs Pongo", 150000, Position.VD),
                new Employee(479487, "Mary Poppins", 50, Position.CHEF),
                new Employee(489487, "Archimedes Who", 50, Position.SUBORDINATE)
        );
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
