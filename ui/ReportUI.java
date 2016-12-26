package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import static ui.StaffMainMenu.simpleDateFormat;
import control.MaintainBooking;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReportUI extends JFrame{ 
    
     ImageIcon reportIcon = new ImageIcon("Image/report1.jpg");
    JButton summaryReport = new JButton("Customer Report",reportIcon);
    JButton detailReport = new JButton("Detail Report",reportIcon);
    JButton exceptionReport = new JButton("Exception Report",reportIcon);
    JButton summaryReport1 = new JButton("Payment Report",reportIcon);
    private JLabel logoImage = new JLabel(new ImageIcon("Image/home.jpg"));
    JButton cancel = new JButton("Cancel ");
    JPanel btm = new JPanel(new FlowLayout(FlowLayout.CENTER));
    public ReportUI() {
        getContentPane().add(logoImage, BorderLayout.NORTH);
        JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        summaryReport.setHorizontalTextPosition(AbstractButton.CENTER);
        summaryReport.setVerticalTextPosition(AbstractButton.BOTTOM);
        detailReport.setHorizontalTextPosition(AbstractButton.CENTER);
        detailReport.setVerticalTextPosition(AbstractButton.BOTTOM);
        exceptionReport.setHorizontalTextPosition(AbstractButton.CENTER);
        exceptionReport.setVerticalTextPosition(AbstractButton.BOTTOM);
        summaryReport1.setHorizontalTextPosition(AbstractButton.CENTER);
        summaryReport1.setVerticalTextPosition(AbstractButton.BOTTOM);
                
        jpButton.add(summaryReport);
        summaryReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
{
                    try // event handler for button
                    {
                        String host = "jdbc:derby://localhost:1527/assignmentdb";
                        String user = "nbuser";
                        String password = "nbuser";
                        Connection conn = null;
                        
                        String reportSource = "./report/SummaryReport.jrxml";
                        
                        Map<String, Object> params = new HashMap<String, Object>();
                        
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        try {
                            conn = DriverManager.getConnection(host, user, password);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperReport jasperReport = null;
                        try {
                            jasperReport = JasperCompileManager.compileReport(reportSource);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                        JasperPrint jasperPrint = null;
                        try {
                            jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperViewer.viewReport(jasperPrint, false);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
}}});    
        
        jpButton.add(detailReport);
        detailReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
{
                    try // event handler for button
                    {
                        String host = "jdbc:derby://localhost:1527/assignmentdb";
                        String user = "nbuser";
                        String password = "nbuser";
                        Connection conn = null;
                        
                        String reportSource = "./report/DetailReport.jrxml";
                        
                        Map<String, Object> params = new HashMap<String, Object>();
                        
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        try {
                            conn = DriverManager.getConnection(host, user, password);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperReport jasperReport = null;
                        try {
                            jasperReport = JasperCompileManager.compileReport(reportSource);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                        JasperPrint jasperPrint = null;
                        try {
                            jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperViewer.viewReport(jasperPrint, false);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
}}});    
        
        jpButton.add(exceptionReport);
        exceptionReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
{
                    try // event handler for button
                    {
                        String host = "jdbc:derby://localhost:1527/assignmentdb";
                        String user = "nbuser";
                        String password = "nbuser";
                        Connection conn = null;
                        
                        String reportSource = "./report/ExceptionReport.jrxml";
                        
                        Map<String, Object> params = new HashMap<String, Object>();
                        
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        try {
                            conn = DriverManager.getConnection(host, user, password);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperReport jasperReport = null;
                        try {
                            jasperReport = JasperCompileManager.compileReport(reportSource);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                        JasperPrint jasperPrint = null;
                        try {
                            jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperViewer.viewReport(jasperPrint, false);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
}}});    
        jpButton.add(summaryReport1);
        summaryReport1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
{
                    try // event handler for button
                    {
                        String host = "jdbc:derby://localhost:1527/assignmentdb";
                        String user = "nbuser";
                        String password = "nbuser";
                        Connection conn = null;
                        
                        String reportSource = "./report/SummaryReport1.jrxml";
                        
                        Map<String, Object> params = new HashMap<String, Object>();
                        
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        try {
                            conn = DriverManager.getConnection(host, user, password);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperReport jasperReport = null;
                        try {
                            jasperReport = JasperCompileManager.compileReport(reportSource);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                        JasperPrint jasperPrint = null;
                        try {
                            jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                        } catch (JRException ex) {
                            Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JasperViewer.viewReport(jasperPrint, false);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
}}});    
        add(jpButton, BorderLayout.CENTER);
        
        btm.add(cancel);
        cancel.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent ae) { 
            dispose();
        }}); 
        add(btm, BorderLayout.SOUTH);
        
        setSize(950,450);
        setTitle("Report");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
   }
    
}
