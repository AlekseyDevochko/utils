package org.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfficiesDAO {

    public Office getOfficeById(String officeCode){
        Office office = null;
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classicmodels.offices WHERE officeCode = '" + officeCode + "'");
            if (rs.next()){
                office = extractOffice(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.release(connection);
        }

        return office;
    }


    public List<Office> getAllOfficies(){
        List<Office> listOfficies = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classicmodels.offices");
//            if (rs.next()){
//                office = new Office(rs.getString(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getString(5), rs.getString(6),
//                        rs.getString(7), rs.getString(8), rs.getString(9));
//            }
            while(rs.next())
                listOfficies.add(extractOffice(rs));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listOfficies;
    }

    public List<Office> getAllInCountry(String country){
        List<Office> listOfficies = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classicmodels.offices WHERE country = '" + country + "'");
//            if (rs.next()){
//                office = new Office(rs.getString(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getString(5), rs.getString(6),
//                        rs.getString(7), rs.getString(8), rs.getString(9));
//            }
            while(rs.next())
                listOfficies.add(extractOffice(rs));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listOfficies;
    }

    public Office getFirstByNumber(String number){
        Office office = null;
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classicmodels.offices WHERE phone = '" + number + "'");
            if (rs.next()){
                office = extractOffice(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.release(connection);
        }

        return office;
    }

    private Office extractOffice(ResultSet rs) throws SQLException {
        Office office = new Office();
        office.setOfficeCode(rs.getString(1));
        office.setCity(rs.getString(2));
        office.setPhone(rs.getString("phone"));
        office.setAddresLine1(rs.getString("addressLine1"));
        office.setAddresLine2(rs.getString("addressLine2"));
        office.setState(rs.getString("state"));
        office.setCountry(rs.getString("country"));
        office.setPostalCode(rs.getString("postalCode"));
        office.setTerritory(rs.getString("territory"));
        return office;
    }

    public void updateOffice(Office office){

        String updateSQL = "UPDATE classicmodels.offices " +
                "SET city = '"+office.getCity()+"', phone = '"+office.getPhone()+"', " +
                "addressLine1 = '"+office.getAddresLine1()+"', addressLine2 = '"+office.getAddresLine2()+"', " +
                "state = '"+office.getState()+"', country = '"+office.getCountry()+"', postalCode = '"
                +office.getPostalCode()+"', territory = '"+office.getTerritory()+"' " +
                "WHERE officeCode = '"+office.getOfficeCode()+"'";

        try (Connection conn = DBUtils.getConnection()){
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(updateSQL);
            if(result == 1){
                System.out.println("Office with Code = '"+office.getOfficeCode()+"' Updated Successfully ");
            } else {
                System.out.println("Office NOT Updated with Code = '"+office.getOfficeCode()+"'");
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    public void deleteOfficeById(String officeCode){
        String sql = "DELETE FROM classicmodels.offices WHERE officeCode='" + officeCode +"'";
        try(Connection con = DBUtils.getConnection()){
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(sql);
            if (result == 1) {
                System.out.println("Delete successful");
            } else {
                System.out.println("Office not deleted with code " + officeCode);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createOffice(Office office){
        String state = "INSERT INTO classicmodelS.offices " +
                "(`officeCode`, `city`, `phone`, `addressLine1`, `addressLine2`, `state`, `country`, `postalCode`, `territory`) " +
                "VALUES  ('" + office.getOfficeCode() +  "', '" + office.getCity() + "', '" + office.getPhone() + "', '" + office.getAddresLine1() +"'," +
                " '" + office.getAddresLine2() +  "', '" + office.getState() + "', '" + office.getCountry() + "', '" + office.getPostalCode()+ "', '" + office.getTerritory() + "')";
        try(Connection con = DBUtils.getConnection()) {
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(state);
            if (result == 1) {
                System.out.println("Create successful");
            } else {
                System.out.println("Office not created");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
