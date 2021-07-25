package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {

    IssueRepository issueRepository;
    @BeforeEach void setup(){
        issueRepository = IssueRepository.createIssueRepository();
    }

    @Test
    void create() {
        // Under Construction
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
        assertNotNull(issueRepository.getAll());
        System.out.println(issueRepository.getAll());
    }
}