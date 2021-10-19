//package za.ac.cput.service.entity;

//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Ticket;
//import za.ac.cput.factory.TicketFactory;

//import java.util.Set;

//import static org.junit.jupiter.api.Assertions.*;


//@TestMethodOrder(MethodOrderer.MethodName.class)
//class TicketServiceTest {

   //private static TicketService service = TicketService.createTicketService();
   //private static Ticket ticket = TicketFactory.buildTicket("27"
           //, "Reg Issues"
           //, "17/08/2021"
           //, "34");


    //@Test
    //void create() {
     //Ticket generate = service.create(ticket);
     //assertEquals(ticket.getTicketId(), generate.getTicketId());
     //System.out.println("Created: " + generate);
    //}

    //@Test
    //void read() {
     //Ticket read = service.read(ticket.getTicketId());
     //assertEquals("27", ticket.getTicketId());
     //System.out.println("Created" + "\n " + read );
    //}

    //@Test
    //void update() {
     //Ticket updated = new Ticket.Builder().copy(ticket).
       //      ticketId("28").build();

     //updated = service.update(updated);
     //assertEquals(ticket.getTicketId(), updated.getTicketId());
     //System.out.println("Updated ticket\n" +updated );
    //}

    //@Test
    //void delete() {
     //service.delete("27");
     //assertNull(service.read(ticket.getTicketDescription()));
     //System.out.println("Delete\n"+service.read(ticket.getTicketDescription()));
    //}

    //@Test
    //void getAll() {
     //Set<Ticket> ticketSet = service.getAll();
     //assertEquals(0,ticketSet.size());
     //System.out.println("" + ticketSet);
    //}
//}