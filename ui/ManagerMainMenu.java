package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import static ui.StaffMainMenu.simpleDateFormat;
import control.MaintainBooking;
import static ui.StaffMainMenu.simpleDateFormat;

public class ManagerMainMenu extends JFrame{
        private JLabel logoImage = new JLabel(new ImageIcon("Image/home.jpg"));
          Date today = new Date();
          private MaintainBooking bookingControl; 
    public ManagerMainMenu() {
         bookingControl = new MaintainBooking();
        JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel jpButton2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        ImageIcon reserveIcon = new ImageIcon("Image/reserve.png");
        ImageIcon staffIcon = new ImageIcon("Image/staff.jpg");
        ImageIcon customerIcon = new ImageIcon("Image/customer.png");
        ImageIcon roomIcon = new ImageIcon("Image/room.jpeg");
        ImageIcon reportIcon = new ImageIcon("Image/report.png");
        ImageIcon logoutIcon = new ImageIcon("Image/logout.png");
        ImageIcon PaymentIcon = new ImageIcon("Image/payment2.png");
            
        JButton jbtReserve = new JButton("Reserve Room",reserveIcon);
        jbtReserve.setHorizontalTextPosition(AbstractButton.CENTER);
        jbtReserve.setVerticalTextPosition(AbstractButton.BOTTOM);
        
         updateRoomStatus(today);
        
        JButton jbtStaff = new JButton("Staff Maintainance",staffIcon);
        jbtStaff.setHorizontalTextPosition(AbstractButton.CENTER);
        jbtStaff.setVerticalTextPosition(AbstractButton.BOTTOM);
        JButton jbtCustomer = new JButton("Customer Maintainance",customerIcon);
        jbtCustomer.setHorizontalTextPosition(AbstractButton.CENTER);
        jbtCustomer.setVerticalTextPosition(AbstractButton.BOTTOM);
        JButton jbtRoom = new JButton("Room Maintainance",roomIcon);
        jbtRoom.setHorizontalTextPosition(AbstractButton.CENTER);
        jbtRoom.setVerticalTextPosition(AbstractButton.BOTTOM);
        JButton jbtReport = new JButton("Report",reportIcon);
        jbtReport.setHorizontalTextPosition(AbstractButton.CENTER);
        jbtReport.setVerticalTextPosition(AbstractButton.BOTTOM);
        JButton jbtPayment = new JButton("Payment",PaymentIcon);
        jbtPayment.setHorizontalTextPosition(AbstractButton.CENTER);
        jbtPayment.setVerticalTextPosition(AbstractButton.BOTTOM);
        JButton jbtSignout = new JButton("Signout",logoutIcon);
        
        jpButton.add(jbtReserve);
        jpButton.add(jbtStaff);
        jpButton.add(jbtCustomer);
        jpButton.add(jbtRoom);
        jpButton.add(jbtReport);
        jpButton.add(jbtPayment);
        
        jpButton2.add(jbtSignout);
        jbtSignout.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
            new Login();
        }}); 
      
        getContentPane().add(logoImage, BorderLayout.NORTH);
        this.add(jpButton,BorderLayout.CENTER);
        this.add(jpButton2,BorderLayout.SOUTH);
        
        jbtReserve.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            BookingUI b = new BookingUI();
        } 
        }); 
        
        jbtStaff.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            EmployeeUI emp = new EmployeeUI();
        } 
        }); 
        
        jbtCustomer.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            CustomerUI cust = new CustomerUI();
        } 
        }); 
        
        jbtRoom.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            RoomUI room = new RoomUI();
        } 
        }); 
        jbtPayment.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            PaymentUI payment = new PaymentUI();
        } 
        }); 
         jbtReport.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            ReportUI report = new ReportUI();
        } 
        }); 
        
        setSize(1150,450);
        setTitle("Manager Main Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
      private void updateRoomStatus(Date today){
        bookingControl.updateRoomStatus(simpleDateFormat.format(today));
    }
    
}
