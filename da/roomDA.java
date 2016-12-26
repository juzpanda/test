package da;

import domain.Room;
import java.sql.*;
import javax.swing.*;
import ui.BookingUI;
import ui.PaymentUI;
import ui.RoomUI;

public class roomDA {

    
    private String host = "jdbc:derby://localhost:1527/assignmentdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ROOM";
    private Connection conn;
    private PreparedStatement stmt;
    
    public roomDA() {
        createConnection();
    }
    
    private void  createConnection(){
        
        try{
            conn = DriverManager.getConnection(host,user,password);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void addRecord(Room room){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?)";
        
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, room.getRoomId());
            stmt.setString(2, room.getRoomType());
            stmt.setDouble(3, room.getRoomPrice());
            stmt.setString(4, room.getRoomStatus());
            stmt.setString(5, room.getRoomDescription());
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    public Room getRecord(String id){
        
        String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ?";
        
        Room room = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                room = new Room(id,rs.getString("RoomType"),rs.getDouble("RoomPrice"), rs.getString("RoomStatus"), rs.getString("RoomDescription"));
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return room;
    }
    
    public void deleteRecord(String id){
        
        try{
            
            String deleteStr = "DELETE FROM " + tableName + " WHERE ROOMID = ?";
            stmt = conn.prepareStatement(deleteStr);
            stmt.setString(1, id);
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public void updateRecord(Room room) {
        
        try{
            String updateStr = "UPDATE " + tableName + " SET ROOMTYPE = ?, ROOMPRICE = ?, ROOMSTATUS = ?, ROOMDESCRIPTION = ? " + " WHERE ROOMID = ?";
            
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, room.getRoomType());
            stmt.setDouble(2, room.getRoomPrice());
            stmt.setString(3,room.getRoomStatus());
            stmt.setString(4,room.getRoomDescription());
            stmt.setString(5,room.getRoomId());
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
   
        
    }
              
    public ResultSet selectRecord(String ID){
    String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ?";
    
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
                String id = rs.getString("ROOMID");  
                RoomUI.jcboId.addItem(id);
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
}
    
public ResultSet addRecordToField(String ID){
    
    String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMID = ?";
     
     ResultSet rs = null;

      try{
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,ID);
        rs = stmt.executeQuery();
        
        if(rs.next()){
            String type = rs.getString("ROOMTYPE");     
            RoomUI.jtfRoomType3.setText(type);
            String price = rs.getString("ROOMPRICE");     
            RoomUI.jtfRoomPrice3.setText(price);
            String status = rs.getString("ROOMSTATUS");     
            RoomUI.jtfRoomStatus3.setText(status);
            String description = rs.getString("ROOMDESCRIPTION");     
            RoomUI.jtfRoomDescription3.setText(description);
        }
       
    }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    return rs;
}
    
     public Room getRecordForReserve(String roomType){
        
        String queryStr = "SELECT * FROM " + tableName + " WHERE ROOMTYPE = ? AND ROOMSTATUS = 'AVAILABLE'";
        
        Room room = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, roomType);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                room = new Room(rs.getString("RoomId"),rs.getString("RoomType"),rs.getDouble("RoomPrice"), rs.getString("RoomStatus"), rs.getString("RoomDescription"));
                BookingUI.jcboRoomId.addItem(rs.getString("RoomId"));
            
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return room;
    }
     
       public Room getAllRecord(){
        
        String queryStr = "SELECT * FROM " + tableName ;
        
        Room room = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                room = new Room(rs.getString("ROOMID"), rs.getString("ROOMTYPE"), rs.getDouble("ROOMPRICE"), rs.getString("ROOMSTATUS"), rs.getString("ROOMDESCRIPTION"));
                BookingUI.jcboRoomId2.addItem(room.getRoomId());
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return room;
    }
       
       public Room getAllRecordForPayment(){
        
        String queryStr = "SELECT * FROM " + tableName ;
        
        Room room = null;
        
        try{
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                room = new Room(rs.getString("ROOMID"), rs.getString("ROOMTYPE"), rs.getDouble("ROOMPRICE"), rs.getString("ROOMSTATUS"), rs.getString("ROOMDESCRIPTION"));
                PaymentUI.jcboRoomId.addItem(room.getRoomId());
            }
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        return room;
    }
       
public void updateRoomStatus(String roomId) {
        
        try{
            String updateStr = "UPDATE " + tableName + " SET ROOMSTATUS = 'NOT AVAILABLE' WHERE ROOMID = ?";
            
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, roomId);
            
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
   
        
    }
    
}
