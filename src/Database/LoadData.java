package Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadData {

    List<Employee> employees;

    LoadData() {

        employees = Arrays.asList(
                new Employee(203214, "Andreas Ohlander", 85900, Position.PRODUCTOWNER, "andreas.ohlander@help.nu", "0700987654", 100),
                new Employee(1000, "Elsa", 20000, Position.DEVELOPER, "elsa@frost.com", "07384739203", 40),
                new Employee(2345, "Karen", 20000, Position.SUBORDINATE, "Karen.butter@gmail.com", "07034461562", 100),
                new Employee(1, "Tommy Olsson", 100, Position.CHEF, "tommyOlsson@help.nu", "0762536472", 80),
                new Employee(123465, "Linn Edvardsson", 100000, Position.MANAGER, "linn.edvardsson@help.nu", "0726354627", 100),
                new Employee(539895, "Jesper Lindberg", 76000, Position.DEVELOPER, "jesperLindberg@gmail.com", "07233445566", 100),
                new Employee(45660, "Josefin Törner", 900000, Position.VD, "jossan.Torner@hej.nu", "07232323232", 100),
                new Employee(758938, "Ylva Fröjdmark", 33000, Position.SCRUM_MASTER, "ylva.frojdmark@huhu.nu", "07321673625", 100),
                new Employee(319487, "Simba", 12000, Position.SUBORDINATE,"simba@lejon.se", "secret", 45),
                new Employee(31, "Fairy Godmother", 12000, Position.DEVELOPER, "God@mother.nu", "123123", 80),
                new Employee(329487, "The Phantom Blot", 500, Position.SUBORDINATE, "help@help.nu", "098765", 50),
                new Employee(339487, "Beagle Boy 167–671", 12000, Position.MANAGER, "beagle@boy.nu", "073454545", 50),
                new Employee(349487, "Aurora S. Beautée", 150000, Position.VD, "aurora@s.com", "098098", 75),
                new Employee(31999, "Old Reliable", 7000, Position.SUBORDINATE, "old@Reliable.se", "000000", 75),
                new Employee(4297, "Pärlan", 50000, Position.DEVELOPER, "pärlan@shiny.com", "098098843", 100),
                new Employee(4539487, "Hen Wise t. Little", 12000, Position.MANAGER, "hen_wise@little.com", "93854352", 50),
                new Employee(469487, "Mrs Pongo", 150000, Position.VD, "mrs@pongo.nui", "987654321", 80),
                new Employee(479487, "Mary Poppins", 50, Position.CHEF, "marry@poppins.se", "123456789", 20),
                new Employee(489487, "Archimedes Who", 50, Position.SUBORDINATE, "archimedes@who.com", "0987890", 20)
        );
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
