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
public class RoomTest {
    
    public RoomTest() {
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
     * Test of getRoomId method, of class Room.
     */
    @Test
    public void testGetRoomId() {
        System.out.println("getRoomId");
        Room instance = new Room("R166", "Single Room", 150.00, "Available", "Good environment");
        String expResult = "R166";
        String result = instance.getRoomId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setRoomId method, of class Room.
     */
    @Test
    public void testSetRoomId() {
        System.out.println("setRoomId");
        String roomId = "";
        Room instance = new Room();
        instance.setRoomId(roomId);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getRoomType method, of class Room.
     */
    @Test
    public void testGetRoomType() {
        System.out.println("getRoomType");
        Room instance = new Room("R166", "Single Room", 150.00, "Available", "Good environment");
        String expResult = "Single Room";
        String result = instance.getRoomType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRoomType method, of class Room.
     */
    @Test
    public void testSetRoomType() {
        System.out.println("setRoomType");
        String roomType = "";
        Room instance = new Room();
        instance.setRoomType(roomType);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getRoomPrice method, of class Room.
     */
    @Test
    public void testGetRoomPrice() {
        System.out.println("getRoomPrice");
        Room instance = new Room("R166", "Single Room", 150.00, "Available", "Good environment");
        double expResult = 150.00;
        double result = instance.getRoomPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setRoomPrice method, of class Room.
     */
    @Test
    public void testSetRoomPrice() {
        System.out.println("setRoomPrice");
        double roomPrice = 0.0;
        Room instance = new Room();
        instance.setRoomPrice(roomPrice);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getRoomStatus method, of class Room.
     */
    @Test
    public void testGetRoomStatus() {
        System.out.println("getRoomStatus");
        Room instance = new Room("R166", "Single Room", 150.00, "Available", "Good environment");
        String expResult = "Available";
        String result = instance.getRoomStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setRoomStatus method, of class Room.
     */
    @Test
    public void testSetRoomStatus() {
        System.out.println("setRoomStatus");
        String roomStatus = "";
        Room instance = new Room();
        instance.setRoomStatus(roomStatus);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getRoomDescription method, of class Room.
     */
    @Test
    public void testGetRoomDescription() {
        System.out.println("getRoomDescription");
        Room instance = new Room("R166", "Single Room", 150.00, "Available", "Good environment");
        String expResult = "Good environment";
        String result = instance.getRoomDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setRoomDescription method, of class Room.
     */
    @Test
    public void testSetRoomDescription() {
        System.out.println("setRoomDescription");
        String roomDescription = "";
        Room instance = new Room();
        instance.setRoomDescription(roomDescription);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
