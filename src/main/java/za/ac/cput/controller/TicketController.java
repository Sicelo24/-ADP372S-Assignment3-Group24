/* Ticket.java Class
 * Entity for TicketController
 * Author: Sicelo Zitha (216140943)
 * Date: 18 September 2021
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Issue;
import za.ac.cput.entity.Ticket;
import za.ac.cput.factory.TicketFactory;
import za.ac.cput.service.entity.TicketService;
import java.util.Set;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    //@RequestMapping(value = "create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket) {
        Ticket newTicket = TicketFactory.buildTicket(ticket.getTicketId()
                , ticket.getTicketDate()
                , ticket.getTicketDescription());
        return service.create(newTicket);
    }

    @GetMapping("/read/{id}")
    public Ticket read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Ticket update(@RequestBody Ticket ticket) {
        return service.update(ticket);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable String ticketID){
        return service.delete(ticketID) ? "Successfully deleted." : "Could NOT Perform delete operation!";
    }

    @GetMapping("/getall")
    public Set<Ticket> getAll() {
        return service.getAll();
    }
}
