package ui;

import control.MaintainRoom;
import domain.Room;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
//import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class RoomUI extends JFrame {
    private JPanel button = new JPanel(new GridLayout(1,1));
    private JPanel top = new JPanel (new GridLayout(1,2));
    private JLabel logoImage = new JLabel(new ImageIcon("Image/home.jpg"));
    private JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
    
    //for add room
     JTextField jtfRoomId = new JTextField(20);
     JTextField jtfRoomPrice = new JTextField(20);
     JTextArea jtaRoomDescription = new JTextArea(5,20);
     String[] roomTypeList = {"","Deluxe Suite","Superior Suite","Georgetown Suite"};
     JComboBox jcboRoomType = new JComboBox(roomTypeList);
     JRadioButton available = new JRadioButton("Available");
     JRadioButton notAvailable = new JRadioButton("Not Available");
     JButton jbtSearch1 = new JButton("Search");
     JButton jbtDelete = new JButton("Delete");
    
     //for delete room
     JTextField jtfRoomId1 = new JTextField(20);
     JTextField jtfRoomPrice1 = new JTextField(20);
     JTextArea jtaRoomDescription1 = new JTextArea(5,20);
     String[] roomTypeList1 = {"","Deluxe Suite","Superior Suite","Georgetown Suite"};
     JComboBox jcboRoomType1 = new JComboBox(roomTypeList1);
     JRadioButton available1 = new JRadioButton("Available");
     JRadioButton notAvailable1 = new JRadioButton("Not Available");
     
      //for edit room
     JTextField jtfRoomId2 = new JTextField(20);
     JTextField jtfRoomPrice2 = new JTextField(20);
     JTextArea jtaRoomDescription2 = new JTextArea(5,20);
     String[] roomTypeList2 = {"","Deluxe Suite","Superior Suite","Georgetown Suite"};
     JComboBox jcboRoomType2 = new JComboBox(roomTypeList2);
     JRadioButton available2 = new JRadioButton("Available");
     JRadioButton notAvailable2 = new JRadioButton("Not Available");
     JButton jbtSearch2 = new JButton("Search");
     JButton jbtSave = new JButton("Save");     
     
     public static JComboBox jcboId = new JComboBox();
     public static JLabel jtfRoomType3 = new JLabel();
     public static JLabel jtfRoomPrice3 = new JLabel();
     public static JLabel jtfRoomStatus3 = new JLabel();
     public static JTextArea jtfRoomDescription3 = new JTextArea(5,20);
     
     
     String status;
     String roomType;
     private MaintainRoom roomControl;
     
    public RoomUI(){
        
        
    roomControl = new MaintainRoom();   
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon addIcon = new ImageIcon("Image/add.jpg");
    ImageIcon editIcon = new ImageIcon("Image/edit.png");
    ImageIcon deleteIcon = new ImageIcon("Image/remove.png");
    ImageIcon viewIcon = new ImageIcon("Image/view.png");
    
    addRoom(tabbedPane, addIcon, "Add Room", "Add Room");
    removeRoom(tabbedPane, deleteIcon, "Delete Room", "Delete Room");
    editRoom(tabbedPane, editIcon, "Edit Room", "Edit Room");
    viewRoom(tabbedPane, viewIcon, "View Room", "View Room");
    
    getContentPane().add(logoImage, BorderLayout.NORTH);
    add(tabbedPane, BorderLayout.CENTER);
    
    setTitle("Room");
    setSize(1000,600);
    setVisible(true);
    setResizable(false);
    }
    
  private void addRoom(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) { 
    
    JButton jbtAdd = new JButton("Add");
    JButton jbtCancel = new JButton("Cancel");
    JButton jbtReset = new JButton("Reset");
    
    JLabel jlbRoomId = new JLabel         ("Room ID           :        ");
    JLabel jlbRoomType = new JLabel       ("Room Type      :        ");
    JLabel jlbRoomPrice = new JLabel      ("Price                :        ");
    JLabel jlbRoomStatus = new JLabel     ("Status              :        ");
    JLabel jlbRoomDescription = new JLabel("Description     :        ");
    
    ButtonGroup statusButton = new ButtonGroup();
    JLabel jlbSpace = new JLabel("                                         ");
    
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpMid = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpStatus = new JPanel(new GridLayout(1,2,8,8));
    
   jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Room", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbRoomId);
           jpMid.add(jtfRoomId);
           jpTop.add(jlbRoomType);
           jpMid.add(jcboRoomType);
           jcboRoomType.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        roomType = (String)jcboRoomType.getSelectedItem();
                    }
                }
        );
           jpTop.add(jlbRoomPrice);
           jpMid.add(jtfRoomPrice);
           jpTop.add(jlbRoomStatus);
           statusButton.add(available);
           statusButton.add(notAvailable);
           jpStatus.add(available);
           jpStatus.add(notAvailable);
           available.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                status="AVAILABLE";
            }
	}});
           notAvailable.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                status="NON AVAILABLE";
            }
	}});
           
           jpMid.add(jpStatus);
           jpTop.add(jlbRoomDescription);
           jpMid.add(jtaRoomDescription);
         
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
             jtfRoomId.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfRoomId.getText();
            jtfRoomId.setText(st.toUpperCase());
             }
        });
    
    
      	jtfRoomId.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
        
        jtfRoomPrice.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || c == '.' ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
           
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
           
       jbtReset.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {    
            jtfRoomPrice.setText("");
            jtaRoomDescription.setText("");
		}});   
           jpButtonBtm.add(jbtAdd);
           jbtAdd.addActionListener(new AddListener());
           jpButtonBtm.add(jbtReset);
            jbtReset.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            jtfRoomId.setText("");
            jtfRoomPrice.setText(""); ;
            jtaRoomDescription.setText("") ;
        }}); 
           
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
    tabbedPane.addTab(text, icon, jpTitle, text1);
   
  }

   private void removeRoom(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
    
    
    JButton jbtCancel = new JButton("Cancel");
    
    JLabel jlbRoomId = new JLabel         ("Room ID           :        ");
    JLabel jlbRoomType = new JLabel       ("Room Type      :        ");
    JLabel jlbRoomPrice = new JLabel      ("Price                :        ");
    JLabel jlbRoomStatus = new JLabel     ("Status              :        ");
    JLabel jlbRoomDescription = new JLabel("Description     :        ");
    
    
    
    ButtonGroup statusButton = new ButtonGroup();
    JLabel jlbSpace = new JLabel("                                         ");
    
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpMid = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpStatus = new JPanel(new GridLayout(1,2,8,8));
    
    
    
   jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Room", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbRoomId);
           jpMid.add(jtfRoomId1);
           jpTop.add(jlbRoomType);
           jpMid.add(jcboRoomType1);
           jpTop.add(jlbRoomPrice);
           jpMid.add(jtfRoomPrice1);
           jpTop.add(jlbRoomStatus);
           statusButton.add(available1);
           statusButton.add(notAvailable1);
           jpStatus.add(available1);
           jpStatus.add(notAvailable1);
           jpMid.add(jpStatus);
           jpTop.add(jlbRoomDescription);
           jpMid.add(jtaRoomDescription1);
         
           
           jpBtm.add(jbtSearch1);
           jbtSearch1.addActionListener(new selectRecord());
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
             jtfRoomId1.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfRoomId1.getText();
            jtfRoomId1.setText(st.toUpperCase());
             }
        });
           
           jtfRoomId1.addKeyListener(new KeyAdapter() {
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
           
           jcboRoomType1.setEnabled(false);
           jtfRoomPrice1.setEditable(false);
           available1.setEnabled(false);
           notAvailable1.setEnabled(false);
           jtaRoomDescription1.setEditable(false);
           
           jbtDelete.setEnabled(false);
           jbtDelete.addActionListener(new DeleteListener());
           jpButtonBtm.add(jbtDelete);
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
    
    tabbedPane.addTab(text, icon, jpTitle, text1);
    
  }
  
   private void editRoom(JTabbedPane tabbedPane, ImageIcon icon, String text, String text1) {
    JButton jbtCancel = new JButton("Cancel");
    
    
    JLabel jlbRoomId = new JLabel         ("Room ID           :        ");
    JLabel jlbRoomType = new JLabel       ("Room Type      :        ");
    JLabel jlbRoomPrice = new JLabel      ("Price                :        ");
    JLabel jlbRoomStatus = new JLabel     ("Status              :        ");
    JLabel jlbRoomDescription = new JLabel("Description     :        ");
    
    
    ButtonGroup statusButton = new ButtonGroup();
    JLabel jlbSpace = new JLabel("                                         ");
    
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpMid = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(5,1,8,8));
    JPanel jpStatus = new JPanel(new GridLayout(1,2,8,8));
    
    
   jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Room", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
           jpTop.add(jlbRoomId);
           jpMid.add(jtfRoomId2);
           jpTop.add(jlbRoomType);
           jpMid.add(jcboRoomType2);
           jcboRoomType2.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        roomType = (String)jcboRoomType2.getSelectedItem();
                    }
                }
        );
           jpTop.add(jlbRoomPrice);
           jpMid.add(jtfRoomPrice2);
           jpTop.add(jlbRoomStatus);
           statusButton.add(available2);
           statusButton.add(notAvailable2);
           jpStatus.add(available2);
           jpStatus.add(notAvailable2);
           available2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                status="AVAILABLE";
            }
	}});
           notAvailable2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {{
                status="NON AVAILABLE";
            }
	}});
           jpMid.add(jpStatus);
           jpTop.add(jlbRoomDescription);
           jpMid.add(jtaRoomDescription2);
         
           
           jpBtm.add(jbtSearch2);
           jbtSearch2.addActionListener(new selectRecord1());
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           jpBtm.add(jlbSpace);
           
        jtfRoomId2.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
            String st=jtfRoomId2.getText();
            jtfRoomId2.setText(st.toUpperCase());
             }
        });
           
           jtfRoomId2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
        
        jtfRoomPrice2.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || c == '.' ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }
         }
       });
        
             
              
           
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
           
           jcboRoomType2.setEnabled(false);
           jtfRoomPrice2.setEditable(false);
           available2.setEnabled(false);
           notAvailable2.setEnabled(false);
           jtaRoomDescription2.setEditable(false);
           
           jbtSave.setEnabled(false);
           jpButtonBtm.add(jbtSave);
           jbtSave.addActionListener(new UpdateListener());
           jpButtonBtm.add(jbtCancel);
           jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
                      
           jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
    
    tabbedPane.addTab(text, icon, jpTitle, text1);
    
  }
   
    private void viewRoom(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
     JLabel jlbRoomId = new JLabel("Room ID:               ");
        JLabel jlbRoomType = new JLabel("Room Type:");
        JLabel jlbRoomPrice = new JLabel("Price:");
        JLabel jlbRoomStatus = new JLabel("Status:");
        JLabel jlbRoomDescription = new JLabel("Description:");
       JPanel jpButton = new JPanel();
       JButton jbtCancel = new JButton("Cancel");
        jlbRoomId.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbRoomType.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbRoomPrice.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbRoomStatus.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbRoomDescription.setFont(new Font("Arial", Font.PLAIN, 20));
        
         JLabel jlbSpace = new JLabel("                                                  ");         
         
        JPanel jpTitle = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new GridLayout(6,2,8,8));
        JPanel jpMid = new JPanel(new GridLayout(6,2,8,8));
        JPanel jpBtm = new JPanel(new GridLayout(6,2,8,8));
        jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Room", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
        jcboId.removeAllItems();
        roomControl.FillComboboxItem();
        
        jpTop.add(jlbRoomId);
        jpTop.add(jlbRoomType);
        jpTop.add(jlbRoomPrice);
        jpTop.add(jlbRoomStatus);
        jpTop.add(jlbRoomDescription);
               
         jpMid.add(jcboId);
         jpMid.add(jtfRoomType3);
         jpMid.add(jtfRoomPrice3);
         jpMid.add(jtfRoomStatus3);
         jpMid.add(jtfRoomDescription3); 
         jpButton.add(jbtCancel);
          jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
           
         jpMid.add(jpButton);
         jcboId.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfRoomType3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfRoomPrice3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfRoomStatus3.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfRoomDescription3.setBackground(Color.getColor("Panel.background"));
         jtfRoomDescription3.setFont(new Font("Arial", Font.PLAIN, 17));
         
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

                   roomControl.addRecordToField(String.valueOf(jcboId.getSelectedItem()));
            }});
            
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
    
    
    tabbedPane.addTab(text, icon, jpTitle, text1);
    
  }
   //check add data 
  public boolean checkAddData(){
     boolean	check = true;
        if(jtfRoomPrice.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Room Price.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtaRoomDescription.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Description for room.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
  
   //check id for delete 
  public boolean checkDeleteId(){
     boolean	check = true;
        if(jtfRoomId1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Room ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
  
   //check id for delete 
  public boolean checkEditId(){
     boolean	check = true;
        if(jtfRoomId2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Room ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
  //check edit data
    public boolean checkEditData(){
     boolean	check = true;
        if(jtfRoomPrice2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Room Price.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        else if(jtaRoomDescription2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Description for room.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
    
    
    private class AddListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        
         if (checkAddData()) {
		    boolean check = true;}
        
        String id = jtfRoomId.getText();
        
        Room r = roomControl.selectRecord(id);
        
        if(r != null){
            JOptionPane.showMessageDialog(null, "This room ID already exists","Duplicate Record",JOptionPane.ERROR_MESSAGE);
            
            
        }
        else{
            
            r = new Room(id,roomType,Double.parseDouble(jtfRoomPrice.getText()),status, jtaRoomDescription.getText());
            roomControl.addRecord(r);
            JOptionPane.showMessageDialog(null,"New room was added succesful");
            
        }
        
        dispose();
        new RoomUI();
        
    }
}
    
    private class selectRecord implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
             if (checkDeleteId()) {
                    
            String id = jtfRoomId1.getText();
            Room room = roomControl.selectRecord(id);
            if (room != null) {
                
                String roomType = room.getRoomType();
                if(roomType.equals("Deluxe Suite"))
                    jcboRoomType1.setSelectedItem(roomTypeList1[1]);
                else if(roomType.equals("Superior Suite"))
                    jcboRoomType1.setSelectedItem(roomTypeList1[2]);
                else if(roomType.equals("Georgetown Suite"))
                    jcboRoomType1.setSelectedItem(roomTypeList1[3]);   
                
                
                jtfRoomPrice1.setText(String.valueOf(room.getRoomPrice()));
                
                String status = room.getRoomStatus();
                if(status.equals("AVAILABLE"))
                    available1.setSelected(true);
                else 
                    notAvailable1.setSelected(true);                
                jtaRoomDescription1.setText(room.getRoomDescription());
               
                jbtDelete.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No such room ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        }
    }
    
    private class DeleteListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
        
        String id = jtfRoomId1.getText();
        
        Room r = roomControl.selectRecord(id);
        
        if(r != null){
            
            int option = JOptionPane.showConfirmDialog(null, "Are You Sure?");
            
            if(option == JOptionPane.YES_OPTION){
                roomControl.deleteRecord(id);
                JOptionPane.showMessageDialog(null, "Record Deleted.");
                clearText();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"No such employee ID","Record not found",JOptionPane.ERROR_MESSAGE);
            
        }
        
        dispose();
        new RoomUI();
        
    }
}
   
    private class selectRecord1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
             if (checkEditId()) {
             
            String id = jtfRoomId2.getText();
            Room room = roomControl.selectRecord(id);
            if (room != null) {
                
                String roomType = room.getRoomType();
                if(roomType.equals("Deluxe Suite"))
                    jcboRoomType2.setSelectedItem(roomTypeList2[1]);
                else if(roomType.equals("Superior Suite"))
                    jcboRoomType2.setSelectedItem(roomTypeList2[2]);
                else if(roomType.equals("Georgetown Suite"))
                    jcboRoomType2.setSelectedItem(roomTypeList2[3]);   
                
                
                jtfRoomPrice2.setText(String.valueOf(room.getRoomPrice()));
                
                String status = room.getRoomStatus();
                if(status.equals("AVAILABLE"))
                    available2.setSelected(true);
                else 
                    notAvailable2.setSelected(true);                
                jtaRoomDescription2.setText(room.getRoomDescription());
               
                jtfRoomId2.setEnabled(false);
                jcboRoomType2.setEnabled(true);
                jtfRoomPrice2.setEditable(true);
                available2.setEnabled(true);
                notAvailable2.setEnabled(true);
                jtaRoomDescription2.setEditable(true);
                
                jbtSave.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No such room ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
             }
        
        }
    }
    
    private class UpdateListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
   if (checkEditData()) {
            String updateId = jtfRoomId2.getText();
            
            Room r = new Room(updateId,roomType,Double.parseDouble(jtfRoomPrice2.getText()),status,jtaRoomDescription2.getText());
            
            roomControl.updateRecord(r);
            
            JOptionPane.showMessageDialog(null,"Record Updated.");
        }
      
        dispose();
        new RoomUI();
   }
}
    
     private void clearText(){
    jtfRoomId1.setText("");
    jtfRoomPrice1.setText("");
    jtaRoomDescription1.setText("");
    jcboRoomType1.setSelectedItem(roomTypeList1[0]);
}
}