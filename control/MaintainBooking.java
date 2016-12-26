package control;

import da.bookingDA;
import domain.Booking;
import java.sql.ResultSet;
import java.util.Date;

public class MaintainBooking {
    private bookingDA bookDA;
    
    public MaintainBooking() {
        bookDA = new bookingDA();
    }
     
    public void addRecord(Booking b){
        bookDA.addRecord(b);
    }
    
     public void FillComboboxItem(String custId){
        bookDA.FillCombobox(custId);
    }
    
    public ResultSet addRecordToField(String id){
        return bookDA.addRecordToField(id);
    }
      
   public void updateRecord(Booking b){
        bookDA.updateRecord(b);
    }
   
    public void FillRoomId(Date checkOutDate){
        bookDA.FillRoomId(new java.sql.Date(checkOutDate.getTime()));
    }
    
    public ResultSet addCheckOutRecord(String id){
        return bookDA.addCheckOutRecord(id);
    }
    
    public void FillComboboxRoomId(String custId){
        bookDA.FillComboboxRoomId(custId);
    }

     public void FillComboboxCheckInDate(String roomId, String customerId){
        bookDA.FillComboboxCheckInDate(roomId, customerId);
    }
     public ResultSet addViewRecord(String roomId,String checkInDate){
         return bookDA.addViewRecord(roomId, checkInDate);
     }
     
     public void FillPaymentComboboxRoomId(String custId){
        bookDA.FillPaymentComboboxRoomId(custId);
    }
     
     public void FillPaymentComboboxCheckInDate(String roomId, String customerId){
        bookDA.FillPaymentComboboxCheckInDate(roomId, customerId);
    }
     
    public ResultSet viewRecordForPayment(String roomId,String checkInDate){
        return bookDA.viewRecordForPayment(roomId, checkInDate);
     }
      
    public Booking viewRecordForUpdate(String custId,String roomId, String checkInDate){
        return bookDA.viewRecordForUpdate(custId,roomId,checkInDate);
     }
    
    public void updateRoomStatus(String today){
        bookDA.updateRoomStatus(today);
    }
    
}
