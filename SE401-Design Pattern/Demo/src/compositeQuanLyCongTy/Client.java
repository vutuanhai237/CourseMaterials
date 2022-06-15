package compositeQuanLyCongTy;


class Client {
    public static void main(String[] args) {
        Manager salesManager = new Manager("Sale manager", 3000);

        salesManager.addEmployee(new NormalEmployee("sale employee 1", 1000));
        salesManager.addEmployee(new NormalEmployee("sale employee 2", 1000));

        Manager HRManager = new Manager("HR Manager", 2500);
        HRManager.addEmployee(new NormalEmployee("hr employee 1", 2000));

        Manager director = new Manager("Director", 10000);
        director.addEmployee(salesManager);
        director.addEmployee(HRManager);

        System.out.println(director.toString());
    }
}