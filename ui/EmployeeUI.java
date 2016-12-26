package ui;

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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import domain.Employee;
import control.MaintainEmployee;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPasswordField;

public class EmployeeUI extends JFrame{
    
    private JPanel button = new JPanel(new GridLayout(1,1));
    private JPanel top = new JPanel (new GridLayout(1,2));
    private JLabel logoImage = new JLabel(new ImageIcon("Image/home.jpg"));
    private JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
     
    //  for add employee
     JTextField jtfEmployeeId = new JTextField(20);
     JTextField jtfEmployeeName = new JTextField(30);
     JTextField jtfEmployeeAge = new JTextField(20);
     JTextField jtfEmployeeAddress = new JTextField(80);
     JTextField jtfEmployeeTel = new JTextField(20);
     JPasswordField jtfEmployeePassword = new JPasswordField(20);
     String[] department = {"","FO - Front Office","F&B - Food & Beverage","HR - Human Resources","S&M - Sales & Marketing"};
     JComboBox jcboDepartment = new JComboBox(department);
     String gender = null;
     
     //for delete employee
     JTextField jtfEmployeeId1 = new JTextField(20);
     JTextField jtfEmployeeName1 = new JTextField(30);
     JTextField jtfEmployeeAge1 = new JTextField(20);
     JTextField jtfEmployeeAddress1 = new JTextField(80);
     JTextField jtfEmployeeTelephoneNo1 = new JTextField(20);
     JPasswordField jtfEmployeePassword1 = new JPasswordField(20);
     JRadioButton male1 = new JRadioButton("Male");
     JRadioButton female1 = new JRadioButton("Female");
     String[] department1 = {"","FO - Front Office","F&B - Food & Beverage","HR - Human Resources","S&M - Sales & Marketing"};
     JComboBox jcboDepartment1 = new JComboBox(department1);
     JButton jbtDelete = new JButton("Delete");
     JButton jbtSearch1 = new JButton("Search");
     
     //for edit employee
     JTextField jtfEmployeeId2 = new JTextField(20);
     JTextField jtfEmployeeName2 = new JTextField(30);
     JTextField jtfEmployeeAge2 = new JTextField(20);
     JTextField jtfEmployeeAddress2 = new JTextField(80);
     JTextField jtfEmployeeTelephoneNo2 = new JTextField(20);
     JPasswordField jtfEmployeePassword2 = new JPasswordField(20);
     JRadioButton male2 = new JRadioButton("Male");
     JRadioButton female2 = new JRadioButton("Female");
     String[] department2 = {"","FO - Front Office","F&B - Food & Beverage","HR - Human Resources","S&M - Sales & Marketing"};
     JComboBox jcboDepartment2 = new JComboBox(department2);
     JButton jbtSave = new JButton("Save");
     JButton jbtSearch2 = new JButton("Search");
     
     public static JComboBox jcboId = new JComboBox();
     public static JLabel jtfEmployeeName3 = new JLabel();
     public static JLabel jtfEmployeeAge3 = new JLabel();
     public static JLabel jtfEmployeeAddress3 = new JLabel();
     public static JLabel jtfEmployeeTel3 = new JLabel();
     public static JLabel jtfEmployeePassword3 = new JLabel();
     public static JLabel jtfGender = new JLabel();
     public static JLabel jtfDepartment = new JLabel();
     
     String departmentId=null;
     String id;
     private MaintainEmployee empControl;
     
    public EmployeeUI(){
        
    empControl = new MaintainEmployee();    
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon addIcon = new ImageIcon("Image/add.jpg");
    ImageIcon editIcon = new ImageIcon("Image/edit.png");
    ImageIcon deleteIcon = new ImageIcon("Image/remove.png");
    ImageIcon viewIcon = new ImageIcon("Image/view.png");
    
    
    
    addEmployee(tabbedPane, addIcon, "Add Employee", "Add Employee");
    deleteEmployee(tabbedPane, deleteIcon, "Delete Employee", "Delete Employee");
    editEmployee(tabbedPane, editIcon, "Edit Employee", "Edit Employee");
    viewEmployee(tabbedPane, viewIcon, "View Employee", "View Employee");
    
    getContentPane().add(logoImage, BorderLayout.NORTH);
    add(tabbedPane, BorderLayout.CENTER);
    
    setTitle("Employee");
    setSize(1000,600);
    setVisible(true);
    setResizable(false);
    
    }
    
    private void addEmployee(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1){
        JButton jbtAdd = new JButton("Add");
        JButton jbtCancel = new JButton("Cancel");
        JButton jbtReset = new JButton("Reset");
        
        JLabel jlbEmployeeId = new JLabel("Employee ID:");
        JLabel jlbEmployeeName = new JLabel("Name:");
        JLabel jlbEmployeeAge = new JLabel("Age:");
        JLabel jlbEmployeeGender = new JLabel("Gender:");
        JLabel jlbEmployeeAddress = new JLabel("Address:");
        JLabel jlbEmployeeTel = new JLabel("Telephone No:          ");
        JLabel jlbEmployeePassword = new JLabel("Password:");
        JLabel jlbEmployeeDepartment = new JLabel("Department:");
        
        
       
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderButton = new ButtonGroup();
     
        final String[] department = {"","FO - Front Office","F&B - Food & Beverage","HR - Human Resources","S&M - Sales & Marketing"};
        final JComboBox jcboDepartment = new JComboBox(department);
        
        JLabel jlbSpace = new JLabel("                                         ");
        
        JPanel jpTitle = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpMid = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpBtm = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpGender = new JPanel(new GridLayout(1,2,8,8));
        JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Employee", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
        
        jpTop.add(jlbEmployeeId);
           jpMid.add(jtfEmployeeId);
           jtfEmployeeId.setEditable(false);
           RetrieveListener();
           jpTop.add(jlbEmployeeName);
           jpMid.add(jtfEmployeeName);
           jpTop.add(jlbEmployeeAge);
           jpMid.add(jtfEmployeeAge);
           jpTop.add(jlbEmployeeGender);
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
           jpTop.add(jlbEmployeeAddress);
           jpMid.add(jtfEmployeeAddress);
           jpTop.add(jlbEmployeeTel);
           jpMid.add(jtfEmployeeTel);
           jpTop.add(jlbEmployeePassword);
           jpMid.add(jtfEmployeePassword);
           jpTop.add(jlbEmployeeDepartment);
           jpMid.add(jcboDepartment);
           jcboDepartment.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        
                        if(event.getStateChange()==ItemEvent.SELECTED)
                           if(jcboDepartment.getSelectedItem()==department[1])
                               departmentId = "FO";
                           else if(jcboDepartment.getSelectedItem()==department[2])
                               departmentId = "F&B";
                           else if(jcboDepartment.getSelectedItem()==department[3])
                               departmentId = "HR";
                           else if(jcboDepartment.getSelectedItem()==department[4])
                               departmentId = "S&M";
                    }
                }
        );
           
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
           
           jpButtonBtm.add(jbtAdd);
           jpButtonBtm.add(jbtReset);
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
              
            
         jtfEmployeeName.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                String st=jtfEmployeeName.getText();
                jtfEmployeeName.setText(st.toUpperCase());
            }
	});
         
          jtfEmployeeName.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
            if (!(Character.isLetter(c) || (c == ' ') ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
         
       jtfEmployeeAge.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
            if (!(Character.isDigit(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
       
         jtfEmployeeTel.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || 
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
         
         jbtAdd.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent a) {
        //for checking if there is a missing information
		  if (checkAddData()) {
         String encryptedPassword = encrypt(jtfEmployeePassword.getText());
        Employee e = new Employee(id,jtfEmployeeName.getText(),Integer.parseInt(jtfEmployeeAge.getText()),jtfEmployeeAddress.getText(),gender,jtfEmployeeTel.getText(), encryptedPassword, departmentId);
            empControl.addRecord(e);
            JOptionPane.showMessageDialog(null,"New employee has added");
            dispose();
          new EmployeeUI();
		   
        }}});
         
          jbtReset.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
                 jtfEmployeeName.setText("");
                 jtfEmployeeAge.setText("");
                 jtfEmployeeAddress.setText("");
                 jtfEmployeeTel.setText("");
                 jtfEmployeePassword.setText("");
		   
	}});    
          
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
          
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
    
           tabbedPane.addTab(text, icon, jpTitle, text1);
    }
    
 
    private void deleteEmployee(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1){
        
        JButton jbtCancel = new JButton("Cancel");
        JButton jbtSearch = new JButton("Search");
        
        JLabel jlbEmployeeId = new JLabel("Employee ID:");
        JLabel jlbEmployeeName = new JLabel("Name:");
        JLabel jlbEmployeeAge = new JLabel("Age:");
        JLabel jlbEmployeeGender = new JLabel("Gender:");
        JLabel jlbEmployeeAddress = new JLabel("Address:");
        JLabel jlbEmployeeTel = new JLabel("Telephone No:          ");
        JLabel jlbEmployeePassword = new JLabel("Password:");
        JLabel jlbEmployeeDepartment = new JLabel("Department:");
        
         
        
        
        ButtonGroup genderButton = new ButtonGroup();
        
        
        JLabel jlbSpace = new JLabel("                                         ");
        
        JPanel jpTitle = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpMid = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpBtm = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpGender = new JPanel(new GridLayout(1,2,8,8));
        JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Employee", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbEmployeeId);
           jpMid.add(jtfEmployeeId1);
           jpTop.add(jlbEmployeeName);
           jpMid.add(jtfEmployeeName1);
           jpTop.add(jlbEmployeeAge);
           jpMid.add(jtfEmployeeAge1);
           jpTop.add(jlbEmployeeGender);
           genderButton.add(male1);
           genderButton.add(female1);
           jpGender.add(male1);
           jpGender.add(female1);
           jpMid.add(jpGender);
           jpTop.add(jlbEmployeeAddress);
           jpMid.add(jtfEmployeeAddress1);
           jpTop.add(jlbEmployeeTel);
           jpMid.add(jtfEmployeeTelephoneNo1);
           jpTop.add(jlbEmployeePassword);
           jpMid.add(jtfEmployeePassword1);
           jpTop.add(jlbEmployeeDepartment);
          
           jpMid.add(jcboDepartment1);
           
           jtfEmployeeName1.setEditable(false);
           jtfEmployeeAge1.setEditable(false);
           jtfEmployeeAddress1.setEditable(false);
           jtfEmployeeTelephoneNo1.setEditable(false);
           male1.setEnabled(false);
           female1.setEnabled(false);
           jtfEmployeePassword1.setEditable(false);
           jcboDepartment1.setEnabled(false);
           jbtDelete.setEnabled(false);
           
           jpBtm.add(jbtSearch);
           jbtSearch.addActionListener(new selectRecord());
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
           
           jpButtonBtm.add(jbtDelete);
           jbtDelete.addActionListener(new DeleteListener());
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           
              jtfEmployeeId1.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfEmployeeId1.getText();
            jtfEmployeeId1.setText(st.toUpperCase());
             }
        });
    
    
      	jtfEmployeeId1.addKeyListener(new KeyAdapter() {
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
           
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
    
    tabbedPane.addTab(text, icon, jpTitle, text1);
           
    }
    
    private void editEmployee(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1){
        JButton jbtCancel = new JButton("Cancel");
        
        
        
        JLabel jlbEmployeeId = new JLabel("Employee ID:");
        JLabel jlbEmployeeName = new JLabel("Name:");
        JLabel jlbEmployeeAge = new JLabel("Age:");
        JLabel jlbEmployeeGender = new JLabel("Gender:");
        JLabel jlbEmployeeAddress = new JLabel("Address:");
        JLabel jlbEmployeeTel = new JLabel("Telephone No:          ");
        JLabel jlbEmployeePassword = new JLabel("Password:");
        JLabel jlbEmployeeDepartment = new JLabel("Department:");
    
         
       
        ButtonGroup genderButton = new ButtonGroup();
       
      
    
         JLabel jlbSpace = new JLabel("                                         ");
         
        JPanel jpTitle = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpMid = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpBtm = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpGender = new JPanel(new GridLayout(1,2,8,8));
        JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Employee", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbEmployeeId);
           jpMid.add(jtfEmployeeId2);
           jpTop.add(jlbEmployeeName);
           jpMid.add(jtfEmployeeName2);
           jpTop.add(jlbEmployeeAge);
           jpMid.add(jtfEmployeeAge2);
           jpTop.add(jlbEmployeeGender);
           genderButton.add(male2);
           genderButton.add(female2);
           jpGender.add(male2);
           jpGender.add(female2);
               male2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                gender="MALE";
            }
	}});
           female2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                gender="FEMALE";
            }
	}});
           
           
           jpMid.add(jpGender);
           jpTop.add(jlbEmployeeAddress);
           jpMid.add(jtfEmployeeAddress2);
           jpTop.add(jlbEmployeeTel);
           jpMid.add(jtfEmployeeTelephoneNo2);
           jpTop.add(jlbEmployeePassword);
           jpMid.add(jtfEmployeePassword2);
           jpTop.add(jlbEmployeeDepartment);
           jpMid.add(jcboDepartment2);
            jcboDepartment2.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        
                        if(event.getStateChange()==ItemEvent.SELECTED)
                           if(jcboDepartment2.getSelectedItem()==department2[1])
                               departmentId = "FO";
                           else if(jcboDepartment2.getSelectedItem()==department2[2])
                               departmentId = "F&B";
                           else if(jcboDepartment2.getSelectedItem()==department2[3])
                               departmentId = "HR";
                           else if(jcboDepartment2.getSelectedItem()==department2[4])
                               departmentId = "S&M";
                    }
                }
        );
           
           jtfEmployeeName2.setEditable(false);
           jtfEmployeeAge2.setEditable(false);
           jtfEmployeeAddress2.setEditable(false);
           jtfEmployeeTelephoneNo2.setEditable(false);
           male2.setEnabled(false);
           female2.setEnabled(false);
           jtfEmployeePassword2.setEditable(false);
           jcboDepartment2.setEnabled(false);
           jbtSave.setEnabled(false);
           
           jpBtm.add(jbtSearch2);
           jbtSearch2.addActionListener(new selectRecord1());
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
           
           jpButtonBtm.add(jbtSave);
           jbtSave.addActionListener(new UpdateListener());
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           
        jtfEmployeeId2.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfEmployeeId2.getText();
            jtfEmployeeId2.setText(st.toUpperCase());
             }
        });
    
    
      	jtfEmployeeId2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
        
         jtfEmployeeName2.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                String st=jtfEmployeeName2.getText();
                jtfEmployeeName2.setText(st.toUpperCase());
            }
	});
         
          jtfEmployeeName2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
            if (!(Character.isLetter(c) || (c == ' ') ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
         
       jtfEmployeeAge2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
            if (!(Character.isDigit(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
       
         jtfEmployeeTelephoneNo2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || 
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
         
           
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
           
        
                     
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
    
    tabbedPane.addTab(text, icon, jpTitle, text1);
    }
    
    private void viewEmployee(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1){
        JButton jbtCancel = new JButton("Cancel");
       JLabel jlbEmployeeId = new JLabel("Employee ID:");
        JLabel jlbEmployeeName = new JLabel("Name:");
        JLabel jlbEmployeeAge = new JLabel("Age:");
        JLabel jlbEmployeeGender = new JLabel("Gender:");
        JLabel jlbEmployeeAddress = new JLabel("Address:");
        JLabel jlbEmployeeTel = new JLabel("Telephone No:          ");
        JLabel jlbEmployeeDepartment = new JLabel("Department:");
        
        jlbEmployeeId.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbEmployeeName.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbEmployeeAge.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbEmployeeGender.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbEmployeeAddress.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbEmployeeTel.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbEmployeeDepartment.setFont(new Font("Arial", Font.PLAIN, 20));
        JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel jlbSpace = new JLabel("                                                  ");             
             
        
        JPanel jpTitle = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpMid = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpBtm = new JPanel(new GridLayout(8,2,8,8));
        jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Employee", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
       jcboId.removeAllItems();
        empControl.FillComboboxItem();
        
        jpTop.add(jlbEmployeeId);
        jpTop.add(jlbEmployeeName);
        jpTop.add(jlbEmployeeAge);
        jpTop.add(jlbEmployeeGender);
        jpTop.add(jlbEmployeeAddress);
        jpTop.add(jlbEmployeeTel);
        jpTop.add(jlbEmployeeDepartment);
               
         jpMid.add(jcboId);
         jpMid.add(jtfEmployeeName3);
         jpMid.add(jtfEmployeeAge3);
         jpMid.add(jtfGender);
         jpMid.add(jtfEmployeeAddress3); 
         jpMid.add(jtfEmployeeTel3); 
         jpMid.add(jtfDepartment);
         jpMid.add(jpButtonBtm);
         jcboId.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfEmployeeName3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfEmployeeAge3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfGender.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfEmployeeAddress3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfEmployeeTel3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfDepartment.setFont(new Font("Arial", Font.PLAIN, 20));
         
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         jpBtm.add(jlbSpace);
         
         
         jcboId.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {

                   empControl.addRecordToField(String.valueOf(jcboId.getSelectedItem()));
            }});
         jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
         
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
    
    tabbedPane.addTab(text, icon, jpTitle, text1);
    }
    
    //check add data
    public boolean checkAddData(){
     boolean	check = true;
        if(jtfEmployeeName.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Name.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check=false;
        }
        else if(jtfEmployeeAge.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Age .","Empty Field",JOptionPane.ERROR_MESSAGE);
             check=false;
        }
        else if(jtfEmployeeAddress.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Address.","Empty Field",JOptionPane.ERROR_MESSAGE);
             check=false;
        }
        else if(jtfEmployeeTel.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Telephone Number.","Empty Field",JOptionPane.ERROR_MESSAGE);
             check=false;
        }
        else if(jtfEmployeePassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Password.","Empty Field",JOptionPane.ERROR_MESSAGE);
             check=false;
        }
       
    	return check;
    }
    //Check id for delete
    public boolean checkDeleteId(){
     boolean	check = true;
        if(jtfEmployeeId1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
    
    //Check id for edit
    public boolean checkEditId(){
     boolean	check = true;
        if(jtfEmployeeId2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
    
    //check edit data
    public boolean checkEditData(){
     boolean	check = true;
        if(jtfEmployeeName2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Name.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtfEmployeeAge2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Age .","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtfEmployeeAddress2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Address.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtfEmployeeTelephoneNo2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Telephone Number.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtfEmployeePassword2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Employee Password.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
       
    	return check;
    }
    
private void RetrieveListener(){
        Employee e = empControl.selectAllRecord();
        id = e.getEmployeeId();
        int countId = id.length();
        String idFront = id.substring(0,1);
        String idBack = id.substring(1,countId);
        int idBack1 = Integer.parseInt(idBack);
        int idBack2 = idBack1+1;
        Integer.toString(idBack2);
        id = idFront + idBack2;
        if(e != null){
            
            jtfEmployeeId.setText(id);
        }
    }

private class selectRecord implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             if (checkDeleteId()) {
            String id = jtfEmployeeId1.getText();
            Employee employee = empControl.selectRecord(id);
            if (employee != null) {
                jtfEmployeeName1.setText(employee.getEmployeeName());
                jtfEmployeeAge1.setText(String.valueOf(employee.getEmployeeAge()));
                jtfEmployeeAddress1.setText(employee.getEmployeeAddress());
                String deleteGender = employee.getEmployeeGender();
                if(deleteGender.equals("MALE"))
                    male1.setSelected(true);
                else if(deleteGender.equals("FEMALE"))
                    female1.setSelected(true);                
                jtfEmployeeTelephoneNo1.setText(employee.getEmployeeTelephoneNo());
                jtfEmployeePassword1.setText(employee.getEmployeePassword());
                String deleteDepartment = employee.getDepartmentId();
                if(deleteDepartment.equals("FO"))
                    jcboDepartment1.setSelectedItem(department1[1]);
                else if(deleteDepartment.equals("F&B"))
                    jcboDepartment1.setSelectedItem(department1[2]);
                else if(deleteDepartment.equals("HR"))
                    jcboDepartment1.setSelectedItem(department1[3]);
                else if(deleteDepartment.equals("S&M"))
                    jcboDepartment1.setSelectedItem(department1[4]);
                
                jbtDelete.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No such employee ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
             }
        }
    }

private class selectRecord1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             
            String id = jtfEmployeeId2.getText();
            Employee employee = empControl.selectRecord(id);
            if (employee != null) {
                jtfEmployeeName2.setText(employee.getEmployeeName());
                jtfEmployeeAge2.setText(String.valueOf(employee.getEmployeeAge()));
                jtfEmployeeAddress2.setText(employee.getEmployeeAddress());
                String updateGender = employee.getEmployeeGender();
                if(updateGender.equals("MALE"))
                    male2.setSelected(true);
                else if(updateGender.equals("FEMALE"))
                    female2.setSelected(true);                
               jtfEmployeeTelephoneNo2.setText(employee.getEmployeeTelephoneNo());
                jtfEmployeePassword2.setText(employee.getEmployeePassword());
                String deleteDepartment = employee.getDepartmentId();
                if(deleteDepartment.equals("FO"))
                    jcboDepartment2.setSelectedItem(department1[1]);
                else if(deleteDepartment.equals("F&B"))
                    jcboDepartment2.setSelectedItem(department1[2]);
                else if(deleteDepartment.equals("HR"))
                    jcboDepartment2.setSelectedItem(department1[3]);
                else if(deleteDepartment.equals("S&M"))
                    jcboDepartment2.setSelectedItem(department1[4]);
                
                jtfEmployeeId2.setEditable(false);
                jtfEmployeeName2.setEditable(true);
                jtfEmployeeAge2.setEditable(true);
                jtfEmployeeAddress2.setEditable(true);
                jtfEmployeeTelephoneNo2.setEditable(true);
                male2.setEnabled(true);
                female2.setEnabled(true);
                jtfEmployeePassword2.setEditable(true);
                jcboDepartment2.setEnabled(true);
                jbtSave.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No such employee ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
              }
        
    }

private class DeleteListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
         
        String id = jtfEmployeeId1.getText();
        
        Employee e = empControl.selectRecord(id);
        
        if(e != null){
            
            int option = JOptionPane.showConfirmDialog(null, "Are You Sure?");
            
            if(option == JOptionPane.YES_OPTION){
                empControl.deleteRecord(id);
                JOptionPane.showMessageDialog(null, "Record Deleted.");
                clearText();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"No such employee ID","Record not found",JOptionPane.ERROR_MESSAGE);
            
        }
          dispose();
          new EmployeeUI();
        
    }
}

private class UpdateListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
     if (checkEditData()) {
            String updateId = jtfEmployeeId2.getText();
            String encryptedPassword = encrypt(jtfEmployeePassword2.getText());
            Employee e = new Employee(updateId,jtfEmployeeName2.getText(),Integer.parseInt(jtfEmployeeAge2.getText()),jtfEmployeeAddress2.getText(),gender,jtfEmployeeTelephoneNo2.getText(), encryptedPassword, departmentId);
            
            empControl.updateRecord(e);
            
            JOptionPane.showMessageDialog(null,"Record Updated.");
        }
     dispose();
          new EmployeeUI();
    }
   
}
   public String encrypt(String password){
     int a = 123;
     String s = password;
     String ans = "";
     for(int i = 0; i < s.length(); i++)
     {
         char c = (char)(s.charAt(i)+ a );
           ans += c;
     }
        return ans;
    
     }

    private void clearText(){
    jtfEmployeeId1.setText("");
    jtfEmployeeName1.setText("");
    jtfEmployeeAge1.setText("");
    jtfEmployeeAddress1.setText("");
    jtfEmployeeTelephoneNo1.setText("");
    jtfEmployeePassword1.setText("");
    jcboDepartment1.setSelectedItem(department[0]);
    jtfEmployeeId1.requestFocusInWindow();
}
}
                   
