/* TicketRepositoryTest.java Class
 * Author: Sicelo Zitha (216140943)
 * Date: 26 July 2021
 */
package za.ac.cput.repository.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Ticket;
import za.ac.cput.factory.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;


class TicketRepositoryTest {

    TicketRepository repository;
    Ticket ticket;

    @BeforeEach
    void setUp() {
        repository = TicketRepository.getRepository();
        ticket = TicketFactory.buildTicket("444"
                , "Received"
                , "12 July"
                );
    }

    @Test
    void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    void create() {
        repository.create(ticket);
        assertNotNull(repository.read(ticket.getTicketId()));
        System.out.println("Created\n" + repository.read(ticket.getTicketId()));
    }

    @Test
    void read() {
        assertNotNull(repository.read(ticket.getTicketId()));
        System.out.println("Read\n" + repository.read(ticket.getTicketId()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        repository.delete("444");
        assertNull(repository.read("444"));
        System.out.println("Deleted\n" + repository.read("444"));
    }

    @Test
    void getAll() {
        repository.create(ticket);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }
}