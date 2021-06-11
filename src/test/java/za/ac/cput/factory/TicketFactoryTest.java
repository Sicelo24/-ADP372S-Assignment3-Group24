/*
        @Author : Sicelo Zitha 216140943
        TicketFactoryTest class
        date 6 June 2021

*/
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Ticket;


import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {
    Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = TicketFactory.buildTicket("2",
                "Student card complaint",
                "10/03/2020",
                "7");
    }
    @Test
    void buildUser(){
        assertNotNull(ticket);
        System.out.println(ticket);
    }

}