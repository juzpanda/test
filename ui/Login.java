package ui;

import control.MaintainEmployee;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame{
    private JLabel jlblStaffId = new JLabel("Staff ID           :");
    private JLabel jlblPassword = new JLabel("Password     :");
    private JTextField jtfStaffID = new JTextField(20);
    private JPasswordField jtfPassword = new JPasswordField(20);
    private JButton LoginButton = new JButton("Login");
    private JButton forgetButton = new JButton("Forget Password");
    private JButton cancelButton = new JButton("Cancel");
    private JLabel EnterImg = new JLabel(new ImageIcon("Image/mainpage.jpg"));
    
     JPanel staffLogin = new JPanel(new GridLayout(3,2,4,4));
     
          private MaintainEmployee empControl;
     
    public Login() {
        
         empControl = new MaintainEmployee();    
        
        Font myFont = new Font("Cambria",Font.BOLD,20);
       
        jlblStaffId.setFont(myFont);
        jlblPassword.setFont(myFont);
        jtfStaffID.setFont(myFont);
        jtfPassword.setFont(myFont);
        
        JPanel jpButton = new JPanel();
    
        staffLogin.add(jlblStaffId);
        staffLogin.add(jtfStaffID);
        jlblStaffId.setForeground(Color.white);
        staffLogin.add(jlblPassword);
        jlblPassword.setForeground(Color.white);
        staffLogin.add(jtfPassword);
        
        jpButton.add(LoginButton);
        jpButton.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
        getContentPane().add(EnterImg ,BorderLayout.CENTER);
        
        staffLogin.setOpaque(false);
        jpButton.setOpaque(false);
        EnterImg.add(staffLogin);
        EnterImg.add(jpButton);
        
        staffLogin.setBounds(600, 140, 380, 110);
        jpButton.setBounds(600, 250, 380, 110);
       
        jtfStaffID.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfStaffID.getText();
            jtfStaffID.setText(st.toUpperCase());
             }
        });
            LoginButton.setMnemonic(KeyEvent.VK_ENTER);
            
         LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                  if (checkData()) {
		    boolean check = true;}
                  
            String id = jtfStaffID.getText();
            String password = jtfPassword.getText();
            
            String idfront = id.substring(0,1);
               try{
                
                ResultSet rs = empControl.searchRecord(id);
                
                if(rs.next()){
                    String passwordDb = rs.getString("EMPLOYEEPASSWORD");
                    String idDb = rs.getString("EMPLOYEEID");
                    String nameDb = rs.getString("EMPLOYEENAME");
                    String decryptedPassword = decrypt(passwordDb);
                    
                    if(password.equals(decryptedPassword)){
                        dispose();
                        JOptionPane.showMessageDialog(null,"Welcome " + nameDb + " !","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                        if(idfront.equals("S")){
                        StaffMainMenu staffMenu = new StaffMainMenu();
                        }
                        else if(idfront.equals("M")){
                        ManagerMainMenu managerMenu = new ManagerMainMenu();
                        }
                    }
                    else if(password.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter Password!","Empty Field",JOptionPane.ERROR_MESSAGE);
                    jtfStaffID.setText("");
                    jtfPassword.setText("");
                    }
                    else if(!password.equals(decryptedPassword)){
                    JOptionPane.showMessageDialog(null,"Invalid password or id!","ERROR",JOptionPane.ERROR_MESSAGE);
                    jtfStaffID.setText("");
                    jtfPassword.setText("");
                    }
                     }
                    }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                 }}});    
        
        
        setSize(1000,320);
        setResizable(false);
        setTitle("Staff Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
     public boolean checkData(){
     boolean	check = true;
        if(jtfStaffID.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee ID!","Empty Field",JOptionPane.ERROR_MESSAGE);
        }
    	return check;
    }  
       public String decrypt(String password){
      int a = 123;
      String s = password;
     String ans = "";
     for(int i = 0; i < s.length(); i++)
     {
         char c = (char)(s.charAt(i)- a );
           ans += c;
     }
        return ans;
    }
    
     public static void main(String[] args) {
        new Login();
    }
    
}
