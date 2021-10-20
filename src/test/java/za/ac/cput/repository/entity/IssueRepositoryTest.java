/* IssueRepositoryTest.java Class
 * Entity for Issue Repository Test
 * Author: Athenkosi Zono (218030185)
 * Date: 28 July 2021
 */

package za.ac.cput.repository.entity;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Issue;
import za.ac.cput.factory.IssueFactory;
import za.ac.cput.repository.entity.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class IssueRepositoryTest {

    private static Issue issue = IssueFactory.createIssue("k229","No Elevator to 3rd floor", "Disability",
            "05/06/21","NA",0, 1,0);

    private static Issue issue_2 = IssueFactory.createIssue("k230","Not enough Lecturers", "Academic",
            "","",0, 0,0);

    private static IssueRepository issueRepository = IssueRepository.createIssueRepository();

    @Test
    void a_create() {
       Issue repoIssue = issueRepository.create(issue);
       issueRepository.create(issue_2);
       assertEquals(issue, repoIssue);
    }

    @Test
    void b_read() {
        assertNotNull(issueRepository.read(issue.getIssueId()));
        System.out.println(issueRepository.read(issue.getIssueId()));
    }

    @Test
    void c_update() {
        Issue updatedIssue = new Issue.Builder().copy(issue_2).issueDescription("Not Qualified Staff").build();
        assertNotNull(issueRepository.update(updatedIssue));
    }

    @Test
    void d_delete() {
        boolean success = issueRepository.delete(issue.getIssueId());
        assertTrue(success);
        System.out.println("Issue deleted.");
    }

    @Test
    void e_getAll() {
        assertEquals(1, issueRepository.getAll().size());
        System.out.println(issueRepository.getAll());
    }
}