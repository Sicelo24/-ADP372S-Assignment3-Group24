/*
        @Author : Sicelo Zitha 216140943
        TicketFactoryTest class
        date 6 June 2021

*/
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Ticket;


import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {
    Ticket ticket, ticket2, ticket3, ticket4;

    void setUp() {
        ticket = TicketFactory.buildTicket("2",
                "Student card complaint",
                "10/03/2020");
        ticket2 = TicketFactory.buildTicket("5",
                "Student marks complaint",
                "14/03/2020");
        ticket3 = ticket;
    }

    @Test
    void buildUser() {
        assertNotNull(ticket);
        System.out.println(ticket);
    }

    @Test
    void testEquality() {
        ticket4 = ticket;
        System.out.println("Objects are equal");
    }

    @Test
    void testIdentity() {
        assertSame(ticket, ticket3);
        System.out.println("Objects are Identical");
    }

    @Timeout(16000)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(10000);
        assertNotNull(ticket);
        System.out.println("Timeout display after 10 seconds");
    }

    @Test
    void testDisabled() {
        assertNotNull(ticket2);
    }
}