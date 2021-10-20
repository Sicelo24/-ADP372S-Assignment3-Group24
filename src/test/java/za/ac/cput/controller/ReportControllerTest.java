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
import za.ac.cput.entity.Report;
import za.ac.cput.factory.ReportFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ReportControllerTest {

    private static Report report = ReportFactory.createReport("215126505"
            ,"Mr. Xakekile"
            ,"NA"
            , "20/09/2021");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/report/";

    @Test
    public void a_create() {

        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + report);
        ResponseEntity<Report> postResponse = restTemplate
                .postForEntity(url,report,Report.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        report = postResponse.getBody();
        System.out.println("Saved data: " + report);
        assertEquals(report.getReportId(),postResponse.getBody().getReportId());

    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + report.getReportId();
        System.out.println("URL: " + url);
        ResponseEntity<Report> response = restTemplate
                .getForEntity(url,Report.class);
        report = response.getBody();
        assertEquals(report.getReportId(), response.getBody().getReportId());

    }

    @Test
    public void c_update() {
        Report updated = new Report.Builder().copy(report).setReportDate("07/01/2021").setReportId("25250").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Report> response = restTemplate
                .postForEntity(url,updated, Report.class);
        System.out.println(report);
        assertEquals(report.getReportDate(),response.getBody().getReportDate());

    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + report.getReportId();
        System.out.println("URL: " + url);
        restTemplate
                .delete(url);
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

}