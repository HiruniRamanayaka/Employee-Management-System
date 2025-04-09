package org.example;

public class Employee {

    private String empId;
    private String name;
    private String department;
    private String email;
    private String hire_date;

    public Employee (String empId, String name, String department, String email, String hire_date){
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.email = email;
        this.hire_date = hire_date;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }
}
