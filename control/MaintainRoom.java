package control;

import da.roomDA;
import domain.Room;
import java.sql.ResultSet;

public class MaintainRoom {
    
    private roomDA rmDA;

    public MaintainRoom() {
        rmDA = new roomDA();
    }
    
       
    public Room selectRecord(String id){
        return rmDA.getRecord(id);
    }
    
    public void addRecord(Room r){
        rmDA.addRecord(r);
    }
    
    
    public void deleteRecord(String id){
        rmDA.deleteRecord(id);
    }    
    
    public void updateRecord(Room r){
       rmDA.updateRecord(r);
    }
   public ResultSet searchRecord(String id){
        return rmDA.selectRecord(id);
    }
    public void FillComboboxItem(){
         rmDA.FillCombobox();
    }
    public ResultSet addRecordToField(String id){
        return rmDA.addRecordToField(id);
    }
    
    public Room selectRecordForReserve(String roomType){
        return rmDA.getRecordForReserve(roomType);
    }
    
    public Room getAllRecord(){
       return rmDA.getAllRecord();
    }
            
    public Room getAllRecordForPayment(){
       return rmDA.getAllRecordForPayment();
    }
    
    public void updateRoomStatus(String roomId){
        rmDA.updateRoomStatus(roomId);
    }
}
