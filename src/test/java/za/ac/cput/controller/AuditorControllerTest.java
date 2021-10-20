package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Auditor;
import za.ac.cput.factory.AuditorFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class AuditorControllerTest {
    private static Auditor auditor = AuditorFactory.buildAuditor("145", "Lindokuhle", "Xaki", "0215485");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/auditor";

    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        ResponseEntity<Auditor> postResponse = restTemplate.postForEntity(url, auditor, Auditor.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        auditor = postResponse.getBody();
        System.out.println("Saved data: " + auditor);
        assertEquals(auditor.getAuditorID(), postResponse.getBody().getAuditorID());

    }

    @Test
    void b_read(){
        String url = BASE_URL + "/read/03470f0f-54ed-457b-a0cd-4bde69891f17";// + auditor.getAuditorID();
        System.out.println("URL: " + url);
        ResponseEntity<Auditor> response = restTemplate.getForEntity(url, Auditor.class);
        //assertEquals(auditor.getAuditorID(), response.getBody().getAuditorID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update(){
        Auditor updated = new Auditor.Builder().copy(auditor).setAuditorID("1234").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Auditor> response = restTemplate.postForEntity(url, updated, Auditor.class);
        assertNotNull(response.getBody());

    }

    @Test
    void e_delete(){
        String url = BASE_URL + "/delete" + auditor.getAuditorID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll(){
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}