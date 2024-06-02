package HomeWork4;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\FizzBuzz\\hr.db";
    private static final String insertEmployee = "insert into employees values (?,?,?,?,?,?,?,?,?,?)";
    private static final String selectEmployee = "select * from employees where employee_id = ?";
    private static final String selectAllEmployees = " select * from employees " ;
    private static final String updateEmployee = "update employees set first_name = ? last_name = ? ,where employee_id  = ?";
    private static final String deleteEmployee = "delete from employees where employee_id = ?";

    public void insertEmployee(employees e) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(insertEmployee);
        st.setInt(1,e.getEmployee_id());
        st.setString(2,e.getFirst_name());
        st.setString(3,e.getLast_name());
        st.setString(4,e.getEmail());
        st.setString(5,e.getPhone_number());
        st.setString(6,e.getHire_date());
        st.setInt(7,e.getJob_id());
        st.setDouble(8,e.getSalary());
        st.setInt(9,e.getManager_id());
        st.setInt(10,e.getDepartment_id());
        st.executeUpdate();
    }

    public employees selectEmployee(int idEmp) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(selectEmployee);
        st.setInt(1, idEmp);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new employees(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<employees> selectAllEmployees() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(selectAllEmployees);
        ResultSet rs = st.executeQuery();
        ArrayList<employees> employee = new ArrayList<>();
        while (rs.next()) {
            employee.add(new employees(rs));
        }
        return employee;
    }

    public void updateEmployee(employees e) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(updateEmployee);
        st.setInt(3,e.getEmployee_id());
        st.setString(1,e.getFirst_name());
        st.setString(2,e.getLast_name());
        st.executeUpdate();

    }


    public void deleteEmployee(int IdEmp) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(deleteEmployee);
        st.setInt(1, IdEmp);
        st.executeUpdate();
    }


}
