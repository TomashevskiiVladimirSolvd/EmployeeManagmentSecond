package com.solvd.laba.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.model.Contact;
import com.solvd.laba.model.Credential;
import com.solvd.laba.model.Department;
import com.solvd.laba.model.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONParser {
    public void parseJSON(String jsonFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File jsonFile = new File(jsonFilePath);

            Department department = objectMapper.readValue(jsonFile, Department.class);

            Long departmentId = department.getId();
            String departmentName = department.getName();
            List<Employee> employees = department.getEmployees();

            System.out.println("Department ID: " + departmentId);
            System.out.println("Department Name: " + departmentName);

            for (Employee employee : employees) {
                Long employeeId = employee.getId();
                String employeeName = employee.getName();
                String employeePosition = employee.getPosition();

                System.out.println("Employee ID: " + employeeId);
                System.out.println("Employee Name: " + employeeName);
                System.out.println("Employee Position: " + employeePosition);

                Contact contact = employee.getContact();
                Long contactId = contact.getId();
                String contactEmail = contact.getEmail();
                String contactPhone = contact.getPhone();

                System.out.println("Contact ID: " + contactId);
                System.out.println("Contact Email: " + contactEmail);
                System.out.println("Contact Phone: " + contactPhone);

                Credential credential = employee.getCredential();
                Long credentialId = credential.getId();
                String credentialLogin = credential.getLogin();
                String credentialPassword = credential.getPassword();

                System.out.println("Credential ID: " + credentialId);
                System.out.println("Credential Login: " + credentialLogin);
                System.out.println("Credential Password: " + credentialPassword);

                System.out.println("........");
            }
        } catch (IOException e) {
            System.out.println("Can't parse it");
        }
    }
}
