package compositeQuanLyCongTy;

import java.util.ArrayList;

public class Manager implements Employee {
    private String id;
    private double salary;
    private ArrayList < Employee > employees = new ArrayList < Employee > ();

    public Manager(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public String toString() {
        String s = " (" + id + "[" + this.salary + "]:";
        for (Employee child: this.getEmployee())
            s += " " + child.toString();
        return s + ") ";
    }

    public ArrayList < Employee > getEmployee() {
        return employees;
    }
    public boolean addEmployee(Employee c) {
        return employees.add(c);
    }
    public boolean removeEmployee(Employee c) {
        return employees.remove(c);
    }

	@Override
	public double getSalary() {
		return salary;
	}
}