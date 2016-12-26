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
public class EmployeeTest {
    
    public EmployeeTest() {
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
     * Test of getEmployeeId method, of class Employee.
     */
    @Test
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        String expResult = "S10";
        String result = instance.getEmployeeId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmployeeId method, of class Employee.
     */
    @Test
    public void testSetEmployeeId() {
        System.out.println("setEmployeeId");
        String employeeId = "";
        Employee instance = new Employee();
        instance.setEmployeeId(employeeId);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeeName method, of class Employee.
     */
    @Test
    public void testGetEmployeeName() {
        System.out.println("getEmployeeName");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        String expResult = "Lee";
        String result = instance.getEmployeeName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmployeeName method, of class Employee.
     */
    @Test
    public void testSetEmployeeName() {
        System.out.println("setEmployeeName");
        String employeeName = "";
        Employee instance = new Employee();
        instance.setEmployeeName(employeeName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeeAge method, of class Employee.
     */
    @Test
    public void testGetEmployeeAge() {
        System.out.println("getEmployeeAge");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        int expResult = 20;
        int result = instance.getEmployeeAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmployeeAge method, of class Employee.
     */
    @Test
    public void testSetEmployeeAge() {
        System.out.println("setEmployeeAge");
        int employeeAge = 0;
        Employee instance = new Employee();
        instance.setEmployeeAge(employeeAge);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeeAddress method, of class Employee.
     */
    @Test
    public void testGetEmployeeAddress() {
        System.out.println("getEmployeeAddress");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        String expResult = "123, Taman Bunga, Jalan Bahagia 6, 51450 KL";
        String result = instance.getEmployeeAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmployeeAddress method, of class Employee.
     */
    @Test
    public void testSetEmployeeAddress() {
        System.out.println("setEmployeeAddress");
        String employeeAddress = "";
        Employee instance = new Employee();
        instance.setEmployeeAddress(employeeAddress);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeeGender method, of class Employee.
     */
    @Test
    public void testGetEmployeeGender() {
        System.out.println("getEmployeeGender");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        String expResult = "Male";
        String result = instance.getEmployeeGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmployeeGender method, of class Employee.
     */
    @Test
    public void testSetEmployeeGender() {
        System.out.println("setEmployeeGender");
        String employeeGender = "";
        Employee instance = new Employee();
        instance.setEmployeeGender(employeeGender);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeeTelephoneNo method, of class Employee.
     */
    @Test
    public void testGetEmployeeTelephoneNo() {
        System.out.println("getEmployeeTelephoneNo");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        String expResult = "0123456789";
        String result = instance.getEmployeeTelephoneNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmployeeTelephoneNo method, of class Employee.
     */
    @Test
    public void testSetEmployeeTelephoneNo() {
        System.out.println("setEmployeeTelephoneNo");
        String employeeTelephoneNo = "";
        Employee instance = new Employee();
        instance.setEmployeeTelephoneNo(employeeTelephoneNo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmployeePassword method, of class Employee.
     */
    @Test
    public void testGetEmployeePassword() {
        System.out.println("getEmployeePassword");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        String expResult = "asd";
        String result = instance.getEmployeePassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmployeePassword method, of class Employee.
     */
    @Test
    public void testSetEmployeePassword() {
        System.out.println("setEmployeePassword");
        String employeePassword = "";
        Employee instance = new Employee();
        instance.setEmployeePassword(employeePassword);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDepartmentId method, of class Employee.
     */
    @Test
    public void testGetDepartmentId() {
        System.out.println("getDepartmentId");
        Employee instance = new Employee("S10","Lee", 20, "123, Taman Bunga, Jalan Bahagia 6, 51450 KL", "Male", "0123456789", "asd", "i don know");
        String expResult = "i don know";
        String result = instance.getDepartmentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setDepartmentId method, of class Employee.
     */
    @Test
    public void testSetDepartmentId() {
        System.out.println("setDepartmentId");
        String departmentId = "";
        Employee instance = new Employee();
        instance.setDepartmentId(departmentId);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
