/* Ticket.java Class
 * Entity for TicketController
 * Author: Sicelo Zitha (216140943)
 * Date: 18 September 2021
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Ticket;
import za.ac.cput.factory.TicketFactory;
import za.ac.cput.service.entity.TicketService;

import java.util.Set;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService service;

    @RequestMapping(value = "create", method = RequestMethod.POST)

    public Ticket create(@RequestBody Ticket ticket) {
        //@PostMapping("/create")
        Ticket newTicket = TicketFactory.buildTicket(ticket.getTicketId()
                , ticket.getTicketDate()
                , ticket.getTicketDescription()
                , ticket.getTicketIssue());
        return service.create(newTicket);
    }

    @GetMapping("/read")
    public Ticket read(@RequestBody String id) {
        return service.read(id);
    }

    @PostMapping("/update")
    public Ticket update(@RequestBody Ticket ticket) {
        return service.update(ticket);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody String id){
        return service.delete(id) ? "Successfully deleted." : "Could NOT Perform delete operation!";
    }

    @GetMapping("/getall")
    public Set<Ticket> getAll() {
        return service.getAll();
    }
}
