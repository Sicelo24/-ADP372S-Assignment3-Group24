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

    private static Issue issue = IssueFactory.createIssue("No Elevator to 3rd floor", "Disability",
            "05/06/21","NA",true, false,true);

    private static Issue issue_2 = IssueFactory.createIssue("Not enough Lecturers", "Academic",
            "","",true, false,false);

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
        Issue updatedIssue = IssueFactory.copyFromIssue(issue_2).setIssueDescription("Not Qualified Staff");
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