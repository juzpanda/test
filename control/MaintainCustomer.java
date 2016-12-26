package control;

import da.customerDA;
import domain.Customer;
import java.sql.ResultSet;

public class MaintainCustomer {
    
    private customerDA custDA;

    public MaintainCustomer() {
        custDA = new customerDA();
    }
    
    public Customer selectAllRecord(){
        return custDA.getAllRecord();
    }  
    
    public Customer selectRecord(String id){
        return custDA.getRecord(id);
    }
    
    public void addRecord(Customer c){
        custDA.addRecord(c);
    }
    
    
    public void deleteRecord(String id){
        custDA.deleteRecord(id);
    }
    
     public void updateRecord(Customer c){
        custDA.updateRecord(c);
    }
    
       public ResultSet searchRecord(String id){
        return custDA.selectRecord(id);
    }
    public void FillComboboxItem(){
         custDA.FillCombobox();
    }
    public ResultSet addRecordToField(String id){
        return custDA.addRecordToField(id);
    }
    
    public void updatePoint(String id,Integer point){
        custDA.updatePoint(id, point);
    }
}
