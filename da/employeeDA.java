package da;

import domain.Employee;
import java.sql.*;
import javax.swing.*;
import ui.EmployeeUI;

public class employeeDA {

    private String host = "jdbc:derby://localhost:1527/assignmentdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "EMPLOYEE";
    private Connection conn;
    private PreparedStatement stmt;
    
    public employeeDA() {
        createConnection();
    }
    
    private void  createConnection(){
        
        try{
            
            conn = DriverManager.getConnection(host,user,password);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
     public Employee getAllRecord(){
        
        String queryStr = "SELECT * FROM " + tableName ;
        
        Employee employee = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                employee = new Employee(rs.getString("EMPLOYEEID"),rs.getString("EMPLOYEENAME"),rs.getInt("EMPLOYEEAGE"),rs.getString("EMPLOYEEADDRESS"),rs.getString("EMPLOYEEGENDER"),rs.getString("EMPLOYEETELEPHONENO"), rs.getString("EMPLOYEEPASSWORD"),rs.getString("DEPARTMENTID"));
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return employee;
    }
     
     public Employee getRecord(String id){
        
        String queryStr = "SELECT * FROM " + tableName + " WHERE EMPLOYEEID = ?";
        
        Employee employee = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                employee = new Employee(rs.getString("EMPLOYEEID"),rs.getString("EMPLOYEENAME"),rs.getInt("EMPLOYEEAGE"),rs.getString("EMPLOYEEADDRESS"),rs.getString("EMPLOYEEGENDER"),rs.getString("EMPLOYEETELEPHONENO"), rs.getString("EMPLOYEEPASSWORD"),rs.getString("DEPARTMENTID"));
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return employee;
    }
     
     public void addRecord(Employee employee){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, employee.getEmployeeId());
            stmt.setString(2, employee.getEmployeeName());
            stmt.setInt(3, employee.getEmployeeAge());
            stmt.setString(4,employee.getEmployeeAddress());
            stmt.setString(5,employee.getEmployeeGender());
            stmt.setString(6,employee.getEmployeeTelephoneNo());
            stmt.setString(7,employee.getEmployeePassword());
            stmt.setString(8,employee.getDepartmentId());
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
     
    public void deleteRecord(String id){
        
        try{
            
            String deleteStr = "DELETE FROM " + tableName + " WHERE EMPLOYEEID = ?";
            stmt = conn.prepareStatement(deleteStr);
            stmt.setString(1, id);
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void updateRecord(Employee employee){
        
        try{
            String updateStr = "UPDATE " + tableName + " SET EMPLOYEENAME = ?, EMPLOYEEAGE = ?, EMPLOYEEADDRESS = ?, EMPLOYEEGENDER = ?, EMPLOYEETELEPHONENO = ?, EMPLOYEEPASSWORD = ?, DEPARTMENTID = ?" + " WHERE EMPLOYEEID = ?";
            
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, employee.getEmployeeName());
            stmt.setInt(2, employee.getEmployeeAge());
            stmt.setString(3,employee.getEmployeeAddress());
            stmt.setString(4,employee.getEmployeeGender());
            stmt.setString(5,employee.getEmployeeTelephoneNo());
            stmt.setString(6,employee.getEmployeePassword());
            stmt.setString(7,employee.getDepartmentId());
            stmt.setString(8,employee.getEmployeeId());
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
   
        
    }
    
        public ResultSet selectRecord(String ID){
    String queryStr = "SELECT * FROM " + tableName + " WHERE EMPLOYEEID = ?";
    
    ResultSet rs = null;
    
    try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,ID);
        
        rs = stmt.executeQuery();
       
    }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
    return rs;
}
    public void FillCombobox(){
        String queryStr = "SELECT * FROM " + tableName ;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("EMPLOYEEID");  
                EmployeeUI.jcboId.addItem(id);
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
}
    
public ResultSet addRecordToField(String ID){
    
    String queryStr = "SELECT * FROM " + tableName + " WHERE EMPLOYEEID = ?";
     
     ResultSet rs = null;
;
      try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,ID);
        rs = stmt.executeQuery();
        
        if(rs.next()){
            String name = rs.getString("EMPLOYEENAME");     
            EmployeeUI.jtfEmployeeName3.setText(name);
            String age = rs.getString("EMPLOYEEAGE");     
            EmployeeUI.jtfEmployeeAge3.setText(age);
            String gender = rs.getString("EMPLOYEEGENDER");     
            EmployeeUI.jtfGender.setText(gender);
            String address = rs.getString("EMPLOYEEADDRESS");     
            EmployeeUI.jtfEmployeeAddress3.setText(address);
            String telephone = rs.getString("EMPLOYEETELEPHONENO");     
            EmployeeUI.jtfEmployeeTel3.setText(telephone);
            String department = rs.getString("DEPARTMENTID");     
            EmployeeUI.jtfDepartment.setText(department);
        }
       
    }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    return rs;
}    
}
