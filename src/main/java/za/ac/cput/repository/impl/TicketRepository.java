package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
