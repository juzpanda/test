package da;

import domain.Payment;
import java.sql.*;
import javax.swing.*;
import ui.PaymentUI;

public class paymentDA {
    
    private String host = "jdbc:derby://localhost:1527/assignmentdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PAYMENT";
    private Connection conn;
    private PreparedStatement stmt;

    public paymentDA() {
          createConnection();
    }
    
     private void  createConnection(){
        
        try{
            
            conn = DriverManager.getConnection(host,user,password);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
     
      public void addRecord(Payment payment){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, payment.getPaymentId());
            stmt.setString(2, payment.getPaymentType());
            stmt.setDouble(3, payment.getTotalAmount());
            stmt.setDate(4,new java.sql.Date(payment.getPaymentDate().getTime()));
            stmt.setString(5, payment.getPaymentStatus());
            stmt.setString(6, payment.getCustomerId());
            stmt.setString(7, payment.getRoomId());
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
      public Payment getAllRecord(){
        
        String queryStr = "SELECT * FROM " + tableName ;
        
        Payment payment = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                payment = new Payment(rs.getString("PAYMENTID"),rs.getString("PAYMENTTYPE"),rs.getDouble("TOTALAMOUNT"),rs.getDate("PAYMENTDATE"),rs.getString("PAYMENTSTATUS"),rs.getString("CUSTOMERID"), rs.getString("ROOMID"));
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return payment;
    }
     
     public Payment getRecord(String id){
        
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAYMENTID = ?";
        
        Payment payment = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                payment = new  Payment(rs.getString("PAYMENTID"),rs.getString("PAYMENTTYPE"),rs.getDouble("TOTALAMOUNT"),rs.getDate("PAYMENTDATE"),rs.getString("PAYMENTSTATUS"),rs.getString("CUSTOMERID"), rs.getString("ROOMID"));
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return payment;
    }
      public void FillCombobox(){
    String queryStr = "SELECT * FROM " + tableName ;

    try{
        stmt = conn.prepareStatement(queryStr);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            String id = rs.getString("PAYMENTID");  
            PaymentUI.jcboId.addItem(id);
        }
    }catch(SQLException ex){

        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);

    }
}
public ResultSet addRecordToField(String ID){

    String queryStr = "SELECT * FROM " + tableName + " WHERE PAYMENTID = ?";

    ResultSet rs = null;
;
     try{
    stmt = conn.prepareStatement(queryStr);
    stmt.setString(1,ID);
    rs = stmt.executeQuery();

    if(rs.next()){
     String type = rs.getString("PAYMENTTYPE");     
     PaymentUI.jtfPaymentType1.setText(type);
     String totalAmount = rs.getString("TOTALAMOUNT");     
     PaymentUI.jtfTotalAmount1.setText(totalAmount);
     String date = rs.getString("PAYMENTDATE");   
     PaymentUI.jtfPaymentDate1.setText(date);
     String status = rs.getString("PAYMENTSTATUS");   
     PaymentUI.jtfPaymentStatus1.setText(status);
     String custId = rs.getString("CUSTOMERID");   
     PaymentUI.jtfCustomerId1.setText(custId);
     String roomId = rs.getString("ROOMID");  
     PaymentUI.jtfRoomId1.setText(roomId);


    }

    }catch(SQLException ex){
     JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
     
    return rs;
}    
}
