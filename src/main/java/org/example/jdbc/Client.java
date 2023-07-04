package org.example.jdbc;

public class Client {
    public static void main(String[] args) {
//        OfficiesDAO officiesDAO = new OfficiesDAO();
//        Office office = officiesDAO.getOfficeById("2");
//        System.out.println(office);
//
//        for (Office o :
//                officiesDAO.getAllOfficies()) {
//            System.out.println(o);
//        }
//
//        for (Office o :
//                officiesDAO.getAllInCountry("USA")) {
//            System.out.println(o);
//        }
//
//        System.out.println(officiesDAO.getFirstByNumber("+1 212 555 3000"));
//
//        officiesDAO.deleteOfficeById("45");
//        Office testOffice1 = new Office("45", "per", "12345678", "adr", "adr2", "st", "count", "code", "");
//        officiesDAO.createOffice(testOffice1);
//        Office ofFromDB = officiesDAO.getOfficeById("45");
//        System.out.println(ofFromDB.equals(testOffice1));


//        System.out.println(testOffice1.equals(ofFromDB));

        EmployeesDAO empDAO = new EmployeesDAO();
        Employee empl = empDAO.getEmployeeById(1056);
        empl.setFirstName("Patrick");
        empl.setLastName("Bateman");
        empDAO.updateEmplByEmpl(empl);
    }
}
