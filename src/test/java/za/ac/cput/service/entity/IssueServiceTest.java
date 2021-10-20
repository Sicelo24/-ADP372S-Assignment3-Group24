/* IssueServiceTest.java Class
 * Entity for Issue Service Test
 * Author: Athenkosi Zono (218030185)
 * Date: 28 July 2021
 */

package za.ac.cput.service.entity;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Issue;
import za.ac.cput.factory.IssueFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class IssueServiceTest {

    @Autowired
    private static IssueService service;
    private static Issue issue = IssueFactory.createIssue("k227","No Elevator to 3rd floor", "Disability",
            "05/06/21","NA",1, 0,1);

    @Test
    void a_create() {
        Issue success = this.service.create(issue);
        assertNotNull(success);
        System.out.println("Created issue "+issue);
    }

    @Test
    void b_read() {
        Issue readIssue = this.service.read(issue.getIssueId());
        assertEquals("Disability", issue.getIssueArea());
        System.out.println("Issue Read Success\n"+readIssue);
    }

    @Test
    void c_update() {
        Issue updatedIssue = new Issue.Builder().copy(issue).issueDescription("No Elevator at all").build();
        service.update(updatedIssue);
        assertEquals("No Elevator at all", this.service.read(issue.getIssueId()).getIssueDescription());
        System.out.println("Updated Issue Description.\n"+service.read(issue.getIssueId()));
    }

    @Test
    void d_delete() {
        boolean success = service.delete(issue.getIssueId());
        assertTrue(success);
        System.out.println("Issue successfully deleted.");
    }

    @Test
    void e_getAll() {
        assertEquals(2, service.getAll().size());
        System.out.println(service.getAll());
    }
}