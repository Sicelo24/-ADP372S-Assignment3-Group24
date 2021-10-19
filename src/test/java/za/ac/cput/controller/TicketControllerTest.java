/* Ticket.java Class
 * Entity for TicketControllerTest
 * Author: Sicelo Zitha (216140943)
 * Date: 18 September 2021
 */
package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Issue;
import za.ac.cput.entity.Ticket;
import za.ac.cput.factory.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class TicketControllerTest {
    private static Ticket ticket = TicketFactory.buildTicket("205"
            , "Academics"
            , "22/09/2021");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ticket";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Ticket> postResponse = restTemplate.postForEntity(url, ticket, Ticket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        ticket = postResponse.getBody();
        System.out.println("Saved data: " + postResponse.getBody());
        //assertEquals(ticket.getTicketId(), postResponse.getBody().getTicketId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + ticket.getTicketId();
        System.out.println("URL: " + url);
        ResponseEntity<Ticket> response = restTemplate.getForEntity(url, Ticket.class);
        assertEquals(ticket.getTicketId(), response.getBody().getTicketId());
    }

    @Test
    void c_update() {

    }

    @Test
    void d_delete(){

    }

    @Test
    void e_getAll() {
    }
}