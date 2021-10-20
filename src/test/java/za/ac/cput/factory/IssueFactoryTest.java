package za.ac.cput.factory;

/* IssueFactoryTest.java Class
 * Entity for Testing creation of issue through IssueFactory
 * Author: Athenkosi Zono (218030185)
 * Date: 10 June 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Issue;

import static org.junit.jupiter.api.Assertions.*;

class IssueFactoryTest {

    Issue issue, issue2, issue3, issue4;
    @BeforeEach
    void setup(){
        issue = IssueFactory.createIssue("k45j","No Elevator to 3rd floor", "Disability",
                "05/06/21","NA",0, 1,1);

        issue2 = IssueFactory.createIssue("k228","Not enough Lecturers", "Academic",
                "20/02/21","03/05/21",1, 0,0);
        issue3 = issue;
    }

    @Test void testEquality(){
        issue4 = new Issue.Builder().copy(issue).build();
        assertEquals(issue.getIssueArea(), issue4.getIssueArea());
        System.out.println("Objects are equal because issue was copied into issue4");
    }

    @Test void testIdentity(){
        assertSame(issue, issue3);
        System.out.println("Objects are Identical");
    }

    @Timeout(11000)
    @Test void testTimeout() throws InterruptedException {
        Thread.sleep(11000);
        assertNotNull(issue);
        System.out.println("Timeout display after 11 seconds");
    }

    @Disabled("Disabled this test")
    @Test void testDisabled(){
       assertNotNull(issue2);
    }

}