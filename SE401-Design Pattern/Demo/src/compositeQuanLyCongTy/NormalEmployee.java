package compositeQuanLyCongTy;

import java.util.ArrayList;

public class NormalEmployee implements Employee {
    private String id;
    private double salary;
    public NormalEmployee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public double getSalary() {
    	return salary;
    }
    public String toString() {
        return id + "[" + this.salary + "]";
    }
    public ArrayList < Employee > getEmployee() {
        return null;
    }
    public boolean addEmployee(Employee c) {
        return false;
    }
    public boolean removeEmployee(Employee c) {
        return false;
    }
}