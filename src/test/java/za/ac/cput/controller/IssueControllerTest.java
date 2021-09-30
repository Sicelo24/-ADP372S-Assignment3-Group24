package za.ac.cput.controller;

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
import za.ac.cput.factory.IssueFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IssueControllerTest {

    private static Issue xxx = IssueFactory.createIssue("Not enough seats","Sport- field","06/25/20","N/A",true, false,false);
    private static String issueID = null;
    private static Issue thisIssue = null;
    @Autowired
    TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/issue";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Issue> postResponse = restTemplate.postForEntity(url, xxx, Issue.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        issueID = postResponse.getBody().getIssueId();
        thisIssue = postResponse.getBody();
        //assertEquals(xxx.getId(), postResponse.getBody().getId()); On create the ID is reGenerated
        System.out.println("Created: " + postResponse.getBody());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + issueID;
        ResponseEntity<Issue> response = restTemplate.getForEntity(url, Issue.class);
        // assertNotNull(response); Too wide...
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Issue update = new Issue.Builder().copy(thisIssue).issueArea("Sport").build();
        String url = BASE_URL + "/update";
        ResponseEntity<Issue> response = restTemplate.postForEntity(url, update, Issue.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + issueID;
        restTemplate.delete(url);
        System.out.println("Deleted: " + issueID);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("GetAll: " + response.getBody());
    }
}