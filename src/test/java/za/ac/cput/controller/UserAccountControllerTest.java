package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Issue;
import za.ac.cput.entity.Ticket;
import za.ac.cput.entity.UserAccount;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserAccountControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/useraccount";


    @Test
    void login() {
        String url = BASE_URL + "/login/az@za/123";
        ResponseEntity<UserAccount> response = restTemplate.getForEntity(url, UserAccount.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test @Disabled("Disabled read") void b_read() {
        String url = BASE_URL + "/read/test25";
        ResponseEntity<UserAccount> response = restTemplate.getForEntity(url, UserAccount.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test void d_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("GetAll: " + response.getBody());
    }



}