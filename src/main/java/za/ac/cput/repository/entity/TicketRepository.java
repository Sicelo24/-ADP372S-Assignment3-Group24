/* TicketRepository.java Class
 * Author: Sicelo Zitha (216140943)
 * Date: 26 July 2021
 */
package za.ac.cput.repository.entity;

import za.ac.cput.entity.Ticket;
import za.ac.cput.repository.impl.ITicketRepository;

import java.util.*;

@Deprecated
public class TicketRepository implements ITicketRepository {
    private static TicketRepository repository = null;
    private Map<String, Ticket> tickets;

    private TicketRepository(){

        this.tickets = new HashMap<>();
    }

    public static TicketRepository getRepository(){
        if(repository == null) repository = new TicketRepository();
        return repository;

    }

    @Override
    public Ticket create(Ticket ticket) {
        if(read(ticket.getTicketId())  == null){
            this.tickets.put(ticket.getTicketId(),ticket);
        }
        return ticket;
    }

    @Override
    public Ticket read(String s) {
        return this.tickets.get(s);
    }

    @Override
    public Ticket update(Ticket ticket) {
        if(read(ticket.getTicketId()) != null){
            tickets.replace(ticket.getTicketId(), ticket);
        }
        return ticket;
    }

    @Override
    public boolean delete(String s) {
        Ticket ticket = read(s);
        this.tickets.remove(s, ticket);
        if (s == null)
            return false;
        tickets.remove(s);

        return true;
    }
    @Override
    public Set<Ticket> getAll() {
        Collection<Ticket> tickets = this.tickets.values();
        Set<Ticket> set = new HashSet<>();
        set.addAll(tickets);
        return set;
    }
}


