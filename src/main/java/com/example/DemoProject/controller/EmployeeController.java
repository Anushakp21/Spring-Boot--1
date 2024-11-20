package com.example.DemoProject.controller;

import com.example.DemoProject.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Create (Insert)
    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO employees (fName, lName, address, age) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getfName());
            statement.setString(2, employee.getlName());
            statement.setString(3, employee.getAddress());
            statement.setInt(4, employee.getAge());
            statement.executeUpdate();
            return "Employee added successfully!";
        } catch (SQLException e) {
            System.out.println(e);
            return "Error adding employee.";
        }
    }

    // Read (Get All)
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        List<Employee> employees = new ArrayList<>();
//        try (Connection connection = DatabaseConfig.getConnection()) {
//            String sql = "SELECT * FROM employees";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                employees.add(new Employee(
//                        resultSet.getString("fName"),
//                        resultSet.getString("lName"),
//                        resultSet.getString("address"),
//                        resultSet.getInt("age")
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
//
//    // Update
//    @PutMapping("/{id}")
//    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
//        try (Connection connection = DatabaseConfig.getConnection()) {
//            String sql = "UPDATE employees SET fName = ?, lName = ?, address = ?, age = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, employee.getfName());
//            statement.setString(2, employee.getlName());
//            statement.setString(3, employee.getAddress());
//            statement.setInt(4, employee.getAge());
//            statement.setInt(5, id);
//            int rowsUpdated = statement.executeUpdate();
//            return rowsUpdated > 0 ? "Employee updated successfully!" : "Employee not found.";
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "Error updating employee.";
//        }
//    }
//
//    // Delete
//    @DeleteMapping("/{id}")
//    public String deleteEmployee(@PathVariable int id) {
//        try (Connection connection = DatabaseConfig.getConnection()) {
//            String sql = "DELETE FROM employees WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            int rowsDeleted = statement.executeUpdate();
//            return rowsDeleted > 0 ? "Employee deleted successfully!" : "Employee not found.";
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "Error deleting employee.";
//        }
    }
