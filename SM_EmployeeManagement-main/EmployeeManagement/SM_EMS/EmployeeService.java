package SM_EMS;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    private HashSet<Employee> empset = new HashSet<>();
    private HashMap<Integer, List<String>> attendanceMap = new HashMap<>(); // For attendance tracking

    private Scanner sc = new Scanner(System.in);

    public EmployeeService() {
        // Initialize with some employees
        empset.add(new Employee(101, "Shital", 24, "Developer", "IT", 25000));
        empset.add(new Employee(102, "Meena", 26, "Tester", "CO", 57000));
        empset.add(new Employee(103, "Bob", 20, "DevOps Eng", "Admin", 5000));
        empset.add(new Employee(104, "Max", 27, "System Eng", "CO", 70000));
    }

    // Add an employee
    public void addEmp() {
        try {
            System.out.println("Enter id:");
            int id = sc.nextInt();
            System.out.println("Enter name:");
            String name = sc.next();
            System.out.println("Enter age:");
            int age = sc.nextInt();
            System.out.println("Enter designation:");
            String designation = sc.next();
            System.out.println("Enter department:");
            String department = sc.next();
            System.out.println("Enter salary:");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, age, designation, department, salary);
            empset.add(emp);
            System.out.println("Employee added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            sc.next(); // Clear the invalid input
        }
    }

    // View all employees
    public void viewAllEmps() {
        for (Employee emp : empset) {
            System.out.println(emp);
        }
    }

    // View an employee by ID
    public void viewEmp() {
        try {
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            boolean found = false;
            for (Employee emp : empset) {
                if (emp.getId() == id) {
                    System.out.println(emp);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Employee with this id is not present.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
            sc.next(); // Clear the invalid input
        }
    }

    // Update an employee
    public void updateEmployee() {
        try {
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            boolean found = false;
            for (Employee emp : empset) {
                if (emp.getId() == id) {
                    System.out.println("Enter new name:");
                    String name = sc.next();
                    System.out.println("Enter new salary:");
                    double salary = sc.nextDouble();
                    emp.setName(name);
                    emp.setSalary(salary);
                    System.out.println("Updated details of employee:");
                    System.out.println(emp);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            } else {
                System.out.println("Employee details updated successfully!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            sc.next(); // Clear the invalid input
        }
    }

    // Delete an employee
    public void deleteEmp() {
        try {
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            boolean found = false;
            Employee empToDelete = null;
            for (Employee emp : empset) {
                if (emp.getId() == id) {
                    empToDelete = emp;
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            } else {
                empset.remove(empToDelete);
                System.out.println("Employee deleted successfully.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
            sc.next(); // Clear the invalid input
        }
    }

    // Search employee by name
    public void searchEmpByName() {
        System.out.println("Enter name: ");
        String name = sc.next();
        boolean found = false;
        for (Employee emp : empset) {
            if (emp.getName().equalsIgnoreCase(name)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with the given name.");
        }
    }

    // Search employee by department
    public void searchEmpByDepartment() {
        System.out.println("Enter department: ");
        String department = sc.next();
        boolean found = false;
        for (Employee emp : empset) {
            if (emp.getDepartment().equalsIgnoreCase(department)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found in the given department.");
        }
    }

    // Sort employees by salary
    public void sortEmployeesBySalary() {
        List<Employee> sortedList = empset.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }

    // Promote an employee
    public void promoteEmployee() {
        try {
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            boolean found = false;
            for (Employee emp : empset) {
                if (emp.getId() == id) {
                    System.out.println("Enter new designation:");
                    String designation = sc.next();
                    System.out.println("Enter new salary:");
                    double salary = sc.nextDouble();
                    emp.setDesignation(designation);
                    emp.setSalary(salary);
                    System.out.println("Employee promoted successfully.");
                    System.out.println(emp);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            sc.next(); // Clear the invalid input
        }
    }

    // Generate department report
    public void generateDepartmentReport() {
        Map<String, List<Employee>> departmentMap = empset.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }

    // Mark attendance
    public void markAttendance() {
        try {
            System.out.println("Enter id:");
            int id = sc.nextInt();
            System.out.println("Enter date (YYYY-MM-DD):");
            String date = sc.next();
            if (!attendanceMap.containsKey(id)) {
                attendanceMap.put(id, new ArrayList<>());
            }
            attendanceMap.get(id).add(date);
            System.out.println("Attendance marked successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            sc.next(); // Clear the invalid input
        }
    }

    // View attendance
    public void viewAttendance() {
        try {
            System.out.println("Enter id:");
            int id = sc.nextInt();
            if (attendanceMap.containsKey(id)) {
                List<String> attendance = attendanceMap.get(id);
                System.out.println("Attendance for employee ID " + id + ": " + attendance);
            } else {
                System.out.println("No attendance records found for this employee.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
            sc.next(); // Clear the invalid input
        }
    }

    // Save employees to file
    public void saveEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(new ArrayList<>(empset));
            System.out.println("Employees saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees to file.");
            e.printStackTrace();
        }
    }

    // Load employees from file
    @SuppressWarnings("unchecked")
    public void loadEmployeesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            empset = new HashSet<>((List<Employee>) ois.readObject());
            System.out.println("Employees loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees from file.");
            e.printStackTrace();
        }
    }
}
