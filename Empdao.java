import java.sql.*;

public class Empdao {

    public void addEmployee(Employee e) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO employee(name, department, sal) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, e.name);
        pst.setString(2, e.department);
        pst.setDouble(3, e.salary);
        pst.executeUpdate();
        con.close();
        System.out.println("Employee Added");
    }

    public void viewEmployees() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employee");

        while (rs.next()) {
            System.out.println(
                rs.getInt("empid") + " | " +
                rs.getString("name") + " | " +
                rs.getString("department") + " | " +
                rs.getDouble("sal")
            );
        }
        con.close();
    }

    public void updateSalary(int id, double salary) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE employee SET sal=? WHERE empid=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDouble(1, salary);
        pst.setInt(2, id);
        pst.executeUpdate();
        con.close();
        System.out.println("Salary Updated");
    }

    public void deleteEmployee(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM employee WHERE empid=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        con.close();
        System.out.println("Employee Deleted");
    }
}
