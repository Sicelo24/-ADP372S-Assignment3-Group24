package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Issue;
import za.ac.cput.factory.IssueFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IssueControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static Issue issue = IssueFactory.createIssue("k228","More Security is needed","Admin Building","31/05/19","NA",1, 1,1);
    private final String BASE_URL = "http://localhost:8080/issue";

    @Test @Disabled("Disabled create") void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Issue> postResponse = restTemplate.postForEntity(url, issue, Issue.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        issue = postResponse.getBody();
        assertEquals(issue.getIssueId(), postResponse.getBody().getIssueId());
        System.out.println("Created: " + postResponse.getBody());
    }

    @Test @Disabled("Disabled read") void b_read() {
        String url = BASE_URL + "/read/" + issue.getIssueId();
        ResponseEntity<Issue> response = restTemplate.getForEntity(url, Issue.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test @Disabled("Disabled update") void c_update() {
        Issue update = new Issue.Builder().copy(issue).issueArea("Sport").build();
        String url = BASE_URL + "/update";
        ResponseEntity<Issue> response = restTemplate.postForEntity(url, update, Issue.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }


    @Test @Disabled("Disabled delete") void e_delete() {
        String url = BASE_URL + "/delete/" + issue.getIssueId();
        restTemplate.delete(url);
        System.out.println("Deleted: " + issue.getIssueId()+"\nAt "+url);
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

    @Test void f_getResolved() {
        String url = BASE_URL + "/getallopen";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("GetAllResolved: " + response.getBody());
    }

    @Test void g_getUnResolved() {
        String url = BASE_URL + "/getallunresolved";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("GetAllNotResolved: " + response.getBody());
    }
}