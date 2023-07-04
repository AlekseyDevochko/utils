package org.example.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesDAO {



    private final OfficiesDAO offDAO = new OfficiesDAO();

    public Employee getEmployeeById(int id){
        String select = "SELECT * FROM classicmodels.Employees WHERE employeeNumber = ?";
        Employee employee = new Employee();

        try(Connection con = DBUtils.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(select);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                employee.setEmployeeNumber(rs.getInt("employeeNumber"));
                employee.setLastName(rs.getString("LastName"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setExtension(rs.getString("Extension"));
                employee.setEmail(rs.getString("Email"));
                employee.setOffice(offDAO.getOfficeById(rs.getString("OfficeCode")));
                employee.setReportsTo(getEmployeeById(rs.getInt("ReportsTo")));
                employee.setJobTitle(rs.getString("JobTitle"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    public void updateEmplByEmpl(Employee employee){
        String sql = "UPDATE classicmodels.employees SET lastName = ?, firstName = ?, extension = ?, email = ?, officeCode = ?, reportsTo = ?, jobTitle = ? WHERE employeeNumber = ?";
        try(Connection connection = DBUtils.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getExtension());
            pstmt.setString(4, employee.getOffice().getOfficeCode());
            pstmt.setInt(5, employee.getReportsTo().getEmployeeNumber());
            pstmt.setString(6, employee.getJobTitle());
            pstmt.setInt(7, employee.getEmployeeNumber());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
