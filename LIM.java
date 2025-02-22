/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplicationlLIM;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LIM {

    static void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String name;
    private int employeeId;
    private String department;
    private double monthlySalary;

    public LIM(String name, int employeeId, String department, double monthlySalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.monthlySalary = monthlySalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDetails() {
        return "Employee Information:\n" +
                "Name: " + name + "\n" +
                "Employee ID: " + employeeId + "\n" +
                "Department: " + department + "\n" +
                "Monthly Salary: $" + monthlySalary + "\n" +
                "Annual Salary: $" + calculateAnnualSalary();
    }

    public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    public String getEmployeeName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class JavaApplicationLIM {
    public static void main(String[] args) {
        // Create a list of employees
        ArrayList<LIM> employeeList = new ArrayList<>();
        employeeList.add(new LIM("PAW", 001, "CEDAS", 13000.0));
        employeeList.add(new LIM("KEN", 002, "CABE", 14000.0));
        employeeList.add(new LIM("CHAW.2", 003, "COE", 15000.0));

        while (true) {

            String option = JOptionPane.showInputDialog("""
            Employee Management System
            1. Search Employee by ID
            2. Add New Employee
            3. Exit
                                                        
            Enter your choice:""");

            if (option == null || option.equals("3")) {
                JOptionPane.showMessageDialog(null, "Exiting program.");
                break;
            }

            switch (option) {
                case "1":
                    searchEmployee(employeeList);
                    break;
                case "2":
                    addEmployee(employeeList);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Choose 1, 2, or 3.");
            }
        }
    }

    private static void searchEmployee(ArrayList<LIM> employeeList) {
        String input = JOptionPane.showInputDialog("Enter Employee ID to Search:");

        try {
            int id = Integer.parseInt(input);
            boolean found = false;

            for (LIM emp : employeeList) {
                if (emp.getEmployeeId() == id) {
                    JOptionPane.showMessageDialog(null, emp.getDetails());
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "Employee ID not found!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid Employee ID.");
        }
    }

    private static void addEmployee(ArrayList<LIM> employeeList) {
        String name = JOptionPane.showInputDialog("Enter Employee Name:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
        String department = JOptionPane.showInputDialog("Enter Department:");
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Monthly Salary:"));

        LIM newEmp = new LIM (name, id, department, salary);
        employeeList.add(newEmp);

        JOptionPane.showMessageDialog(null, "Employee added successfully!\n\n" + newEmp.getDetails());
    }
}