package da;

import control.MaintainBooking;
import control.MaintainRoom;
import domain.Booking;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import ui.BookingUI;
import static ui.BookingUI.jcboCheckInDate2;
import static ui.BookingUI.simpleDateFormat;
import ui.PaymentUI;

public class bookingDA {
    private String host = "jdbc:derby://localhost:1527/assignmentdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BOOKING";
    private String tableName1 = "ROOM";
    private Connection conn;
    private PreparedStatement stmt;
    private Object booking;
    private MaintainRoom roomControl;
    
    public bookingDA() {
        roomControl = new MaintainRoom();
        createConnection();
    }
    
    private void  createConnection(){
        
        try{
            conn = DriverManager.getConnection(host,user,password);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void addRecord(Booking b){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, b.getCustomerId());
            stmt.setString(2, b.getRoomId());
            stmt.setDate(3, new java.sql.Date(b.getBookingDate().getTime()) );
            stmt.setDate(4, new java.sql.Date(b.getCheckInDate().getTime()) );
            stmt.setDate(5, new java.sql.Date(b.getCheckOutDate().getTime()) );
            stmt.setDouble(6, b.getTotalPrice());
            stmt.setString(7, "PENDING");
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
     public void FillCombobox(String custId){
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERID = ? AND RESERVESTATUS = 'PENDING'";
         
         
        try{
            stmt = conn.prepareStatement(queryStr);
             stmt.setString(1,custId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){ 
                String id = rs.getString("ROOMID");  
                BookingUI.jcboRoomId1.addItem(id);
                
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
       
}
     
     public ResultSet addRecordToField(String ID){
    
    String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ? AND RESERVESTATUS = 'PENDING'";
     
     ResultSet rs = null;

      try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,ID);
        rs = stmt.executeQuery();
        
        if(rs.next()){
            Date checkInDate = rs.getDate("CHECKINDATE");
            String checkInDateString = simpleDateFormat.format(checkInDate);
            BookingUI.jtfCheckInDate1.setText(checkInDateString);
            Date checkOutDate = rs.getDate("CHECKOUTDATE");
            String checkOutDateString = simpleDateFormat.format(checkOutDate);
            BookingUI.jtfCheckOutDate1.setText(checkOutDateString);
            Double totalPrice = rs.getDouble("TOTALPRICE");     
            BookingUI.jtfTotalPrice1.setText(String.valueOf(totalPrice));
            String status = rs.getString("RESERVESTATUS");
            BookingUI.jtfStatus.setText(status);
        }
       
    }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    return rs;
}
     
    public void updateRecord(Booking booking){
        
        try{
            String updateStr = "UPDATE " + tableName + " SET RESERVESTATUS = ?" + " WHERE CUSTOMERID = ? AND ROOMID = ? AND CHECKINDATE = ?";
            
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, booking.getReserveStatus());
            stmt.setString(2, booking.getCustomerId());
            stmt.setString(3,booking.getRoomId());
            stmt.setDate(4, new java.sql.Date(booking.getCheckInDate().getTime()));
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
   
        
    }
    
     public void FillRoomId(Date date){
        String queryStr =  "SELECT * FROM " + tableName + " , " + tableName1 + " WHERE " + tableName + ".ROOMID = " + tableName1 + ".ROOMID AND CHECKOUTDATE = ? AND RESERVESTATUS != 'CANCELLED' AND " + tableName1 + ".ROOMSTATUS != 'AVAILABLE'";
       
         BookingUI.jcboRoomId3.addItem("");
        try{
            stmt = conn.prepareStatement(queryStr);
             stmt.setDate(1,new java.sql.Date(date.getTime()));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){ 
                String id = rs.getString("ROOMID");  
                BookingUI.jcboRoomId3.addItem(id);
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
       
}
     public ResultSet addCheckOutRecord(String ID){
    
    String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ? AND RESERVESTATUS != 'CANCELLED'";
     
     ResultSet rs = null;

      try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,ID);
        rs = stmt.executeQuery();
        
        if(rs.next()){
            String customerId = rs.getString("CUSTOMERID");
            BookingUI.jtfCustomerId3.setText(customerId);
        }
       
    }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    return rs;
}
     public void FillComboboxRoomId(String custId){
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERID = ?";
         
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,custId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<String> values = new ArrayList<>(); 
            ArrayList<String> set = new ArrayList<>();
            while(rs.next()){   
                String roomId = rs.getString("ROOMID");
                values.add(roomId);
                set = removeDuplicates(values);
            }
             for (String element : set) {
                        BookingUI.jcboRoomId2.addItem(element);
                }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
      }
  
     public void FillComboboxCheckInDate(String roomId, String customerId){
        String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ? AND CUSTOMERID = ?";
         
         
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,roomId);
            stmt.setString(2,customerId);
            ResultSet rs = stmt.executeQuery();
            jcboCheckInDate2.removeAllItems();
            while(rs.next()){ 
                Date date = rs.getDate("CHECKINDATE");
                String checkInDate = simpleDateFormat.format(date);
                BookingUI.jcboCheckInDate2.addItem(checkInDate);    
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
      }
     
public ResultSet addViewRecord(String roomId,String checkInDate){
    
    String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ? AND CHECKINDATE = ? ";
     
     ResultSet rs = null;

      try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,roomId);
        stmt.setDate(2, new java.sql.Date(simpleDateFormat.parse(checkInDate).getTime()));
        rs = stmt.executeQuery();
        if(rs.next()){
            
                String checkOutDate = simpleDateFormat.format(rs.getDate("CHECKOUTDATE"));
                BookingUI.jtfCheckOutDate2.setText(checkOutDate);
                String totalPrice = rs.getString("TOTALPRICE");
                BookingUI.jtfTotalPrice2.setText(totalPrice);
                String status = rs.getString("RESERVESTATUS");
                BookingUI.jtfStatus2.setText(status);
        }
       
    }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }   catch (ParseException ex) {
            Logger.getLogger(bookingDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rs;
}

public void FillPaymentComboboxRoomId(String custId){
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERID = ? AND RESERVESTATUS = 'PENDING'";
         
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,custId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<String> values = new ArrayList<>(); 
            ArrayList<String> set = new ArrayList<>();
            while(rs.next()){   
                String roomId = rs.getString("ROOMID");
                values.add(roomId);
                set = removeDuplicates(values);
            }
             for (String element : set) {
                        PaymentUI.jcboRoomId.addItem(element);
                }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
      }

public void FillPaymentComboboxCheckInDate(String roomId, String customerId){
        String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ? AND CUSTOMERID = ? AND RESERVESTATUS = 'PENDING'";
         
         
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,roomId);
            stmt.setString(2,customerId);
            ResultSet rs = stmt.executeQuery();
            PaymentUI.jcboCheckInDate.removeAllItems();
            while(rs.next()){ 
                Date date = rs.getDate("CHECKINDATE");
                String checkInDate = simpleDateFormat.format(date);
                PaymentUI.jcboCheckInDate.addItem(checkInDate);    
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
      }

public ResultSet viewRecordForPayment(String roomId,String checkInDate){
    
    String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ? AND CHECKINDATE = ? ";
     
     ResultSet rs = null;

      try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,roomId);
        stmt.setDate(2, new java.sql.Date(simpleDateFormat.parse(checkInDate).getTime()));
        rs = stmt.executeQuery();
        if(rs.next()){
                String totalPrice = rs.getString("TOTALPRICE");
                PaymentUI.jtfTotalAmount.setText(totalPrice);
        }
       
    }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }   catch (ParseException ex) {
            Logger.getLogger(bookingDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rs;
}

    static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        // Store unique items in result.
	ArrayList<String> result = new ArrayList<>();

	// Record encountered Strings in HashSet.
	HashSet<String> set = new HashSet<>();

	// Loop over argument list.
	for (String item : list) {

	    // If String is not in set, add it to the list and the set.
	    if (!set.contains(item)) {
		result.add(item);
		set.add(item);
	    }
	}
	return result;
    }
    
    public Booking viewRecordForUpdate(String custId, String roomId, String checkInDate){
    String queryStr = "SELECT * FROM " + tableName + " WHERE CUSTOMERID = ? AND ROOMID = ? AND CHECKINDATE = ?";
    
    ResultSet rs = null;
    Booking b = new Booking();
    try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,custId);
        stmt.setString(2, roomId);
        stmt.setDate(3, new java.sql.Date(simpleDateFormat.parse(checkInDate).getTime()));
        
        rs = stmt.executeQuery();
       
         if(rs.next()){
                b = new Booking(rs.getString("CUSTOMERID"), rs.getString("ROOMID"), rs.getDate("BOOKINGDATE"), rs.getDate("CHECKINDATE"), rs.getDate("CHECKOUTDATE"), rs.getDouble("TOTALPRICE"),rs.getString("RESERVESTATUS"));
            }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }   catch (ParseException ex) {
        Logger.getLogger(bookingDA.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return b;
}
    
public void updateRoomStatus(String today){
    String queryStr = "SELECT * FROM " + tableName + " WHERE CHECKINDATE = ?";
    
    ResultSet rs = null;
    try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setDate(1,new java.sql.Date(simpleDateFormat.parse(today).getTime()));
        
        rs = stmt.executeQuery();
       
         while(rs.next()){
               roomControl.updateRoomStatus(rs.getString("ROOMID"));
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }   catch (ParseException ex) {
        Logger.getLogger(bookingDA.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
    
}
