package za.ac.cput.factory;

/* IssueFactoryTest.java Class
 * Entity for Testing creation of issue through IssueFactory
 * Author: Athenkosi Zono (218030185)
 * Date: 10 June 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Issue;

import static org.junit.jupiter.api.Assertions.*;

class IssueFactoryTest {

    Issue issue;
    @BeforeEach
    void setup(){
        issue = IssueFactory.createIssue("No Elevator to 3rd floor", "Disability",
                "05/06/21","NA",true, false,true);
    }

    @Test void createIssue(){
        assertNotNull(issue);
    }

    @Test void checkId(){
        assertNotNull(issue.getIssueId(), "Random Id was generated success.");
        System.out.println(issue.getIssueId());
    }
}