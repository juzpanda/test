
package control;

import da.paymentDA;
import domain.Payment;
import java.sql.ResultSet;

public class MaintainPayment {
    private paymentDA paymentDA;

    public MaintainPayment() {
        paymentDA = new paymentDA();
    }
    
     public void addRecord(Payment p){
        paymentDA.addRecord(p);
    }
    
    public Payment selectRecord(String id){
        return paymentDA.getRecord(id);
    }
    public void FillComboboxItem(){
         paymentDA.FillCombobox();
    }
    public ResultSet addRecordToField(String id){
        return paymentDA.addRecordToField(id);
    }
    
    public Payment selectAllRecord(){
        return paymentDA.getAllRecord();
    }  
    
    
}
