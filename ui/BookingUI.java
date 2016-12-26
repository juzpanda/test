package ui;

import control.MaintainBooking;
import control.MaintainCustomer;
import control.MaintainRoom;
import domain.Booking;
import domain.Customer;
import domain.Room;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class BookingUI extends JFrame{
  
    private JLabel logoImage = new JLabel(new ImageIcon("Image/home.jpg"));
    private JLabel title = new JLabel ("Booking\n");
    
    JTextField jtfCustomerId = new JTextField(20);
    JTextField jtfCustomerName = new JTextField(20);
     
    JTextField jtfCustomerGender = new JTextField(20);
     
    JTextArea jtfCustomerAddress = new JTextArea(5, 20);
    JTextField jtfCustomerTelephoneNo = new JTextField(20);
    JTextField jtfCustomerPoint = new JTextField(20);
    
    String[] roomType = {"","Deluxe Suite","Superior Suite","Georgetown Suite"};
    JComboBox jcboRoomType = new JComboBox(roomType);
    String[] roomId = {} ;
    public static JComboBox jcboRoomId = new JComboBox();
    JTextField jtfRoomPrice = new JTextField(20);
    String[] days = {"","1","2","3","4","5","6","7","8","9","10"};
    JComboBox jcboDays = new JComboBox(days);
    final JTextField jtfCheckInDate = new JTextField();
    JTextField jtfCheckOutDate = new JTextField();
    JTextField jtfTotalPaid = new JTextField();
    JButton jbtReserve = new JButton("Reserve");
    String roomIdSelected;
    Date newSelectedDate = new Date();
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static Date today = new Date();
    Date checkOutDate = new Date();
    Calendar c = Calendar.getInstance();
    
    JTextField jtfCustomerId1 = new JTextField();
    public static JComboBox jcboRoomId1 = new JComboBox();
    public static JTextField jtfCheckInDate1 = new JTextField();
    public static JTextField jtfCheckOutDate1 = new JTextField();
    public static JTextField jtfTotalPrice1 = new JTextField();
    public static JTextField jtfStatus = new JTextField();
   
    public static JTextField jtfCustomerId2 = new JTextField();
    public static JComboBox jcboRoomId2 = new JComboBox();
    public static JComboBox jcboCheckInDate2 = new JComboBox();
    public static JTextField jtfCheckOutDate2 = new JTextField();
    public static JTextField jtfTotalPrice2 = new JTextField();
    public static JTextField jtfStatus2 = new JTextField();
    
    public static JTextField jtfTodayDate3 = new JTextField();
    public static JTextField jtfCheckOutDate3 = new JTextField();
    public static JComboBox jcboRoomId3 = new JComboBox();
    public static JTextField jtfCustomerId3 = new JTextField();
    public static JTextField jtfCustomerName3 = new JTextField();
    public static JTextField jtfCustomerTelephone3 = new JTextField();
    
    
    JButton jbtSearch = new JButton("Search");
    JButton jbtDelete = new JButton("Cancel Reservation");
    JButton jbtCheckOut = new JButton ("Check Out");
    
    int point;
    Room room = new Room();
    double price;
    double price1;
    double totalPrice;
    int numberOfDay;
    String custId;
    String roomTypeSelected;
    private MaintainCustomer custControl;
    private MaintainRoom roomControl;
    private MaintainBooking bookingControl;
    
    
    public BookingUI(){
       
       custControl = new MaintainCustomer(); 
       roomControl = new MaintainRoom();
       bookingControl = new MaintainBooking();
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon addIcon = new ImageIcon("Image/add.jpg");
    ImageIcon removeIcon = new ImageIcon("Image/remove.png");
    ImageIcon checkOutIcon = new ImageIcon("Image/logout.png");
    ImageIcon viewIcon = new ImageIcon("Image/view.png");
    
    
    
    JTabbedPane tabbedPane = new JTabbedPane();
    
    addBooking(tabbedPane, addIcon, "Room Reservation","Room Reservation");    
    deleteBooking(tabbedPane, removeIcon, "Delete Reservation", "Delete Reservation");
    viewBooking(tabbedPane, viewIcon, "View Reservation", "View Reservation");
    checkOut(tabbedPane, checkOutIcon, "Check Out", "Check Out");
    
    getContentPane().add(logoImage, BorderLayout.NORTH);
    add(tabbedPane, BorderLayout.CENTER);
  
    setTitle("Room Reservation");
    setSize(1000,600);
    setVisible(true);
    setResizable(false);
    }
    
    private void addBooking(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
    TitledBorder titledBorder = BorderFactory.createTitledBorder(null,null,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION);
     JLabel jlbCustomerId = new JLabel     ("Customer ID           :        ");
     JLabel jlbCustomerName = new JLabel   ("Name                       :        ");
     JLabel jlbCustomerGender = new JLabel ("Gender                    :        ");
     JLabel jlbCustomerAddress = new JLabel("Address                  :        ");
     JLabel jlbCustomerTel = new JLabel    ("Telephone No        :        ");
     JLabel jlbCustomerPoint = new JLabel  ("Cumulative Point  :");
     JLabel jlbSpace = new JLabel("                                         ");
     JButton jbtSearch = new JButton("Search");
    
     
    jtfCustomerAddress.setLineWrap(true);
    jtfCustomerAddress.setBackground(Color.getColor("Panel.background"));
   
    JPanel panel = new JPanel(new GridLayout(1,2));
    
    JPanel jpTitle = new JPanel(new BorderLayout());
    jpTitle.setBorder(new TitledBorder("Customer Information"));
   
    JPanel jpTop = new JPanel(new GridLayout(7,1,8,8));
    JPanel jpMid = new JPanel(new GridLayout(7,1,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(7,1,8,8));
    
    jpTop.add(jlbCustomerId);
    jpMid.add(jtfCustomerId);
    jpTop.add(jlbCustomerName);
    jpMid.add(jtfCustomerName);
    jpTop.add(jlbCustomerGender);
    jpMid.add(jtfCustomerGender);
    jpTop.add(jlbCustomerAddress);
    jpMid.add(jtfCustomerAddress);
    jpTop.add(jlbCustomerTel);
    jpMid.add(jtfCustomerTelephoneNo);
    jpTop.add(jlbCustomerPoint);
    jpMid.add(jtfCustomerPoint);   
     
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
        
    jpBtm.add(jbtSearch);
    jbtSearch.addActionListener(new selectRecord());
    jpBtm.add(jlbSpace);
    jpBtm.add(jlbSpace);
    jpBtm.add(jlbSpace);
    jpBtm.add(jlbSpace);
    jpBtm.add(jlbSpace);
    jpBtm.add(jlbSpace); 

   jtfCustomerName.setEditable(false);
   jtfCustomerGender.setEditable(false);
   jtfCustomerAddress.setEditable(false);
   jtfCustomerTelephoneNo.setEditable(false);
   jtfCustomerPoint.setEditable(false);
   jpTitle.add(jpTop,BorderLayout.WEST);
   jpTitle.add(jpMid,BorderLayout.CENTER);
   jpTitle.add(jpBtm,BorderLayout.EAST);
           
    JPanel jpTitle1 = new JPanel(new BorderLayout());
    jpTitle1.setBorder(new TitledBorder("Room Reservation"));
    
    JPanel jpTop1 = new JPanel(new GridLayout(7,1,8,8));
    JPanel jpMid1 = new JPanel(new GridLayout(7,1,8,8));
    JPanel jpBtm1 = new JPanel(new GridLayout(7,1,8,8));
    JPanel jpRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel jlbRoomType = new JLabel       ("Room Type      :        ");
    JLabel jlbRoomId = new JLabel         ("Room ID           :        ");
    JLabel jlbTotalPrice = new JLabel      ("Total Price      :        ");
    JLabel jlbDays = new JLabel           ("Days                 :");
    JLabel jlbCheckInDate = new JLabel    ("Check In Date :       ");
    JLabel jlbCheckOutDate = new JLabel   ("Check Out Date :");
    JLabel jlbTotalPaid = new JLabel       ("Total Paid      :");
    ButtonGroup buttonGroup = new ButtonGroup();
    JLabel jlbSpace1 = new JLabel("");
    ImageIcon calenderIcon = new ImageIcon("Image/calander.png");
    JButton jbtCalender = new JButton(calenderIcon);
    
     
    jpTop1.add(jlbCheckInDate);
    jpMid1.add(jtfCheckInDate);
    jpBtm1.add(jbtCalender);
    jbtCalender.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            JFrame f = null;
            String selectedDate = new DatePicker(f).setPickedDate();
            c.setTime(today);
            c.add(Calendar.DATE, -1);
            Date newDate = c.getTime();
            try{
             newSelectedDate = simpleDateFormat.parse(selectedDate);
             
             simpleDateFormat.format(newDate);
                if( newDate.before(newSelectedDate) || newDate.equals(newSelectedDate)){
                    jtfCheckInDate.setText(selectedDate); 
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please choose date after today.","Date Error",JOptionPane.ERROR_MESSAGE);
                    jtfCheckInDate.setText("");
                }
                }
            catch (ParseException e) {
		e.printStackTrace();
	}
        } 
        }); 
    jpTop1.add(jlbDays);
    jpMid1.add(jcboDays);
    jcboDays.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        String numberOfDayString = (String) jcboDays.getSelectedItem();
                        numberOfDay = Integer.parseInt(numberOfDayString);
                        c.setTime(newSelectedDate);
                        c.add(Calendar.DATE, numberOfDay);
                        checkOutDate = c.getTime();
                        String checkOutDateString = simpleDateFormat.format(checkOutDate);
                        jtfCheckOutDate.setText(checkOutDateString);
                    }
                }
        );
    jpTop1.add(jlbCheckOutDate);
    jpMid1.add(jtfCheckOutDate);
    
    jtfCheckOutDate.setEditable(false);
    jpTop1.add(jlbRoomType);
    jpMid1.add(jcboRoomType);
    jcboRoomType.addActionListener(new selectRecordForReserve());
    jpTop1.add(jlbRoomId);
    jpMid1.add(jcboRoomId);
    jcboRoomId.addItemListener(
        new ItemListener(){
            public void itemStateChanged(ItemEvent event){
                point = Integer.parseInt(jtfCustomerPoint.getText());
                if(point >= 10){
                roomIdSelected= String.valueOf(jcboRoomId.getSelectedItem());
                Room room = roomControl.selectRecord(roomIdSelected);
                if(room!=null){
                price = room.getRoomPrice() ;
                price1 = room.getRoomPrice();
                double numberOfDayDouble =(double) numberOfDay;
                totalPrice = price * numberOfDayDouble - price1;
                String totalPriceString = String.valueOf(totalPrice);
                jtfRoomPrice.setText(totalPriceString);
                }}
                else{
                roomIdSelected= String.valueOf(jcboRoomId.getSelectedItem());
                Room room1 = roomControl.selectRecord(roomIdSelected);
                if(room1!=null){
                price = room1.getRoomPrice() ;
                double numberOfDayDouble =(double) numberOfDay;
                totalPrice = price * numberOfDayDouble;
                String totalPriceString = String.valueOf(totalPrice);
                jtfRoomPrice.setText(totalPriceString);
                }
                
    }}});
    jpTop1.add(jlbTotalPrice);
    jpMid1.add(jtfRoomPrice);
    jtfRoomPrice.setEditable(false);
    
   jpTitle1.add(jpTop1,BorderLayout.WEST);
   jpTitle1.add(jpMid1,BorderLayout.CENTER);
   jpTitle1.add(jpBtm1,BorderLayout.EAST);
    
    panel.add(jpTitle, BorderLayout.CENTER);
    panel.add(jpTitle1, BorderLayout.EAST);
     JButton jbtCancel = new JButton("Cancel");
    JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    jpButton.add(jbtReserve);
    jpButton.add(jbtCancel);
    jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
    jbtReserve.addActionListener(new AddListener());
    jpTitle1.add(jpButton, BorderLayout.SOUTH);
    
    panel.setBorder(titledBorder);
 
     tabbedPane.addTab(text, icon, panel, text1);
   
  }
    
    private void deleteBooking(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1){
   JLabel customerId = new JLabel   ("Customer ID    :              ");
    JLabel roomId = new JLabel       ("Room ID        :              ");
    JLabel checkInDate = new JLabel  ("Check in Date  :              ");
    JLabel checkOutDate = new JLabel ("Check out Date :              ");
    JLabel totalPrice = new JLabel   ("Total Price    :              ");
    JLabel status = new JLabel       ("Status         :              ");
   
    JLabel space = new JLabel("                                              ");
    
    JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(7,2,8,8));
    JPanel jpMid = new JPanel(new GridLayout(7,2,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(7,2,8,8));
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
     jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Reservation", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
          
    
    jpTop.add(customerId);
    jpTop.add(roomId);
    jpTop.add(checkInDate);
    jpTop.add(checkOutDate);
    jpTop.add(totalPrice);
    jpTop.add(status);
    
    
    jpMid.add(jtfCustomerId1);
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
    jpMid.add(jcboRoomId1);
    jpMid.add(jtfCheckInDate1);
    jpMid.add(jtfCheckOutDate1);
    jpMid.add(jtfTotalPrice1);
    jpMid.add(jtfStatus);
    jcboRoomId1.setEnabled(false);
    jtfCheckInDate1.setEditable(false);
    jtfCheckOutDate1.setEditable(false);
    jtfTotalPrice1.setEditable(false);
    jtfStatus.setEditable(false);
    jpBtm.add(jbtSearch);
    jcboRoomId1.removeAllItems();
    jbtSearch.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                   if (checkDeleteId()) {
                   bookingControl.FillComboboxItem(jtfCustomerId1.getText());
                   jcboRoomId1.setEnabled(true);
            }}});
            
    jcboRoomId1.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                   bookingControl.addRecordToField(String.valueOf(jcboRoomId1.getSelectedItem()));
                   jbtDelete.setEnabled(true);
            }});        
    
    jpBtm.add(space);
    
    jbtDelete.setEnabled(false);
    jbtDelete.addActionListener(new updateStatus());
    jpButtonBtm.add(jbtDelete);
     JButton jbtCancel = new JButton("Cancel");
    jpButtonBtm.add(jbtCancel);
    jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
    
   jpTitle.add(jpTop,BorderLayout.WEST);
   jpTitle.add(jpMid,BorderLayout.CENTER);
   jpTitle.add(jpBtm,BorderLayout.EAST);

   jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
 
    tabbedPane.addTab(text, icon, jpTitle, text1);
    }
    
    private void viewBooking(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1){
   JLabel customerId = new JLabel   ("Customer ID    :              ");
    JLabel roomId = new JLabel       ("Room ID        :              ");
    JLabel checkInDate = new JLabel  ("Check in Date  :              ");
    JLabel checkOutDate = new JLabel ("Check out Date :              ");
    JLabel totalPrice = new JLabel   ("Total Price    :              ");
    JLabel status = new JLabel       ("Status         :              ");
   
    JLabel space = new JLabel("                                              ");
    JButton jbtSearch2 = new JButton("Search");
    
     JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(7,2,8,8));
    JPanel jpMid = new JPanel(new GridLayout(7,2,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(7,2,8,8));
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Reservation", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
    
    jpTop.add(customerId);
    jpTop.add(roomId);
    jpTop.add(checkInDate);
    jpTop.add(checkOutDate);
    jpTop.add(totalPrice);
    jpTop.add(status);
    
    jpMid.add(jtfCustomerId2);
    jpMid.add(jcboRoomId2);
    jpMid.add(jcboCheckInDate2);
    jpMid.add(jtfCheckOutDate2);
    jpMid.add(jtfTotalPrice2);
    jpMid.add(jtfStatus2);    
    
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
       
    jbtSearch2.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                  checkViewId();
                  jcboRoomId2.removeAllItems();
                  bookingControl.FillComboboxRoomId(jtfCustomerId2.getText());
                  jcboRoomId2.setEnabled(true);
                  
           }});
    
        jcboRoomId2.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                  bookingControl.FillComboboxCheckInDate(String.valueOf(jcboRoomId2.getSelectedItem()),String.valueOf(jtfCustomerId2.getText()));
                  jcboCheckInDate2.setEnabled(true);
         }});
        
         jcboCheckInDate2.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                clearText1();
                String checkInDate1 = String.valueOf(jcboCheckInDate2.getSelectedItem());
                bookingControl.addViewRecord(String.valueOf(jcboRoomId2.getSelectedItem()),checkInDate1);
         }});
       
    jcboRoomId2.setEnabled(false);
    jcboCheckInDate2.setEnabled(false);
    jtfCheckOutDate2.setEditable(false);
    jtfTotalPrice2.setEditable(false);
    jtfStatus2.setEditable(false);
     jpBtm.add(jbtSearch2);  
    jpBtm.add(space);  
    jpTitle.add(jpTop,BorderLayout.WEST);
    jpTitle.add(jpMid,BorderLayout.CENTER);
    jpTitle.add(jpBtm,BorderLayout.EAST);
JButton jbtCancel = new JButton("Cancel");
    jpButtonBtm.add(jbtCancel);
    jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
   jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
 
    
   tabbedPane.addTab(text, icon, jpTitle, text1);
    }
            
    public void checkOut(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1){
    
    JLabel todayDate = new JLabel ("Today Date                          :");
    JLabel checkOutDate = new JLabel ("Check Out Date                 :");
    JLabel roomId = new JLabel("Room ID                              :");
    JLabel customerId = new JLabel ("Customer ID                      :");
    JLabel customerName = new JLabel ("Customer Name               :");
    JLabel customerTelephone = new JLabel ("Customer Telephone      :             " );
    
    JLabel space1 = new JLabel ("                                   ");
    JLabel space2 = new JLabel ("                 ");
    JLabel space3 = new JLabel ("                 ");
    
    JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(7,3,8,8));
    JPanel jpMid = new JPanel(new GridLayout(7,3,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(7,3,8,8));
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    jpTop.add(todayDate);
    jpTop.add(checkOutDate);
    jpTop.add(roomId);
    jpTop.add(customerId);
    jpTop.add(customerName);
    jpTop.add(customerTelephone);
    
    jpMid.add(jtfTodayDate3);
    jpMid.add(jtfCheckOutDate3);
    jpMid.add(jcboRoomId3);
    jcboRoomId3.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                    bookingControl.addCheckOutRecord(String.valueOf(jcboRoomId3.getSelectedItem()));
                    Customer customer = custControl.selectRecord(jtfCustomerId3.getText());
                    if (customer != null) {
                    jtfCustomerName3.setText(customer.getCustomerName());
                    jtfCustomerTelephone3.setText(customer.getCustomerTelephoneNo());
                    jbtCheckOut.setEnabled(true);
                    }
            }});
    jpMid.add(jtfCustomerId3);
    jpMid.add(jtfCustomerName3);
    jpMid.add(jtfCustomerTelephone3);
    
    String dateString = simpleDateFormat.format(today);
    bookingControl.FillRoomId(today);
    jtfTodayDate3.setText(dateString);
    jtfCheckOutDate3.setText(dateString);
    jtfTodayDate3.setEditable(false);
    jtfCheckOutDate3.setEditable(false);
    jtfCustomerId3.setEditable(false);
    jtfCustomerName3.setEditable(false);
    jtfCustomerTelephone3.setEditable(false);
            
    jpBtm.add(space1);
    
    jpTitle.add(jpTop,BorderLayout.WEST);
   jpTitle.add(jpMid,BorderLayout.CENTER);
   jpTitle.add(jpBtm,BorderLayout.EAST);
   
    jpButtonBtm.add(jbtCheckOut);
    jbtCheckOut.addActionListener(new ActionListener () {
        public void actionPerformed(ActionEvent e) {
            Room r = roomControl.selectRecord(String.valueOf(jcboRoomId3.getSelectedItem()));
            r.setRoomStatus("AVAILABLE");
            roomControl.updateRecord(r);
            JOptionPane.showMessageDialog(null, "Checked Out.");
            jcboRoomId3.removeAllItems();
            clearText2();
            dispose();
            new BookingUI();
    }});
    JButton jbtCancel = new JButton("Cancel");
    jpButtonBtm.add(jbtCancel);
    jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
    jbtCheckOut.setEnabled(false);
    jpTitle.add(jpButtonBtm,BorderLayout.SOUTH);
   tabbedPane.addTab(text, icon, jpTitle, text1);
    }
    
     public boolean checkId(){
     boolean	check = true;
        if(jtfCustomerId.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
     
    private class selectRecord implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        //for checking if there is a missing information
		  if (checkId()) {
            String id = jtfCustomerId.getText();
            Customer customer = custControl.selectRecord(id);
            if (customer != null) {
                jtfCustomerName.setText(customer.getCustomerName());
                jtfCustomerAddress.setText(customer.getCustomerAddress());
                jtfCustomerGender.setText( customer.getCustomerGender());
                jtfCustomerTelephoneNo.setText(customer.getCustomerTelephoneNo());
                jtfCustomerPoint.setText(String.valueOf(customer.getCustomerPoint()));
            } else {
                JOptionPane.showMessageDialog(null, "No such customer ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }}
    
     private class selectRecordForReserve implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             
            roomTypeSelected = (String) jcboRoomType.getSelectedItem();
            Room room = roomControl.selectRecordForReserve(roomTypeSelected);
            if (room != null) {
                jcboRoomId.removeAllItems();
                roomControl.selectRecordForReserve(roomTypeSelected);
                
            } 
    }}
     
    private class AddListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
            Booking b = null;
        try {
            b = new Booking(jtfCustomerId.getText(),roomIdSelected,today,simpleDateFormat.parse(jtfCheckInDate.getText()),simpleDateFormat.parse(jtfCheckOutDate.getText()),Double.parseDouble(jtfRoomPrice.getText()),"PENDING");
        } catch (ParseException ex) {
            Logger.getLogger(BookingUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            bookingControl.addRecord(b);
            JOptionPane.showMessageDialog(null,"New reservation was added succesful");
            clearText();
            dispose();
            new BookingUI();
        }        
    }

    public boolean checkDeleteId(){
     boolean	check = true;
        if(jtfCustomerId1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
    
     public boolean checkViewId(){
     boolean	check = true;
        if(jtfCustomerId2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
     
    private class updateStatus implements ActionListener{
    public void actionPerformed(ActionEvent e){
         int option = JOptionPane.showConfirmDialog(null, "Are You Sure?");
            
            if(option == JOptionPane.YES_OPTION){
        try {
            Booking b = new Booking (jtfCustomerId1.getText(), String.valueOf(jcboRoomId1.getSelectedItem()), today, simpleDateFormat.parse(jtfCheckInDate1.getText()),simpleDateFormat.parse(jtfCheckOutDate1.getText()),Double.parseDouble(jtfTotalPrice1.getText()), "CANCELLED" );
            bookingControl.updateRecord(b);
        } catch (ParseException ex) {
            Logger.getLogger(BookingUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Reservation cancelled.");
            clearText();
            dispose();
            new BookingUI();
            }
    }}
    
    private void clearText(){
    jtfCheckOutDate1.setText("");
    jtfCheckInDate1.setText("");
    jtfTotalPrice1.setText("");
    jtfStatus.setText("");
    }
     private void clearText1(){
    jtfCheckOutDate2.setText("");
    jtfTotalPrice2.setText("");
    jtfStatus2.setText("");
    }
     private void clearText2(){
     jtfCustomerId3.setText("");
     jtfCustomerName3.setText("");
     jtfCustomerTelephone3.setText("");
     }
    
    
}
