package SM_EMS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        while (true) {
            System.out.println("**************** Welcome To Employee Management System ****************");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Search Employee by Name");
            System.out.println("7. Search Employee by Department");
            System.out.println("8. Sort Employees by Salary");
            System.out.println("9. Promote Employee");
            System.out.println("10. Generate Department Report");
            System.out.println("11. Mark Attendance");
            System.out.println("12. View Attendance");
            System.out.println("13. Save Employees to File");
            System.out.println("14. Load Employees from File");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 15.");
                scanner.next(); // clear the invalid input
                continue; // skip the rest of the loop and prompt again
            }

            switch (choice) {
                case 1:
                    System.out.println("Add Employee");
                    employeeService.addEmp();
                    break;
                case 2:
                    System.out.println("View Employee");
                    employeeService.viewEmp();
                    break;
                case 3:
                    System.out.println("Update Employee");
                    employeeService.updateEmployee();
                    break;
                case 4:
                    System.out.println("Delete Employee");
                    employeeService.deleteEmp();
                    break;
                case 5:
                    System.out.println("View All Employees");
                    employeeService.viewAllEmps();
                    break;
                case 6:
                    System.out.println("Search Employee by Name");
                    employeeService.searchEmpByName();
                    break;
                case 7:
                    System.out.println("Search Employee by Department");
                    employeeService.searchEmpByDepartment();
                    break;
                case 8:
                    System.out.println("Sort Employees by Salary");
                    employeeService.sortEmployeesBySalary();
                    break;
                case 9:
                    System.out.println("Promote Employee");
                    employeeService.promoteEmployee();
                    break;
                case 10:
                    System.out.println("Generate Department Report");
                    employeeService.generateDepartmentReport();
                    break;
                case 11:
                    System.out.println("Mark Attendance");
                    employeeService.markAttendance();
                    break;
                case 12:
                    System.out.println("View Attendance");
                    employeeService.viewAttendance();
                    break;
                case 13:
                    System.out.println("Save Employees to File");
                    employeeService.saveEmployeesToFile();
                    break;
                case 14:
                    System.out.println("Load Employees from File");
                    employeeService.loadEmployeesFromFile();
                    break;
                case 15:
                    System.out.println("Thank you for using the application!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        }
    }
}
