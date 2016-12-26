package ui;

import control.MaintainCustomer;
import domain.Customer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class CustomerUI extends JFrame {
    
    private JPanel button = new JPanel(new GridLayout(1,1));
    private JPanel top = new JPanel (new GridLayout(1,2));
    private JLabel logoImage = new JLabel(new ImageIcon("Image/home.jpg"));
    private JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
       //text field for add 
      JTextField jtfCustomerId = new JTextField(20);
      JTextField jtfCustomerName = new JTextField(20);
      JTextField jtfCustomerAddress = new JTextField(80);
      JTextField jtfCustomerTelephoneNo = new JTextField(20);
      JRadioButton male = new JRadioButton("Male");
      JRadioButton female = new JRadioButton("Female");
     
      //text field delete add 
      JTextField jtfCustomerId1 = new JTextField(20); 
       JTextField jtfCustomerName1 = new JTextField(20);
      JTextField jtfCustomerAddress1 = new JTextField(80);
      JTextField jtfCustomerTelephoneNo1 = new JTextField(20);
      JRadioButton male1 = new JRadioButton("Male");
      JRadioButton female1 = new JRadioButton("Female");
      JButton jbtDelete = new JButton("Delete");
      JButton jbtSearch1 = new JButton("Search");
      //text field for edit
      JTextField jtfCustomerId2 = new JTextField(20);
      JTextField jtfCustomerName2 = new JTextField(20);
      JTextField jtfCustomerAddress2 = new JTextField(80);
     JTextField jtfCustomerTelephoneNo2 = new JTextField(20);
      JRadioButton male2 = new JRadioButton("Male");
      JRadioButton female2 = new JRadioButton("Female");
       String gender2;
      JButton jbtSave = new JButton("Save");
      JButton jbtSearch2 = new JButton("Search");
      int customerPoint;
      
     public static JComboBox jcboId = new JComboBox();
     
     public static JLabel jtfCustomerName3 = new JLabel();
     public static JLabel jtfCustomerAddress3 = new JLabel();
     public static JLabel jtfCustomerTelephone3 = new JLabel();
     public static JLabel jtfGender = new JLabel();
     public static JLabel jtfCustomerPoint3 = new JLabel();
      String employeeId;
      String id=null;
      String gender;
      private MaintainCustomer custControl;
      
    public CustomerUI(){
        
        custControl = new MaintainCustomer();    
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon addIcon = new ImageIcon("Image/add.jpg");
    ImageIcon editIcon = new ImageIcon("Image/edit.png");
    ImageIcon deleteIcon = new ImageIcon("Image/remove.png");
    ImageIcon viewIcon = new ImageIcon("Image/view.png");
    
    
    addCustomer(tabbedPane, addIcon, "Add Customer", "Add Customer");
    removeCustomer(tabbedPane, deleteIcon, "Delete Customer", "Delete Customer");
    editCustomer(tabbedPane, editIcon, "Edit Customer", "Edit Customer");
    viewCustomer(tabbedPane, viewIcon, "View Customer", "View Customer");
    
    getContentPane().add(logoImage, BorderLayout.NORTH);
    
    add(tabbedPane, BorderLayout.CENTER);
 
    setTitle("Customer");
    setSize(1000,600);
    setVisible(true);
    setResizable(false);
    }
    
  private void addCustomer(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
      
    JButton jbtEdit = new JButton("Edit");
    JButton jbtDelete = new JButton("Delete");
    JButton jbtView = new JButton("View");
    JButton jbtAdd = new JButton("Add");
    JButton jbtCancel = new JButton("Cancel");
    JButton jbtReset = new JButton("Reset");
      
     JLabel jlbCustomerId = new JLabel     ("Customer ID           :        ");
     JLabel jlbCustomerName = new JLabel   ("Name                       :        ");
     JLabel jlbCustomerGender = new JLabel ("Gender                    :        ");
     JLabel jlbCustomerAddress = new JLabel("Address                  :        ");
     JLabel jlbCustomerTel = new JLabel    ("Telephone No        :        ");
     JLabel jlbSpace = new JLabel("                                         ");
    
    
    ButtonGroup genderButton = new ButtonGroup();
     
    
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpMid = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpGender = new JPanel(new GridLayout(1,2,8,8));
    
    jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Customer", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbCustomerId);
           jpMid.add(jtfCustomerId);
           jtfCustomerId.setEditable(false);
           RetrieveListener();
           jpTop.add(jlbCustomerName);
           jpMid.add(jtfCustomerName);
           jpTop.add(jlbCustomerGender);
           genderButton.add(male);
           genderButton.add(female);
           jpGender.add(male);
           jpGender.add(female);
           male.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                gender="MALE";
            }
	}});
           female.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                gender="FEMALE";
            }
	}});
           jpMid.add(jpGender);
           jpTop.add(jlbCustomerAddress);
           jpMid.add(jtfCustomerAddress);
           jpTop.add(jlbCustomerTel);
           jpMid.add(jtfCustomerTelephoneNo);
         
            jtfCustomerId.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfCustomerId.getText();
            jtfCustomerId.setText(st.toUpperCase());
             }
        });
    
    
      	jtfCustomerId.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
        
         jtfCustomerName.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                String st=jtfCustomerName.getText();
                jtfCustomerName.setText(st.toUpperCase());
            }
	});
         
       jtfCustomerName.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
            if (!(Character.isLetter(c) || (c == ' ') ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
       
       jtfCustomerTelephoneNo.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || 
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
           
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
           
           jpButtonBtm.add(jbtAdd);
           jbtAdd.addActionListener(new AddListener());
                        
        jbtReset.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
            jtfCustomerName.setText("");
            jtfCustomerAddress.setText("");
            jtfCustomerTelephoneNo.setText("");
		   
	}});    
           
           jpButtonBtm.add(jbtReset);
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
    tabbedPane.addTab(text, icon, jpTitle, text1);
   
  }

   private void removeCustomer(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
       
    JButton jbtEdit = new JButton("Edit");
    
    JButton jbtView = new JButton("View");
    JButton jbtAdd = new JButton("Add");
    JButton jbtCancel = new JButton("Cancel");
    JButton jbtReset = new JButton("Reset");
    JButton jbtSave = new JButton("Save");
    
     JLabel jlbCustomerId = new JLabel     ("Customer ID           :        ");
     JLabel jlbCustomerName = new JLabel   ("Name                       :        ");
     JLabel jlbCustomerGender = new JLabel ("Gender                    :        ");
     JLabel jlbCustomerAddress = new JLabel("Address                  :        ");
     JLabel jlbCustomerTel = new JLabel    ("Telephone No        :        ");
     JLabel jlbSpace = new JLabel("                                         ");
    
     
     ButtonGroup genderButton = new ButtonGroup();
    
     JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel jpTitle = new JPanel(new BorderLayout());
     JPanel jpTop = new JPanel(new GridLayout(5,1,8,8));
     JPanel jpMid = new JPanel(new GridLayout(5,1,8,8));
     JPanel jpBtm = new JPanel(new GridLayout(5,1,8,8));
     JPanel jpGender = new JPanel(new GridLayout(1,2,8,8));
    
    jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Customer", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbCustomerId);
           jpMid.add(jtfCustomerId1);
           jpTop.add(jlbCustomerName);
           jpMid.add(jtfCustomerName1);
           jpTop.add(jlbCustomerGender);
           genderButton.add(male1);
           genderButton.add(female1);
           jpGender.add(male1);
           jpGender.add(female1);
           jpMid.add(jpGender);
           jpTop.add(jlbCustomerAddress);
           jpMid.add(jtfCustomerAddress1);
           jpTop.add(jlbCustomerTel);
           jpMid.add(jtfCustomerTelephoneNo1);
         
           
           jpBtm.add(jbtSearch1);
           jbtSearch1.addActionListener(new selectRecord());
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
            jtfCustomerId1.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfCustomerId1.getText();
            jtfCustomerId1.setText(st.toUpperCase());
             }
            });
    
    
            jtfCustomerId1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
             }
            });
            
                      
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
           
            
           
           jpButtonBtm.add(jbtDelete);
           jbtDelete.addActionListener(new DeleteListener());
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           jtfCustomerName1.setEditable(false);
           jtfCustomerAddress1.setEditable(false);
           jtfCustomerTelephoneNo1.setEditable(false);
           male1.setEnabled(false);
           female1.setEnabled(false);
           jbtDelete.setEnabled(false);
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
           
    
    tabbedPane.addTab(text, icon, jpTitle, text1);
    
  }
  
   private void editCustomer(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
     
   
    JButton jbtCancel = new JButton("Cancel");
    
    
     JLabel jlbCustomerId = new JLabel     ("Customer ID           :        ");
     JLabel jlbCustomerName = new JLabel   ("Name                       :        ");
     JLabel jlbCustomerGender = new JLabel ("Gender                    :        ");
     JLabel jlbCustomerAddress = new JLabel("Address                  :        ");
     JLabel jlbCustomerTel = new JLabel    ("Telephone No        :        ");
     JLabel jlbSpace = new JLabel("                                         ");
    
     
     ButtonGroup genderButton = new ButtonGroup();
     
     
     JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel jpTitle = new JPanel(new BorderLayout());
     JPanel jpTop = new JPanel(new GridLayout(5,1,8,8));
     JPanel jpMid = new JPanel(new GridLayout(5,1,8,8));
     JPanel jpBtm = new JPanel(new GridLayout(5,1,8,8));
     JPanel jpGender = new JPanel(new GridLayout(1,2,8,8));
    
    jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Customer", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbCustomerId);
           jpMid.add(jtfCustomerId2);
           jpTop.add(jlbCustomerName);
           jpMid.add(jtfCustomerName2);
           jpTop.add(jlbCustomerGender);
           genderButton.add(male2);
           genderButton.add(female2);
           jpGender.add(male2);
           jpGender.add(female2);
             male2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                gender2 ="MALE";
            }
	}});
           female2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                gender2 ="FEMALE";
            }
	}});
           jpMid.add(jpGender);
           jpTop.add(jlbCustomerAddress);
           jpMid.add(jtfCustomerAddress2);
           jpTop.add(jlbCustomerTel);
           jpMid.add(jtfCustomerTelephoneNo2);
         
           
           jpBtm.add(jbtSearch2);
           jbtSearch2.addActionListener(new selectRecord1());
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
              jtfCustomerId2.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfCustomerId2.getText();
            jtfCustomerId2.setText(st.toUpperCase());
             }
        });
    
    
      	jtfCustomerId2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
        
           jtfCustomerName2.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                String st=jtfCustomerName.getText();
                jtfCustomerName.setText(st.toUpperCase());
            }
	});
         
       jtfCustomerName2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
            if (!(Character.isLetter(c) || (c == ' ') ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
           
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
           
         
         
           
           jpButtonBtm.add(jbtSave);
           jbtSave.addActionListener(new UpdateListener());
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           jtfCustomerName2.setEditable(false);
           jtfCustomerAddress2.setEditable(false);
           jtfCustomerTelephoneNo2.setEditable(false);
           male2.setEnabled(false);
           female2.setEnabled(false);
           jbtSave.setEnabled(false);
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
           
    tabbedPane.addTab(text, icon, jpTitle, text1);
    
  }
   
    private void viewCustomer(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
        
       JButton jbtCancel = new JButton("Cancel");
       JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JLabel jlbCustomerId = new JLabel("Customer ID:");
        JLabel jlbCustomerName = new JLabel("Name:");
        JLabel jlbCustomerGender = new JLabel("Gender:");
        JLabel jlbCustomerAddress = new JLabel("Address:");
        JLabel jlbCustomerTel = new JLabel("Telephone No:          ");
        JLabel jlbCustomerPoint = new JLabel("Cumulative Point:");
        
        jlbCustomerId.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbCustomerName.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbCustomerGender.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbCustomerAddress.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbCustomerTel.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbCustomerPoint.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JLabel jlbSpace = new JLabel("                                                  ");             
             
        
        JPanel jpTitle = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpMid = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpBtm = new JPanel(new GridLayout(8,2,8,8));
        jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Customer", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
        
        
        
         jpTop.add(jlbCustomerId);
         jpTop.add(jlbCustomerName);
         jpTop.add(jlbCustomerGender);
         jpTop.add(jlbCustomerAddress);
         jpTop.add(jlbCustomerTel);
         jpTop.add(jlbCustomerPoint);
               
         jpMid.add(jcboId);

         jpMid.add(jtfCustomerName3);
         jpMid.add(jtfGender);
         jpMid.add(jtfCustomerAddress3); 
         jpMid.add(jtfCustomerTelephone3); 
         jpMid.add(jtfCustomerPoint3);
         jpButton.add(jbtCancel);
         jpMid.add(jpButton);
         jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
         jcboId.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfCustomerName3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfGender.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfCustomerAddress3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfCustomerTelephone3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfCustomerPoint3.setFont(new Font("Arial", Font.PLAIN, 20));
         
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         
        jcboId.removeAllItems();
        
        custControl.FillComboboxItem();
         
         jcboId.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                    custControl.addRecordToField(String.valueOf(jcboId.getSelectedItem()));
                
            }});
         
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
    
    
   tabbedPane.addTab(text, icon, jpTitle, text1);
    
  }
     public boolean checkAddData(){
     boolean	check = true;
        if(jtfCustomerName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer Name.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check=false;
        }
        else if(jtfCustomerAddress.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer Address.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check=false;
        }
        else if(jtfCustomerTelephoneNo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer Telephone Number.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check=false;
        }
       
    	return check;
    }
     
     //check id for delete
     public boolean checkDeleteId(){
     boolean	check = true;
        if(jtfCustomerId1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
     
      //check id for edit
     public boolean checkEditId(){
     boolean	check = true;
        if(jtfCustomerId2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
      //check edit data
     public boolean checkEditData(){
     boolean	check = true;
        if(jtfCustomerName2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer Name.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtfCustomerAddress2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer Address.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtfCustomerTelephoneNo2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer Telephone Number.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
       
    	return check;
    }
     private class AddListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        //for checking if there is a missing information
		  if (checkAddData()) {
		   
        Customer c = new Customer(id,jtfCustomerName.getText(),jtfCustomerAddress.getText(),gender,jtfCustomerTelephoneNo.getText(),0,"S1");
        custControl.addRecord(c);
        JOptionPane.showMessageDialog(null,"New customer was added succesful");}
                  dispose();
                  new CustomerUI();
        }
        
}
     private void RetrieveListener(){
        Customer c = custControl.selectAllRecord();
        id = c.getCustomerId();
        int countId = id.length();
        String idFront = id.substring(0,1);
        String idBack = id.substring(1,countId);
        int idBack1 = Integer.parseInt(idBack);
        int idBack2 = idBack1+1;
        Integer.toString(idBack2);
        id = idFront + idBack2;
        if(c != null){
            
            jtfCustomerId.setText(id);
        }
    }
     
     private class selectRecord implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
   
        //for checking if there is a missing information
		  if (checkDeleteId()) {
                    
            String id = jtfCustomerId1.getText();
            Customer customer = custControl.selectRecord(id);
            if (customer != null) {
                jtfCustomerName1.setText(customer.getCustomerName());
                jtfCustomerAddress1.setText(customer.getCustomerAddress());
                String deleteGender = customer.getCustomerGender();
                 if(deleteGender.equals("MALE"))
                    male1.setSelected(true);
                else if(deleteGender.equals("FEMALE"))
                    female1.setSelected(true);                        
                jtfCustomerTelephoneNo1.setText(customer.getCustomerTelephoneNo());
                
                
                jbtDelete.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No such customer ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }}
     
     private class DeleteListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
        
        String id = jtfCustomerId1.getText();
        
        Customer c = custControl.selectRecord(id);
        
        if(c != null){
            
            int option = JOptionPane.showConfirmDialog(null, "Are You Sure?");
            
            if(option == JOptionPane.YES_OPTION){
                custControl.deleteRecord(id);
                JOptionPane.showMessageDialog(null, "Record Deleted.");
                clearText();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"No such customer ID","Record not found",JOptionPane.ERROR_MESSAGE);
            
        }
        dispose();
                  new CustomerUI();
        
    }
}
     private class selectRecord1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             
      
        //for checking if there is a missing information
		  if (checkEditId()) {
                    
            String id = jtfCustomerId2.getText();
            Customer customer = custControl.selectRecord(id);
            if (customer != null) {
                jtfCustomerName2.setText(customer.getCustomerName());
                jtfCustomerAddress2.setText(customer.getCustomerAddress());
                String updateGender = customer.getCustomerGender();
                if(updateGender.equals("MALE"))
                    male2.setSelected(true);
                else if(updateGender.equals("FEMALE"))
                    female2.setSelected(true);                
                jtfCustomerTelephoneNo2.setText(customer.getCustomerTelephoneNo());
                customerPoint = customer.getCustomerPoint();
                employeeId = customer.getEmployeeId();
                jtfCustomerId2.setEditable(false);
                jtfCustomerName2.setEditable(true);
                jtfCustomerAddress2.setEditable(true);
                jtfCustomerTelephoneNo2.setEditable(true);
                male2.setEnabled(true);
                female2.setEnabled(true);
                jbtSave.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No such customer ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }}
     
     private class UpdateListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
            if (checkEditData()) {
            String updateId = jtfCustomerId2.getText();
            
            Customer c = new Customer(updateId,jtfCustomerName2.getText(),jtfCustomerAddress2.getText(),gender2,jtfCustomerTelephoneNo2.getText(),customerPoint,employeeId);
            
            custControl.updateRecord(c);
            
            JOptionPane.showMessageDialog(null,"Record Updated.");
        }
            dispose();
                  new CustomerUI();
    }
   
}
     
      private void clearText(){
    jtfCustomerId1.setText("");
    jtfCustomerName1.setText("");
    jtfCustomerAddress1.setText("");
    jtfCustomerTelephoneNo1.setText("");
}
}