package za.ac.cput.service.impl;

import za.ac.cput.entity.Ticket;
import za.ac.cput.service.IService;
import java.util.Set;

public interface ITicketService extends IService<Ticket, String> {
    public Set<Ticket> getAll();
}
