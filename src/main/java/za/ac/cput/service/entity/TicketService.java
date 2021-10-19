package za.ac.cput.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Ticket;
import za.ac.cput.repository.impl.TicketRepository;
import za.ac.cput.service.impl.ITicketService;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository repository;

    @Override
    public Ticket create(Ticket ticket) {
        return this.repository.save(ticket);
    }

    @Override
    public Ticket read(String ticketID) {
        return this.repository.findById(ticketID).orElse(null);
    }

    @Override
    public Ticket update(Ticket ticket) {
        if (this.repository.existsById(ticket.getTicketId()))
            return repository.save(ticket);
            return null;
    }

    @Override
    public boolean delete(String ticketID) {
        this.repository.deleteById(ticketID);
        if (this.repository.existsById(ticketID))
            return false;
        else
            return true;
    }

    public Set<Ticket> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
