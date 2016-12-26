/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Panda
 */
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomerId method, of class Customer.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Customer instance = new Customer("C52", "Abby", "123 Taman Aman", "Female", "0103456789", 10, "M1");
        String expResult = "C52";
        String result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCustomerId method, of class Customer.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        String customerId = "";
        Customer instance = new Customer();
        instance.setCustomerId(customerId);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCustomerName method, of class Customer.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Customer instance = new Customer("C52", "Abby", "123 Taman Aman", "Female", "0103456789", 10, "M1");
        String expResult = "Abby";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCustomerName method, of class Customer.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        Customer instance = new Customer();
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCustomerAddress method, of class Customer.
     */
    @Test
    public void testGetCustomerAddress() {
        System.out.println("getCustomerAddress");
        Customer instance = new Customer("C52", "Abby", "123 Taman Aman", "Female", "0103456789", 10, "M1");
        String expResult = "123 Taman Aman";
        String result = instance.getCustomerAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of setCustomerAddress method, of class Customer.
     */
    @Test
    public void testSetCustomerAddress() {
        System.out.println("setCustomerAddress");
        String customerAddress = "";
        Customer instance = new Customer();
        instance.setCustomerAddress(customerAddress);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCustomerGender method, of class Customer.
     */
    @Test
    public void testGetCustomerGender() {
        System.out.println("getCustomerGender");
        Customer instance = new Customer("C52", "Abby", "123 Taman Aman", "Female", "0103456789", 10, "M1");
        String expResult = "Female";
        String result = instance.getCustomerGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCustomerGender method, of class Customer.
     */
    @Test
    public void testSetCustomerGender() {
        System.out.println("setCustomerGender");
        String customerGender = "";
        Customer instance = new Customer();
        instance.setCustomerGender(customerGender);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of getCustomerTelephoneNo method, of class Customer.
     */
    @Test
    public void testGetCustomerTelephoneNo() {
        System.out.println("getCustomerTelephoneNo");
        Customer instance = new Customer("C52", "Abby", "123 Taman Aman", "Female", "0103456789", 10, "M1");
        String expResult = "0103456789";
        String result = instance.getCustomerTelephoneNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCustomerTelephoneNo method, of class Customer.
     */
    @Test
    public void testSetCustomerTelephoneNo() {
        System.out.println("setCustomerTelephoneNo");
        String customerTelephoneNo = "";
        Customer instance = new Customer();
        instance.setCustomerTelephoneNo(customerTelephoneNo);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCustomerPoint method, of class Customer.
     */
    @Test
    public void testGetCustomerPoint() {
        System.out.println("getCustomerPoint");
        Customer instance = new Customer("C52", "Abby", "123 Taman Aman", "Female", "0103456789", 10, "M1");
        int expResult = 10;
        int result = instance.getCustomerPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCustomerPoint method, of class Customer.
     */
    @Test
    public void testSetCustomerPoint() {
        System.out.println("setCustomerPoint");
        int customerPoint = 0;
        Customer instance = new Customer();
        instance.setCustomerPoint(customerPoint);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getEmployeeId method, of class Customer.
     */
    @Test
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        Customer instance = new Customer("C52", "Abby", "123 Taman Aman", "Female", "0103456789", 10, "M1");
        String expResult = "M1";
        String result = instance.getEmployeeId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setEmployeeId method, of class Customer.
     */
    @Test
    public void testSetEmployeeId() {
        System.out.println("setEmployeeId");
        String employeeId = "";
        Customer instance = new Customer();
        instance.setEmployeeId(employeeId);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
