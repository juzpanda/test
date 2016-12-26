
package ui;

import control.MaintainBooking;
import control.MaintainCustomer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import control.MaintainPayment;
import control.MaintainRoom;
import domain.Booking;
import domain.Customer;
import domain.Payment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PaymentUI extends JFrame{
    private JPanel button = new JPanel(new GridLayout(1,1));
    private JPanel top = new JPanel (new GridLayout(1,2));
    private JLabel logoImage = new JLabel(new ImageIcon("Image/home.jpg"));
    private JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
      
      JTextField jtfPaymentId = new JTextField(20);
    public static JTextField jtfTotalAmount = new JTextField(20);
      JTextField jtfPaymentDate = new JTextField(80);
      JTextField jtfPaymentStatus = new JTextField(20);
      JTextField jtfCustomerId = new JTextField(80);
     public static JComboBox jcboRoomId = new JComboBox();
     public static JComboBox jcboCheckInDate = new JComboBox();
     JTextField jtfChange = new JTextField("0");
      JTextField jtfTotalPaid = new JTextField(20);
      JRadioButton cash = new JRadioButton("Cash");
      JRadioButton creditCard = new JRadioButton("Credit Card");
      
      public static JComboBox jcboId = new JComboBox();
      public static JLabel jtfPaymentType1= new JLabel();
      public static JLabel jtfTotalAmount1 = new JLabel();
      public static JLabel jtfPaymentDate1 = new JLabel();
      public static JLabel jtfPaymentStatus1 = new JLabel();
      public static JLabel jtfCustomerId1 = new JLabel();
      public static JLabel jtfRoomId1 = new JLabel();
      public static JLabel jtfTotalPaid1 = new JLabel();
      JRadioButton cash1 = new JRadioButton("Cash");
      JRadioButton creditCard1 = new JRadioButton("Credit Card");
      
      Booking b = new Booking();
      String id;
      int point;
      Date today = new Date();
      String paymentType;
      public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      
      private MaintainRoom roomControl;
      private MaintainPayment paymentControl;
      private MaintainBooking bookingControl;
      private MaintainCustomer custControl;
    public PaymentUI() {
        
        paymentControl = new MaintainPayment();
        roomControl = new MaintainRoom();     
        bookingControl = new MaintainBooking();
        custControl = new MaintainCustomer();
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon paymentIcon = new ImageIcon("Image/payment.gif");    
    ImageIcon viewPaymentIcon = new ImageIcon("Image/viewpayment.jpg");    
    
    payment(tabbedPane, paymentIcon, "Payment", "Payment");
    viewPayment(tabbedPane, viewPaymentIcon, "View Payment", "View Payment");
    
    getContentPane().add(logoImage, BorderLayout.NORTH);
    
    add(tabbedPane, BorderLayout.CENTER);
 
    setTitle("Payment");
    setSize(1000,650);
    setVisible(true);
    setResizable(false);
    }
     
     private void payment(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
           
     JLabel jlbPaymentId = new JLabel     ("Payment ID:        ");
     JLabel jlbTotalAmount = new JLabel ("Total Amount:        ");
     JLabel jlbPaymentDate = new JLabel("Payment Date:        ");
     JLabel jlbPaymentStatus = new JLabel    ("Payment Status         ");
     JLabel jlbCustomerId = new JLabel("Customer ID:                ");
     JLabel jlbRoomId = new JLabel("Room ID:                    ");
     JLabel jlbPaymentType = new JLabel   ("Payment Type :        ");
     JLabel jlbTotalPaid = new JLabel("Total Paid :                            ");
     JLabel jlbSpace = new JLabel("                                                           ");
     JLabel jlbCheckInDate = new JLabel("Check In Date :          ");
     JLabel jlbChange = new JLabel ("CHANGE :  ");
     JButton jbtSearch = new JButton("Search");
     final JButton jbtPay = new JButton("Pay");
     JButton jbtCancel = new JButton("Cancel");
     
     ButtonGroup paymentTypeGroup = new ButtonGroup();
     
    JPanel jpButtonBtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel jpTitle = new JPanel(new BorderLayout());
    JPanel jpTop = new JPanel(new GridLayout(9,1,8,8));
    JPanel jpMid = new JPanel(new GridLayout(9,1,8,8));
    JPanel jpBtm = new JPanel(new GridLayout(9,1,8,8));
    JPanel jpPaymentTypeGroup = new JPanel(new GridLayout(1,2,8,8));
    
    jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Payment", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
      
    jpTop.add(jlbPaymentId);
    jpTop.add(jlbCustomerId);
    jpTop.add(jlbRoomId);
    jpTop.add(jlbCheckInDate);
    jpTop.add(jlbPaymentDate);
    jpTop.add(jlbTotalAmount);
    jpTop.add(jlbPaymentType);
    jpTop.add(jlbTotalPaid);
    jpTop.add(jlbChange).setFont(new Font("Arial", Font.PLAIN, 20));
    
    RetrieveListener();
    
    jpMid.add(jtfPaymentId);
    jpMid.add(jtfCustomerId);
    jpMid.add(jcboRoomId);
    jcboRoomId.setEnabled(false);
    jpMid.add(jcboCheckInDate);
    jcboCheckInDate.setEnabled(false);
    jpMid.add(jtfPaymentDate);
    jpMid.add(jtfTotalAmount);
    
    paymentTypeGroup.add(cash);
    paymentTypeGroup.add(creditCard);
    jpPaymentTypeGroup.add(cash);
    jpPaymentTypeGroup.add(creditCard);
    cash.setSelected(true);
    jtfTotalAmount.setEditable(false);
    jtfPaymentDate.setEditable(false);
    jtfPaymentDate.setText(simpleDateFormat.format(today));
    jtfPaymentId.setEditable(false);
   
    cash.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
            jtfTotalPaid.setEditable(true);
            jtfChange.setEditable(false);
            jtfTotalPaid.addActionListener(new calculateChange());
            paymentType = "CASH";
	}});    
    
    creditCard.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
            jtfTotalPaid.setEditable(false);
            jtfChange.setEditable(false);
            paymentType = "CREDIT CARD";
	}});    
    
     jbtPay.addActionListener(new addPayment());
    jpMid.add(jpPaymentTypeGroup);
    jpMid.add(jtfTotalPaid);
    jpMid.add(jtfChange).setFont(new Font("Arial", Font.PLAIN, 15));
    
      jpBtm.add(jlbSpace);
      jpBtm.add(jbtSearch);
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
        
         jtfTotalPaid.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isDigit(c) || c == '.' ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
                e.consume();
              }           
         }
       });
         
      jbtSearch.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                  checkViewId();
                  jcboRoomId.removeAllItems();
                  bookingControl.FillPaymentComboboxRoomId(jtfCustomerId.getText());
                  jcboRoomId.setEnabled(true);
                  
           }});  
      
         jcboRoomId.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                  bookingControl.FillPaymentComboboxCheckInDate(String.valueOf(jcboRoomId.getSelectedItem()),String.valueOf(jtfCustomerId.getText()));
                  jcboCheckInDate.setEnabled(true);
         }});
         
         jcboCheckInDate.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                clearText();
                String checkInDate1 = String.valueOf(jcboCheckInDate.getSelectedItem());
                bookingControl.viewRecordForPayment(String.valueOf(jcboRoomId.getSelectedItem()),checkInDate1);
         }});
         
         
         
         
      
      jpButtonBtm.add(jbtPay);
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
     
     
     
     private void viewPayment(JTabbedPane tabbedPane,ImageIcon icon, String text, String text1) {
      JLabel jlbPaymentId = new JLabel     ("Payment ID:        ");
     JLabel jlbTotalAmount = new JLabel ("Total Amount:        ");
     JLabel jlbPaymentDate = new JLabel("Payment Date:        ");
     JLabel jlbPaymentStatus = new JLabel    ("Payment Status:        ");
     JLabel jlbCustomerId = new JLabel("Customer ID: ");
     JLabel jlbRoomId = new JLabel("Room ID:                    ");
     JLabel jlbPaymentType = new JLabel   ("Payment Type:        ");
     JLabel jlbTotalPaid = new JLabel("Total Paid:                            ");
     JLabel jlbSpace = new JLabel("                                   ");
     JButton jbtCancel = new JButton("Cancel");
     JPanel jpButton = new JPanel();
     ButtonGroup paymentTypeGroup = new ButtonGroup();

        jlbPaymentId.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbTotalAmount.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbPaymentDate.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbPaymentStatus.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbCustomerId.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbRoomId.setFont(new Font("Arial", Font.PLAIN, 20));
        jlbPaymentType.setFont(new Font("Arial", Font.PLAIN, 20));
          
        JPanel jpTitle = new JPanel(new BorderLayout());
        JPanel jpTop = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpMid = new JPanel(new GridLayout(8,2,8,8));
        JPanel jpBtm = new JPanel(new GridLayout(8,2,8,8));
        jpTitle.setBorder(BorderFactory.createTitledBorder(null, "Payment", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial",Font.BOLD,20), Color.BLUE));
       
         jcboId.removeAllItems();
        paymentControl.FillComboboxItem();
        
         jpTop.add(jlbPaymentId);
         jpTop.add(jlbTotalAmount);
         jpTop.add(jlbPaymentDate);
         jpTop.add(jlbPaymentStatus);
         jpTop.add(jlbCustomerId);
         jpTop.add(jlbRoomId);
         jpTop.add(jlbPaymentType);
         jpMid.add(jcboId);
         jpMid.add(jtfTotalAmount1);
         jpMid.add(jtfPaymentDate1);
         jpMid.add(jtfPaymentStatus1); 
         jpMid.add(jtfCustomerId1); 
         jpMid.add(jtfRoomId1); 
         jpMid.add(jtfPaymentType1); 
         jpButton.add(jbtCancel);
         jpMid.add(jpButton);
         jbtCancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
         jcboId.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfTotalAmount1.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfPaymentDate1.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfPaymentStatus1.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfCustomerId1.setFont(new Font("Arial", Font.PLAIN, 20));
         jtfRoomId1.setFont(new Font("Arial", Font.PLAIN, 20));
         
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
                   paymentControl.addRecordToField(String.valueOf(jcboId.getSelectedItem()));
            }});
         
           jpTitle.add(jpTop,BorderLayout.WEST);
           jpTitle.add(jpMid,BorderLayout.CENTER);
           jpTitle.add(jpBtm,BorderLayout.EAST);
    
    
   tabbedPane.addTab(text, icon, jpTitle, text1);
    
  }
    
    private void RetrieveListener(){
        Payment p = paymentControl.selectAllRecord();
        id = p.getPaymentId();
        int countId = id.length();
        String idFront = id.substring(0,1);
        String idBack = id.substring(1,countId);
        int idBack1 = Integer.parseInt(idBack);
        int idBack2 = idBack1+1;
        Integer.toString(idBack2);
        id = idFront + idBack2;
        if(p != null){
            jtfPaymentId.setText(id);
        }
    }
    
     public boolean checkViewId(){
     boolean	check = true;
        if(jtfCustomerId.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Customer ID.","Empty Field",JOptionPane.ERROR_MESSAGE);
            check = false;
        }
    	return check;
    }
     
     public boolean checkTotalPaid(){
         boolean check = true;
         if(jtfTotalPaid.getText().equals("")){
             JOptionPane.showMessageDialog(null,"Please Enter Total Paid Amount.","Empty Field",JOptionPane.ERROR_MESSAGE);
             check = false;
         }
         return check;
     }
     
     private void clearText(){
         jtfTotalAmount.setText("");
         jtfTotalPaid.setText("");
     }
     
    private class addPayment implements ActionListener{
    public void actionPerformed(ActionEvent a){
     if (checkViewId()) {
          Payment p = new Payment(id,paymentType,Double.parseDouble(jtfTotalAmount.getText()),today,"PAID",jtfCustomerId.getText(),String.valueOf(jcboRoomId.getSelectedItem()));
            paymentControl.addRecord(p);
            
            Booking b = bookingControl.viewRecordForUpdate(jtfCustomerId.getText(),String.valueOf(jcboRoomId.getSelectedItem()),String.valueOf(jcboCheckInDate.getSelectedItem()) );
            b.setReserveStatus("RESERVED");
         try {
             Date checkInDate = simpleDateFormat.parse(String.valueOf((jcboCheckInDate.getSelectedItem())));
         } catch (ParseException ex) {
             Logger.getLogger(PaymentUI.class.getName()).log(Level.SEVERE, null, ex);
         }
            String id = jtfCustomerId.getText();
            Customer c =custControl.selectRecord(id);
            point = c.getCustomerPoint();
            if(point>=10){
                point = point - 10 + 1;
            }
            else{
                point = point + 1;
            }
            custControl.updatePoint(id,point);
            bookingControl.updateRecord(b);
            JOptionPane.showMessageDialog(null,"New payment has added");
            dispose();
          new PaymentUI();
    }
    }
}
 
private class calculateChange implements ActionListener{
    public void actionPerformed(ActionEvent a){
        Double totalPrice = Double.parseDouble(jtfTotalAmount.getText());
        Double totalPaid = Double.parseDouble(jtfTotalPaid.getText());
        Double change = totalPaid - totalPrice;
        if(change>=0)
            jtfChange.setText(String.valueOf(change));      
        else 
            JOptionPane.showMessageDialog(null,"The total paid must be more than total amount.","",JOptionPane.ERROR_MESSAGE);
    }
}
}
