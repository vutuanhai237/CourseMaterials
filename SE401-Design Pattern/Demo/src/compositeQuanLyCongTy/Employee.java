package compositeQuanLyCongTy;

import java.util.ArrayList;

public interface Employee {
    public String toString();
    public double getSalary();
    public ArrayList < Employee > getEmployee();
    public boolean addEmployee(Employee c);
    public boolean removeEmployee(Employee c);
}
