import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class exp1 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display Employees\n6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    for (Employee emp : employees) {
                        if (emp.id == updateId) {
                            sc.nextLine();
                            System.out.print("Enter New Name: ");
                            emp.name = sc.nextLine();
                            System.out.print("Enter New Salary: ");
                            emp.salary = sc.nextDouble();
                            System.out.println("Employee updated!");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = sc.nextInt();
                    employees.removeIf(emp -> emp.id == removeId);
                    System.out.println("Employee removed!");
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    for (Employee emp : employees) {
                        if (emp.id == searchId) {
                            System.out.println(emp);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Employee List:");
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
