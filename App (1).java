import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Empdao dao = new Empdao();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1.Add  2.View  3.Update Salary  4.Delete  5.Exit");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Dept: ");
                        String dept = sc.next();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        dao.addEmployee(new Employee(name, dept, sal));
                        break;

                    case 2:
                        dao.viewEmployees();
                        break;

                    case 3:
                        System.out.print("Emp ID: ");
                        int id = sc.nextInt();
                        System.out.print("New Salary: ");
                        double ns = sc.nextDouble();
                        dao.updateSalary(id, ns);
                        break;

                    case 4:
                        System.out.print("Emp ID: ");
                        dao.deleteEmployee(sc.nextInt());
                        break;

                    case 5:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
