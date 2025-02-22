package javaapplicationlLIM;

import javaapplicationlLIM.LIM;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class LIM2 {
    private static ArrayList<LIM> employeeList = new ArrayList<>();

    public static void run() {
        employeeList.add(new LIM("PAW", 1001, "CEDAS", 13000.0));
        employeeList.add(new LIM("KEN", 1002, "CABE", 14000.0));
        employeeList.add(new LIM("CHAW.2", 1003, "COE", 15000.0));

        while (true) {
            String option = JOptionPane.showInputDialog("""
            Employee Management System
            1. Add Employee
            2. Search Employee by ID
            3. Display All Employees
            4. Exit
                                                        
            Enter your choice:""");

            if (option == null || option.equals("4")) {
                JOptionPane.showMessageDialog(null, "Exiting program.");
                break;
            }

            switch (option) {
                case "1":
                    addEmployee();
                    break;
                case "2":
                    searchEmployee();
                    break;
                case "3":
                    displayAllEmployees();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Please choose 1, 2, 3, or 4.");
            }
        }
    }

    private static void addEmployee() {
        String name = JOptionPane.showInputDialog("Enter Employee Name:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
        String department = JOptionPane.showInputDialog("Enter Department:");
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Monthly Salary:"));

        LIM emp = new LIM(name, id, department, salary);
        employeeList.add(emp);
        JOptionPane.showMessageDialog(null, "Employee added successfully!");
    }

    private static void searchEmployee() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to Search:"));

        for (LIM emp : employeeList) {
            if (emp.getEmployeeId() == id) {
                JOptionPane.showMessageDialog(null, emp.getDetails());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Employee not found!");
    }

    private static void displayAllEmployees() {
        StringBuilder allEmployees = new StringBuilder("All Employees:\n");

        for (LIM emp : employeeList) {
            allEmployees.append(emp.getDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, allEmployees.toString());
    }

   

    
}