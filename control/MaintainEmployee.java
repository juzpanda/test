package control;

import da.employeeDA;
import domain.Employee;
import java.sql.ResultSet;

public class MaintainEmployee {
    
    private employeeDA empDA;

    public MaintainEmployee() {
        empDA = new employeeDA();
    }
    
    public Employee selectAllRecord(){
        return empDA.getAllRecord();
    }  
    
    public Employee selectRecord(String id){
        return empDA.getRecord(id);
    }
    
    public void addRecord(Employee e){
        empDA.addRecord(e);
    }
    
    
    public void deleteRecord(String id){
        empDA.deleteRecord(id);
    }
    
     public void updateRecord(Employee e){
        empDA.updateRecord(e);
    }
     
         public ResultSet searchRecord(String id){
        return empDA.selectRecord(id);
    }
    public void FillComboboxItem(){
         empDA.FillCombobox();
    }
    public ResultSet addRecordToField(String id){
        return empDA.addRecordToField(id);
    }
    
}
