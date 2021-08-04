package za.ac.cput.service.entity;

import za.ac.cput.entity.Ticket;
import za.ac.cput.repository.entity.TicketRepository;
import za.ac.cput.service.impl.ITicketService;

import java.util.Set;

public class TicketService implements ITicketService {

    private static TicketService ticketService = null;
    private static TicketRepository repository = null;

    private TicketService(){repository = TicketRepository.getRepository();
    }

    public static TicketService createTicketService(){
        if(ticketService == null) ticketService = new TicketService();
        return ticketService;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return repository.create(ticket);
    }

    @Override
    public Ticket read(String s) {
        return repository.read(s);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return repository.update(ticket);
    }

    @Override
    public boolean delete(String s) {
        return repository.delete(s);
    }

    @Override
    public Set<Ticket> getAll() {
        return repository.getAll();
    }
}
