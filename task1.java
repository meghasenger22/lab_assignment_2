import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Employee {
    private String employeeID;
    private String name;
    private int age;
    private int salary;

    public Employee(String employeeID, String name, int age, int salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-5d%-8d", employeeID, name, age, salary);
    }
}

public class EmployeeSorter {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("161E90", "Ramu", 35, 59000));
        employees.add(new Employee("171E22", "Tejas", 30, 82100));
        employees.add(new Employee("171G55", "Abhi", 25, 100000));
        employees.add(new Employee("152K46", "Jaya", 32, 85000));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose sorting parameter:");
        System.out.println("1. Age");
        System.out.println("2. Name");
        System.out.println("3. Salary");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Collections.sort(employees, Comparator.comparingInt(Employee::getAge));
                break;
            case 2:
                Collections.sort(employees, Comparator.comparing(Employee::getName));
                break;
            case 3:
                Collections.sort(employees, Comparator.comparingInt(Employee::getSalary));
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        System.out.println("Sorted Employee Table:");
        System.out.printf("%-10s%-10s%-5s%-8s%n", "EmployeeID", "Name", "Age", "Salary");
        System.out.println("-------------------------------");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        scanner.close();
    }
}
