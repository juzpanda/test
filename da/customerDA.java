package da;

import domain.Customer;
import java.sql.*;
import javax.swing.*;
import ui.CustomerUI;
import static ui.CustomerUI.jcboId;

public class customerDA {

    private String host = "jdbc:derby://localhost:1527/assignmentdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CUSTOMER";
    private Connection conn;
    private PreparedStatement stmt;
    
    public customerDA() {
        createConnection();
    }
    
    private void  createConnection(){
        
        try{
            
            conn = DriverManager.getConnection(host,user,password);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
     public Customer getAllRecord(){
        
        String queryStr = "SELECT * FROM " + tableName ;
        
        Customer customer = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                customer = new Customer(rs.getString("CUSTOMERID"), rs.getString("CUSTOMERNAME"), rs.getString("CUSTOMERADDRESS"), rs.getString("CUSTOMERGENDER"), rs.getString("CUSTOMERTELEPHONENO"), Integer.parseInt(rs.getString("CUSTOMERPOINT")), rs.getString("EMPLOYEEID"));
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return customer;
    }
     
     public Customer getRecord(String id){
        
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERID = ?";
        
        Customer customer = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                customer = new Customer(rs.getString("CUSTOMERID"),rs.getString("CUSTOMERNAME"),rs.getString("CUSTOMERADDRESS"),rs.getString("CUSTOMERGENDER"),rs.getString("CUSTOMERTELEPHONENO"),rs.getInt("CUSTOMERPOINT"), rs.getString("EMPLOYEEID"));
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return customer;
    }
     
     public void addRecord(Customer customer){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, customer.getCustomerId());
            stmt.setString(2, customer.getCustomerName());
            stmt.setString(3, customer.getCustomerAddress());
            stmt.setString(4,customer.getCustomerGender());
            stmt.setString(5,customer.getCustomerTelephoneNo());
            stmt.setInt(6,customer.getCustomerPoint());
            stmt.setString(7,customer.getEmployeeId());
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
     
    public void deleteRecord(String id){
        
        try{
            
            String deleteStr = "DELETE FROM " + tableName + " WHERE CUSTOMERID = ?";
            stmt = conn.prepareStatement(deleteStr);
            stmt.setString(1, id);
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void updateRecord(Customer customer){
        
        try{
            String updateStr = "UPDATE " + tableName + " SET CUSTOMERNAME = ?, CUSTOMERADDRESS = ?, CUSTOMERGENDER = ?, CUSTOMERTELEPHONENO = ?, CUSTOMERPOINT = ?, EMPLOYEEID = ?" + " WHERE CUSTOMERID = ?";
            
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getCustomerAddress());
            stmt.setString(3, customer.getCustomerGender());
            stmt.setString(4, customer.getCustomerTelephoneNo());
            stmt.setInt(5, customer.getCustomerPoint());
            stmt.setString(6, customer.getEmployeeId());
            stmt.setString(7,customer.getCustomerId());
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
   
        
    }
    
        public ResultSet selectRecord(String ID){
    String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERID = ?";
    
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
            String id = null;
                    id = rs.getString("CUSTOMERID");
            CustomerUI.jcboId.addItem(id);
        }
       
    }catch(SQLException ex){

        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);

    }
}
public ResultSet addRecordToField(String ID){

    String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERID = ?";

    ResultSet rs = null;
;
     try{
    stmt = conn.prepareStatement(queryStr);
    stmt.setString(1,ID);
    rs = stmt.executeQuery();

    if(rs.next()){
     String name = rs.getString("CUSTOMERNAME");     
     CustomerUI.jtfCustomerName3.setText(name);
     String gender = rs.getString("CUSTOMERGENDER");   
     CustomerUI.jtfGender.setText(gender);
      String address = rs.getString("CUSTOMERADDRESS");   
     CustomerUI.jtfCustomerAddress3.setText(address);
     String telephone = rs.getString("CUSTOMERTELEPHONENO");   
     CustomerUI.jtfCustomerTelephone3.setText(telephone);
     String point = rs.getString("CUSTOMERPOINT");  
     CustomerUI.jtfCustomerPoint3.setText(point);


    }

    }catch(SQLException ex){
     JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
     
    return rs;
}

public void updatePoint(String id, Integer point){
        
        try{
            String updateStr = "UPDATE " + tableName + " SET CUSTOMERPOINT = ?" + " WHERE CUSTOMERID = ?";
            
            stmt = conn.prepareStatement(updateStr);
            stmt.setInt(1, point);
            stmt.setString(2, id);
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}

    

